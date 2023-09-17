package superprice.catalog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import superprice.catalog.model.Product;

@SpringBootTest
public class ProductRepositoryTests {
    @Autowired
    private Flyway flyway;

    @Autowired // springBoot inject 
    DataSource source; //create data source
    ProductRepository repo;

    @BeforeEach
    private void setUp() {
        flyway.migrate(); 
        repo = mock(new ProductRepositoryImpl(source));
    }

    @AfterEach
    private void tearDown() {
        flyway.clean();
    }

    @Test
    void findAll_should_haveDefaultValue(){
        List<Product> products = repo.findAll();
        assertEquals(3, products.size());
    }

}
