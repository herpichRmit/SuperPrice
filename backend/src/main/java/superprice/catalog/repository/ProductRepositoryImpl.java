package superprice.catalog.repository;
import superprice.catalog.model.Product;
import superprice.catalog.model.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.*;
import javax.sql.DataSource;

import java.sql.Connection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import org.antlr.v4.runtime.misc.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepositoryImpl implements ProductRepository
{

    private final DataSource dataSource;

    private Product getProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getLong("id"), rs.getString("title"),
        		           rs.getString("store"), rs.getString("category"), rs.getDouble("price"),
        		           rs.getString("item_description"));
    }


    @Override
    public List<Product> findAll() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = this.dataSource.getConnection();
            statement = conn.prepareStatement("SELECT * FROM products");
            List<Product> books = new ArrayList<>();
            rs = statement.executeQuery();
            while (rs.next()) {
                books.add(getProduct(rs));
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException("Error in findAll", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    @Override
    //search by string, returns all products with matching title
    //and sorts them from the lowest to highest price
    public List<Product> sortByPrice(String sterm) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = this.dataSource.getConnection();
            statement = conn.prepareStatement("SELECT * FROM products");
            List<Product> products = new ArrayList<>();
            ArrayList<Product> results = new ArrayList<Product>();
            rs = statement.executeQuery();
            while (rs.next()) {
            	products.add(getProduct(rs));
            }
    	    Collections.sort(products, new Comparator<Product>()
    	    {
    	    	public int compare(Product o1, Product o2)
    	    	{
    	    		return o1.getPrice().compareTo(o2.getPrice());
    	    	}
    	    });
    	    for (int i = 0; i < products.size(); i++)
    	    {
    	    	//change to user input 
    	    	if (products.get(i).getTitle().equals(sterm))
    	    			{
    	    		results.add(products.get(i));
    	    			}    	
    	    }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException("Error in findAll", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    @Override
    //see all results for certain category 
    public List<Product> filterByCategory(String sterm) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = this.dataSource.getConnection();
            //statement = conn.prepareStatement("SELECT * FROM products WHERE category = " + sterm);
            statement = conn.prepareStatement("SELECT * FROM products");
            List<Product> products = new ArrayList<>();
            ArrayList<Product> results = new ArrayList<Product>();
            rs = statement.executeQuery();
            while (rs.next()) {
            	products.add(getProduct(rs));
            }

    	    for (int i = 0; i < products.size(); i++)
    	    {
    	    	//change to user input 
    	    	if (products.get(i).getCategory().equals(sterm))
    	    			{
    	    		results.add(products.get(i));
    	    			}    	
    	    }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException("Error in findAll", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    //return product and prices 
    public ArrayList<Result> searchShowPrice(String sterm) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = this.dataSource.getConnection();
         //   statement = conn.prepareStatement("SELECT * FROM products WHERE title='" + sterm + "'");
            statement = conn.prepareStatement("SELECT * FROM products");
            List<Product> products = new ArrayList<>();
            ArrayList<Result> ress = new ArrayList<Result>();
            rs = statement.executeQuery();
            while (rs.next()) {
            	products.add(getProduct(rs));
            }
    	    for (int i = 0; i < products.size(); i++)
    	    {
    	    									//change to user input 
    	    	if (products.get(i).getTitle().equals(sterm))
    	    			{
    	    		String ttl = products.get(i).getTitle();
    	    		Double prc = products.get(i).getPrice();
    	    		String st = products.get(i).getStore();
    	    		Result r = new Result(ttl, prc, st);
    	            ress.add(r);
    	            System.out.println(r);
    	    			}    	
    	    }
    	    for (int i = 0; i < ress.size(); i++)
    	    {
    	    	System.out.println(ress.get(i).name);
    	    	System.out.println(ress.get(i).price);
    	    	System.out.println(ress.get(i).store);

    	    }
            return ress;
        } catch (SQLException e) {
            throw new RuntimeException("Error in findAll", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Optional<Product> findById(Long id)
    {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = this.dataSource.getConnection();
            statement = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
            statement.setLong(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(getProduct(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error in findById", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Product create(Product product) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = this.dataSource.getConnection();
            statement = conn.prepareStatement("INSERT INTO products (id, title, store, price, item_description) VALUES (?, ?, ?, ?, ?)");
            statement.setLong(1, product.getId());
            statement.setString(2, product.getTitle());
            statement.setString(3, product.getStore());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getStore());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
            throw new RuntimeException("Error in create", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = this.dataSource.getConnection();
            statement = conn.prepareStatement("DELETE FROM products WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            int row = statement.executeUpdate();

            if (row == 0) {
                throw new SQLException("Failed to delete product");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error in delete", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
    


    
    
    
}
