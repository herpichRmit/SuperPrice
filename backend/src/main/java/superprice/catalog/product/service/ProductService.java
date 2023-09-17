package superprice.catalog.product.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.Product;

public interface ProductService {
    public List<Product> getProducts();
    public Optional<Product> getProduct(Long id);
    public List<Product> getProductsByTitle(String title);
    public List<Product> sortbyPrice(String keyword);

    Collection<Category> categories ();
    public List<Product> getProductsByKeyword(String keyword);
    public List<Product> getProductsByCategory(String category);
}

