package superprice.catalog.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import superprice.catalog.user.model.Customer;
import superprice.catalog.user.service.CustomerService;

@RestController
@RequestMapping(path = "api/v1/product")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
