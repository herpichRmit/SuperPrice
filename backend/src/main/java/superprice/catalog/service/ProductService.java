package superprice.catalog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import superprice.catalog.product.model.Product;
import superprice.catalog.model.Result;


public interface ProductService {
    public List<Product> getProduct();
	public List<Product> getResults();
	public List<Product> findAll();
	public List<Product> sortByPrice(String sterm);
	public ArrayList<Result> searchShowPrice(String sterm);
	List<Product> filterByCategory(String sterm);

}

