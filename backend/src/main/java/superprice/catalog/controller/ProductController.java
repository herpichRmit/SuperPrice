package superprice.catalog.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import superprice.catalog.service.ProductService;
import superprice.catalog.model.Product;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
	public List<Product> getProduct() {
		//return productService.getProduct();
		//return productService.getResults();
    	
    	//hard coded for now
		//return productService.sortByPrice("Spray and Wipe");
		
		//hard coded for now
		//return productService.filterByCategory("Cleaning");
    	
    	return productService.searchShowPrice("Spray and Wipe");
		


	}
}
