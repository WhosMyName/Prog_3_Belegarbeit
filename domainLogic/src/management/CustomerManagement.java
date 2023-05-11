package management;

import administration.CustomerImpl;
import eventhandling.EventHandler;

import java.util.ArrayList;
import java.util.UUID;


public class CustomerManagement {
    private ArrayList<CustomerImpl> customerList;
    private EventHandler handler;

    public CustomerManagement(ArrayList<CustomerImpl> customers){
        this.customerList = customers;
    }

    public CustomerManagement(EventHandler handler){
        this.customerList = new ArrayList<CustomerImpl>();
        this.handler = handler;
    }

    public CustomerImpl findCustomerByID(UUID id){
        for (CustomerImpl c : this.customerList){
            if (id == c.getId()){
                return c;
            }
        }
        return null;
    }

    public void addCustomer(CustomerImpl customer){
        this.customerList.add(customer);
    }

    public void removeCustomer(CustomerImpl customer){
        this.customerList.remove(customer);
    }

}
