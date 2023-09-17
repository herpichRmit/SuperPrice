package superprice.catalog.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.Product;

import java.util.Collection;
import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
    List<Product> findByCategory(String category);
    List<Product> findByTitleContainingIgnoreCase(String title);

    //@Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
    @Query(
        value = "SELECT * FROM product WHERE title = ?",
        nativeQuery = true
        )
    List<Product> testSQL(String keyword);

}

