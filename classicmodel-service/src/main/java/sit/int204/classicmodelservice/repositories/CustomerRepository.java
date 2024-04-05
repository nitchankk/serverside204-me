package sit.int204.classicmodelservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
