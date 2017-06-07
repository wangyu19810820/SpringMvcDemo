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
        return customerList.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNum))
                .findAny()
                .orElse(null);
    }

    @Override
    public void add(Customer c) {
        customerList.add(c);
    }
}
