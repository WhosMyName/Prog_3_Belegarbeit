package eventhandling;

import java.util.EventObject;
import java.util.UUID;

public class RequestCustomerEvent extends EventObject implements  BasicEvent{
    UUID customerID;

    public RequestCustomerEvent(Object source, UUID customerID) {
        super(source);
        this.customerID = customerID;
    }

    public UUID getCustomerID() {
        return customerID;
    }
}
