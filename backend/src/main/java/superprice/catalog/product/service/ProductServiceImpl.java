package superprice.catalog.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superprice.catalog.product.model.Product;
import superprice.catalog.product.model.Store;
import superprice.catalog.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct() {

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
}
