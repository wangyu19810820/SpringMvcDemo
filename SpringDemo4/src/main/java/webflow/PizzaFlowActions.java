package webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.CustomerService;
import webflow.Customer;
import webflow.CustomerNotFoundException;

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

    public void addCustomer(Customer c) {
        customerService.add(c);
    }

    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment = null;
        if(paymentDetails.getPaymentType() == PaymentType.CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }

        return payment;
    }

    public boolean checkDeliveryArea(String zipCode) {
        System.out.println("TODO: Flesh out the checkDeliveryArea() method.");
        return "75075".equals(zipCode);
    }

    public void saveOrder(Order order) {
        System.out.println("save order:" + order);
    }
}
