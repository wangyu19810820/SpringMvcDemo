package controller;

import exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.CustomerService;
import webflow.Customer;

/**
 * Created by admin on 2017/6/1.
 */
@Component
public class PizzaFlowActions {

    @Autowired
    private CustomerService customerService;

    public Customer lookupCustomer(String phoneNumber)  {
        Customer customer = customerService.lookupCustomer(phoneNumber);
        if(customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }
}
