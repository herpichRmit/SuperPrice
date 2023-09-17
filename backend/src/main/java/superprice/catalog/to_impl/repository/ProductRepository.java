/* 
package superprice.catalog.to_impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import superprice.catalog.to_impl.model.Product;
import superprice.catalog.to_impl.model.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;



@Repository
public interface ProductRepository
//	extends JpaRepository<Product, Integer>
{
    public List<Product> findAll();

    public Optional<Product> findById(Long id);

    public Product create(Product book);

    public void delete(Long id);

	List<Product> sortByPrice(String sterm);
	List<Product> filterByCategory(String sterm);
	ArrayList<Result> searchShowPrice(String sterm);
}
*/
