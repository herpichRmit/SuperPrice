package superprice.catalog.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superprice.catalog.user.model.Customer;
import superprice.catalog.user.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
	}

    public Customer signUp(Customer customer) throws Exception {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new Exception("Email already exists");
        }
        return customerRepository.save(customer);
    }

    public String signIn(Customer customer) {
        Customer existingCustomer = customerRepository.findByEmail(customer.getEmail());
        if (existingCustomer != null && existingCustomer.getPassword().equals(customer.getPassword())) {
            return "Success";
        }
        else if (existingCustomer != null && !existingCustomer.getPassword().equals(customer.getPassword())) {
            return "Incorrect password";
        }
        return "Not found";
    }
}
