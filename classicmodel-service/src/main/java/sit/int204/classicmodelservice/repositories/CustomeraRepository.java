package sit.int204.classicmodelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelservice.entities.Customera;

public interface CustomeraRepository extends JpaRepository<Customera, Long> { }