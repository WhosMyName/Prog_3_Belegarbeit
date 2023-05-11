package eventhandling;

import administration.CustomerImpl;

import java.util.EventObject;

public class ReturnCustomerEvent extends EventObject implements BasicEvent {
    CustomerImpl customer;

    public ReturnCustomerEvent(Object source, CustomerImpl customer) {
        super(source);
        this.customer = customer;
    }

    public CustomerImpl getCustomer() {
        return customer;
    }
}
