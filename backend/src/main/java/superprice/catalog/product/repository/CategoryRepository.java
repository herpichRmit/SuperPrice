package superprice.catalog.product.repository;

import jdk.javadoc.internal.doclets.toolkit.taglets.snippet.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.Price;
import superprice.catalog.product.model.Store;
import superprice.catalog.product.model.StructuredProduct;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@Repository
public class CategoryRepository {

    public DataSource dataSource;

    @Autowired
    public CategoryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Collection<Category> categories () {
            Collection<String> categoryNames = categoryNames ();
        Collection<Category> categories = new LinkedList<>();

        for (String name : categoryNames) {
            categories.add(categoryByName (name));
        }

        return categories;
    }

    private Category categoryByName(String name) {
        Collection<StructuredProduct> products = productsByCategoryName (name);
        
        return new Category(name, products);
    }

    private Collection<StructuredProduct> productsByCategoryName(String categoryName) {
        try {
            Collection<StructuredProduct> products = new LinkedList<StructuredProduct>();
            Connection conn = dataSource.getConnection();
            String sql
                    = "SELECT DISTINCT title, brand, item_description "
                    + "FROM product "
                    + "WHERE category = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoryName);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String brand = rs.getString("brand");
                String itemDescription = rs.getString("item_description");

                Collection<Price> prices = pricesByItemDetails (title, brand, categoryName, itemDescription);

                products.add(new StructuredProduct(title, brand, "", prices));
            }

            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Collection<Price> pricesByItemDetails(
            String title,
            String brand,
            String categoryName,
            String itemDescription
    ) {
        try {
            Collection<Price> prices = new LinkedList<>();
            Connection conn = dataSource.getConnection();
            String sql
                    = "SELECT store, price "
                    + "FROM product "
                    + "WHERE title = ? "
                    + "AND brand = ? "
                    + "AND category = ? "
                    + "AND item_description = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, brand);
            statement.setString(3, categoryName);
            statement.setString(4, itemDescription);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Store store = Store.fromString(rs.getString("store"));
                int priceCents = (int)(rs.getDouble("price"));

                prices.add(new Price(store, priceCents));
            }

            return prices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<String> categoryNames() {
        Collection<String> names = new LinkedList<>();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT DISTINCT category FROM product";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("category"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return names;
    }
}
