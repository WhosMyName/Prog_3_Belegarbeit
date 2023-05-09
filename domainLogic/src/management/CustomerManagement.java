package management;

import administration.CustomerImpl;

import java.util.ArrayList;
import java.util.UUID;


public class CustomerManagement {
    private ArrayList<CustomerImpl> customerList;

    public CustomerManagement(ArrayList<CustomerImpl> customers){
        this.customerList = customers;
    }

    public CustomerManagement(){
        this.customerList = new ArrayList<CustomerImpl>();
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
