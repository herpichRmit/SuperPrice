package superprice.catalog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import superprice.catalog.product.model.Product;
import superprice.catalog.user.model.Customer;

import java.util.List;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
