package sit.int204.classicmodelservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelservice.entities.Customera;
import sit.int204.classicmodelservice.repositories.CustomeraRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomeraService {
    @Autowired
    CustomeraRepository customeraRepository;
    public List<Customera> insertCustomers(List<Customera> customeras) {
        return customeraRepository.saveAll(customeras);
    }
}
