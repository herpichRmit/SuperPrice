package superprice.catalog.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import superprice.catalog.product.model.Category;
import superprice.catalog.product.model.Product;

import java.util.Collection;
import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}

