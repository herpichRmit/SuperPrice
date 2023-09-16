package superprice.catalog.service;

import java.util.List;

import superprice.catalog.model.Product;

public interface ProductService {
    public List<Product> getProduct();
	public List<Product> getResults();
	public List<Product> findAll();
	public List<Product> sortByPrice(String sterm);
	public List<Product> searchShowPrice(String sterm);
	List<Product> filterByCategory(String sterm);

}

