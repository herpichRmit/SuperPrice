package superprice.catalog.product.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import superprice.catalog.product.controller.ProductController;
import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.Price;
import superprice.catalog.product.model.Product;
import superprice.catalog.product.model.Store;
import superprice.catalog.product.model.StructuredProduct;
import superprice.catalog.product.repository.CategoryRepository;
import superprice.catalog.product.service.ProductService;
import superprice.catalog.user.model.Customer;

@SpringBootTest
public class CategoryControllerTest {
    private CategoryController controller; 

    @MockBean 
    private CategoryRepository repo;

    @BeforeEach
    void setup(){
        this.repo = mock(CategoryRepository.class); //Create a service mock 
        this.controller = new CategoryController(this.repo);
    }

    @Test
    void all_should_returnAllCategories_when_thereAreCategories(){
        Price b = new Price(Store.COLES,500);
        ArrayList<Price> priceCollection = new ArrayList<Price>();
        priceCollection.add(b);
        StructuredProduct a = new StructuredProduct("Cheese", "Woolies", "3", priceCollection);
        when(repo.categories()).
            thenReturn(List.of(new Category("Dairy", List.of(a))));

        assertEquals(1, controller.all().size());
    }

    @Test
    void all_should_returnnothing_when_noCategories(){
        when(repo.categories()).
            thenReturn(new ArrayList<>());

        assertEquals(0, controller.all().size());
    }
        
    
}
