package superprice.catalog.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import superprice.catalog.user.model.Customer;
import superprice.catalog.user.service.CustomerService;

@SpringBootTest
public class CustomerControllerTest {

    /* 
    private CustomerController controller; 

    @MockBean 
    private CustomerService service;

    @BeforeEach
    void setup(){
        this.service = mock(CustomerService.class); //Create a service mock 
        this.controller = new CustomerController(this.service);
        assertEquals(1, 1);
        
    }

    //Get requests
    @Test
    void getCustomers_should_returnCustomers_when_thereAreCustomers(){
        when(this.service.getCustomers())
            .thenReturn(List.of(new Customer("Bobby", "Jane", "bobjane@myspace.com", "password")));
        assertEquals(1, this.controller.getCustomers().size());
    }

    @Test
    void getCustomers_should_returnNoCustomers_when_thereAreNoCustomers(){
        when(this.service.getCustomers())
            .thenReturn(new ArrayList<>());
                    assertEquals(0, this.controller.getCustomers().size());
    }

    //Post requests
    @Test
    void signUp_should_callCustomerServiceSignUp() throws Exception{
        Customer a = new Customer("Bobby", "Jane", "bobjane@myspace.com", "password");

        this.controller.signUp(a);
        verify(this.service, times(1)).signUp(a);
    }

    @Test
    void signIn_should_callCustomerServiceSignIn() throws Exception{
        Customer a = new Customer("Bobby", "Jane", "bobjane@myspace.com", "password");

        this.controller.signIn(a);
        verify(this.service, times(1)).signIn(a);
    }
    */
    
}
