package superprice.catalog.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import superprice.catalog.model.Product;

import superprice.catalog.model.Store;

@Service
public class ProductService {
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

