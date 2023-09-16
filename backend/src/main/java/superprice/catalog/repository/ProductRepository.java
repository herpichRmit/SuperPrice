package superprice.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import superprice.catalog.model.Product;

import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}

