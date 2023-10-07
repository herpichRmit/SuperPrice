package superprice.catalog.product.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import superprice.catalog.product.controller.ProductController;
import superprice.catalog.product.model.Product;
import superprice.catalog.product.service.ProductService;

@SpringBootTest
public class ProductControllerTest {
    private ProductController controller; 

    @MockBean 
    private ProductService service;

    @BeforeEach
    void setup(){
        this.service = mock(ProductService.class); //Create a service mock 
        this.controller = new ProductController(this.service);
        
    }

    //Get requests
    @Test
    void getProduct_should_returnProducts_when_productsAvailable(){
        when(this.service.getProducts())
            .thenReturn(List.of(new Product("Cheese", "Woolies", "the cheese company", "Dairy", 5.86, "cheesy cheese to warm the soul")));
        assertEquals(1, this.controller.getProduct().size());
    } 

    @Test
    void getProduct_should_returnEmpty_when_productsNotAvailable(){
        when(this.service.getProducts())
            .thenReturn(new ArrayList<>());
        assertEquals(0, this.controller.getProduct().size());
    } 

    //find id should return product 

    //find id should return empty when product not available 

    @Test
    void getID_should_returnProduct_when_productAvaialble(){
        when(this.service.getProduct(1L))
        .thenReturn(Optional.of(new Product("Cheese", "Woolies", "A2 Milk", "Dairy", 5.00, "cheesy")));
        Product product = this.controller.get(1L);
        assertNotNull(product);
        assertEquals("Cheese", product.getTitle());
    } 

    //compare by title should return title
    @Test
    void getProductsByTitle_should_returnProduct_when_productAvaialble(){
        when(this.service.getProductsByTitle("Cheese"))
        .thenReturn(List.of(new Product("Cheese", "Woolies", "A2 Milk", "Dairy", 5.00, "cheesy")));
        List<Product> product = this.controller.get("Cheese");
        assertNotNull(product);
        assertEquals("Cheese", product.get(0).getTitle());
    } 

    //get product by keyword should return product
    @Test
    void getProductsByKeyword_should_returnProduct_when_productAvaialble(){
        when(this.service.getProductsByKeyword("Cheese"))
        .thenReturn(List.of(new Product("Cheese", "Woolies", "A2 Milk", "Dairy", 5.00, "cheesy")));
        List<Product> product = this.controller.getByKeyword("Cheese");
        assertNotNull(product);
        assertEquals("Cheese", product.get(0).getTitle());
    } 

    //get category should return products for category
    @Test
    void getByCategory_should_returnProduct_when_productAvaialble(){
        when(this.service.getProductsByCategory("Dairy"))
        .thenReturn(List.of(new Product("Cheese", "Woolies", "A2 Milk", "Dairy", 5.00, "cheesy")));
        List<Product> product = this.controller.getByCategory("Dairy");
        assertNotNull(product);
        assertEquals("Cheese", product.get(0).getTitle());
    } 

    //getbyprice should return products 
    @Test
    void getByPrice_should_returnProduct_when_productAvaialble(){
        when(this.service.sortbyPrice("Cheese"))
        .thenReturn(List.of(new Product("Cheese", "Woolies", "A2 Milk", "Dairy", 5.00, "cheesy")));
        List<Product> product = this.controller.getByPrice("Cheese");
        assertNotNull(product);
        assertEquals("Cheese", product.get(0).getTitle());
    } 


}
