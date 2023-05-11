package management;

import administration.CustomerImpl;
import cargo.FullCargoRecord;
import eventhandling.BasicEvent;
import eventhandling.CreateCargoEvent;
import eventhandling.EventListener;
import eventhandling.ReturnCustomerEvent;

import java.util.ArrayList;

public class LagerListener implements EventListener {

    private Lager lager;
    private ArrayList<FullCargoRecord> recordList;

    public LagerListener(Lager lager){
        this.lager = lager;
        this.recordList = new ArrayList<>();
    }

    private void onCreateCargoEvent(CreateCargoEvent event){
        this.recordList.add(new FullCargoRecord(
                event.getCargoType(),
                event.getValue(),
                event.getHazardList(),
                event.getCustomerID(),
                event.isFragile(),
                event.isPressurized(),
                event.getGrainSize()
        ));
        this.lager.notifyCustomerMgmt(event.getCustomerID());
    }

    private void onReturnCustomerEvent(ReturnCustomerEvent event){
        CustomerImpl customer = event.getCustomer();
        for (FullCargoRecord record : this.recordList ){
            if (record.customerID() == customer.getId()){
                this.lager.createCargo(
                        record.cargoType(),
                        record.value(),
                        record.hazardList(),
                        customer,
                        record.fragile(),
                        record.isPressurized(),
                        record.grainSize()
                );
            }
        }
    }


    public void onEvent(ReturnCustomerEvent event) {
        System.out.println("onEvent RCE");
        onReturnCustomerEvent(event);
    }

    public void onEvent(CreateCargoEvent event) {
        System.out.println("onEvent CCE");
        onCreateCargoEvent(event);
    }

    @Override
    public void onEvent(BasicEvent event) {
        System.out.println("onEvent BE");
        if (event.getClass() == ReturnCustomerEvent.class)
            onReturnCustomerEvent((ReturnCustomerEvent) event);

        if (event.getClass() == CreateCargoEvent.class)
            onCreateCargoEvent((CreateCargoEvent) event);


    }
}
