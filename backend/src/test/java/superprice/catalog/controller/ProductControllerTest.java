// package superprice.catalog.controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import superprice.catalog.controller.ProductController;
// import superprice.catalog.service.ProductService;


// @SpringBootTest
// public class ProductControllerTest {
//     private ProductController controller; 

//     //@MockBean 
//     private ProductService service;

//     @BeforeEach
//     void setup(){
//         this.service = mock(ProductService.class); //Create a service mock 
//         this.controller = new ProductController(this.service);
        
//     }


//     //Get requests
//     // @Test
//     // void getProduct_should_returnProducts_when_productsAvailable(){
//     //     when(this.service.getProduct())
//     //         .thenReturn(List.of(new Product))
//     //     assertEquals(1, this.controller.getProduct().size());
//     // } 

//     // @Test
//     // void getProduct_should_returnEmpty_when_productsNotAvailable(){
//     //     when(this.service.getProduct())
//     //         .thenReturn(new ArrayList<>());
//     //     assertEquals(1, this.controller.getProduct().size());
//     // } 

//     @Test 
//     void getTrips_should_return(){} //what is this method meant to do
    
// }
