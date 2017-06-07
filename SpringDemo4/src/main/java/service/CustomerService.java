package service;

import webflow.Customer;

/**
 * Created by admin on 2017/6/1.
 */
public interface CustomerService {
    Customer lookupCustomer(String phoneNum);
    void add(Customer c);
}
