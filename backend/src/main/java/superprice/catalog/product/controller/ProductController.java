package superprice.catalog.product.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import superprice.catalog.product.exception.ProductNotFoundException;
import superprice.catalog.product.model.Product;
import superprice.catalog.product.service.ProductService;

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
		return productService.getProducts();
	}

    @GetMapping("/{id}")
	public Product get(@PathVariable Long id) {
		return productService.getProduct(id).orElseThrow(
                () -> new ProductNotFoundException(id));
	}

    @GetMapping("/compare/{title}")
	public List<Product> get(@PathVariable String title) {
		return productService.getProductsByTitle(title);
    }

    @GetMapping("/search/{title}")
	public List<Product> getByKeyword(@PathVariable String title) {
		return productService.getProductsByKeyword(title);
    }


    @GetMapping("/category/{category}")
	public List<Product> getByCategory(@PathVariable String category) {
		return productService.getProductsByCategory(category);
    }

    @GetMapping("/sql/{keyword}")
	public List<Product> getTestSQL(@PathVariable String keyword) {
		return productService.getProductByKeywordTestSQL(keyword);
    }
        @GetMapping("/price/{keyword}")
	public List<Product> getByPrice(@PathVariable String keyword) 
    {
	return productService.sortbyPrice(keyword);
    }
    
}

