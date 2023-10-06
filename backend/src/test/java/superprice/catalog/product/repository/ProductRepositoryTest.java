package superprice.catalog.product.repository;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTest {
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

    @AfterEach
    private void tearDown(){
        flyway.clean();
    }

    //nothing to test since it extends JpaRepo

    
}
