package sit.int204.classicmodelservice.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelservice.Service.CustomerService;
import sit.int204.classicmodelservice.dtos.SimpleCustomerDTO;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.entities.Order;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable Integer id) {
        Customer customer = service.findByID(id);
        SimpleCustomerDTO simpleCustomer = modelMapper.map(customer, SimpleCustomerDTO.class);
        return ResponseEntity.ok(simpleCustomer);
    }
    @GetMapping("/{id}/orders")
    public List<Order> getCustomerOrder(@PathVariable Integer id) {
        System.out.println("id = "+ id);
        return service.findByID(id).getOrderList();
    }
}

