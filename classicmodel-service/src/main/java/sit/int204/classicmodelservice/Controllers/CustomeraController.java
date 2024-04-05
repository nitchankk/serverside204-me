package sit.int204.classicmodelservice.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelservice.Service.CustomeraService;
import sit.int204.classicmodelservice.entities.Customera;

import java.util.List;


@RestController
@RequestMapping("/customeras")
public class CustomeraController {
    @Autowired
    CustomeraService service;
    @PostMapping("")
    public List<Customera> createCustomeras(@RequestBody List<Customera> customeras) {
        return service.insertCustomers(customeras);
    }
}
