package superprice.catalog.product.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Locale.Category;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryRepositoryTest {
    
    @Autowired 
    private Flyway flyway;

    @Autowired
    DataSource source;

    CategoryRepository repo;

    @BeforeEach
    private void setUp(){
        flyway.migrate();
        repo = new CategoryRepository(source);
    }

    // @AfterEach
    // private void tearDown(){
    //     flyway.clean();
    // }

    @Test
    void categories_shouldReturn_AllCategories(){
        assertEquals(3, repo.categories().size());
    }

}
