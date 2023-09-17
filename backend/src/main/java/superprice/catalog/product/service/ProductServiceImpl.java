package superprice.catalog.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superprice.catalog.product.exception.ProductNotFoundException;
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
}
