package superprice.catalog.user.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import superprice.catalog.user.model.Customer;
import superprice.catalog.user.service.CustomerService;

@RestController
@RequestMapping(path = "api/v1/users")
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

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody Customer customer) {
        try {
            Customer newCustomer = customerService.signUp(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody Customer customer) {
        String existingCustomer = customerService.signIn(customer);
        if (existingCustomer == "Success") {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } 
        else if (existingCustomer == "Incorrect password") {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
