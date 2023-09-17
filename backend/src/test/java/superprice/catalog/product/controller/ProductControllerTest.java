// package superprice.catalog.product.controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import superprice.catalog.product.controller.ProductController;
// import superprice.catalog.product.model.Product;
// import superprice.catalog.product.service.ProductService;

// @SpringBootTest
// public class ProductControllerTest {
//     private ProductController controller; 

//     @MockBean 
//     private ProductService service;

//     @BeforeEach
//     void setup(){
//         this.service = mock(ProductService.class); //Create a service mock 
//         this.controller = new ProductController(this.service);
        
//     }

//     //Get requests
//     @Test
//     void getProduct_should_returnProducts_when_productsAvailable(){
//         when(this.service.getProducts())
//             .thenReturn(List.of(new Product("Cheese", "Woolies", "the cheese company", "Dairy", 5.86, "cheesy cheese to warm the soul")));
//         assertEquals(1, this.controller.getProduct().size());
//     } 

//     @Test
//     void getProduct_should_returnEmpty_when_productsNotAvailable(){
//         when(this.service.getProducts())
//             .thenReturn(new ArrayList<>());
//         assertEquals(0, this.controller.getProduct().size());
//     } 
// }
