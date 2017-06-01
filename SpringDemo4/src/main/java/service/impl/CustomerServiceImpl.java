package service.impl;

import org.springframework.stereotype.Service;
import service.CustomerService;
import webflow.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/1.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer lookupCustomer(String phoneNum) {
        Customer c = new Customer();
        c.setId(1);
        c.setName("name1");
        c.setPhoneNumber(phoneNum);
        c.setAddress("address1");
        c.setCity("city1");
        c.setState("state1");
        c.setZipCode("zipcode1");
        return c;
    }
}
