package superprice.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superprice.catalog.model.Product;
import superprice.catalog.model.Store;
import superprice.catalog.repository.ProductRepository;


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
				Store.COLES,
				15.43,
				"Kills 99.9% of germs"
			)
            
		);
	}
}
