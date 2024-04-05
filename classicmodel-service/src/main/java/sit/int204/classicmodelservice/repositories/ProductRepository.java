package sit.int204.classicmodelservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelservice.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String>{
    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName);
    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName, Sort sort);
    Page<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName, Pageable pageable);
    List<Product> findByProductLineContains(String productName);
    List<Product> findByProductLineStartingWith(String productLine);
    Product findFirstByOrderByPriceDesc();


//JPA QUERY && native query
    @Query("SELECT p FROM Product p WHERE p.productLine like :category")
    List<Product> getProductByCategory(String category);
}
