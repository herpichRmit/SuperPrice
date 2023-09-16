package superprice.catalog.service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superprice.catalog.model.Product;
import superprice.catalog.model.Store;
import superprice.catalog.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct()
    {
		return List.of(
			new Product(
				1L,
				"Ajax spray and wipe",
				"COLES",
				15.43,
				"Kills 99.9% of germs"
			)
		);
	}

    @Override
    public List<Product> findAll()
    {
    	List<Product> my_products = productRepository.findAll();
    	// ...
    	return my_products;
    }

    @Override
    public List<Product> getResults()
    {
    	List<Product> my_products = productRepository.findAll();
    	// ...
    	return my_products;
    }

	@Override
	public List<Product> sortByPrice(String sterm) 
	    {
	    	List<Product> my_products = productRepository.sortByPrice(sterm);
	    	// ...
	    	return my_products;
	    }
	
	@Override
	public List<Product> filterByCategory(String sterm) 
	    {
	    	List<Product> my_products = productRepository.sortByPrice(sterm);
	    	// ...
	    	return my_products;
	    }
	
	@Override
	public List<Product> searchShowPrice(String sterm) 
	    {
	    	List<Product> my_products = productRepository.sortByPrice(sterm);
	    	// ...
	    	return my_products;
	    }
}
