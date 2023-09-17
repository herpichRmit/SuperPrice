package superprice.catalog.user.service;

import java.util.List;

import superprice.catalog.user.model.Customer;

public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer signUp(Customer customer) throws Exception;
    public String signIn(Customer customer);
}

