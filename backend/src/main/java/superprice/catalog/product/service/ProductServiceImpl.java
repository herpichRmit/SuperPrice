package superprice.catalog.product.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superprice.catalog.product.exception.ProductNotFoundException;
import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.Product;
import superprice.catalog.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
	}

    @Override
    public Optional<Product> getProduct(Long id) {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)));
    }

    @Override
    public List<Product> getProductsByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public Collection<Category> categories() {

        throw new UnsupportedOperationException();
    }

    public List<Product> getProductsByKeyword(String keyword) {
        return productRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> sortbyPrice(String keyword) {
        return productRepository.testSQL(keyword);
    }

}

