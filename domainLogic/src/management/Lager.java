package management;

import administration.CustomerImpl;
import administration.StorableImpl;
import cargo.*;
import eventhandling.EventHandler;
import eventhandling.RequestCustomerEvent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Lager {
    private ArrayList<CargoImpl> cargoList;
    private EventHandler handler;

    public Lager(EventHandler handler){
        this.cargoList = new ArrayList<>();
        this.handler = handler;
    }


    public void createCargo(CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, CustomerImpl customer, boolean fragile, boolean isPressurized, int grainSize){
        System.out.println("creating Cargo");
        System.out.println("CT: " + cargoType);
        StorableImpl stowage = new StorableImpl(customer, getNextStorageLocation());
        if (CargoType.Cargo == cargoType){
            this.cargoList.add(new CargoImpl(value, hazardList, stowage));
        } else if (CargoType.UnitisedCargo == cargoType) {

        } else if (CargoType.DryBulkCargo == cargoType) {

        } else if (CargoType.LiquidBulkCargo == cargoType) {

        } else if (CargoType.LiquidDryBulkCargo == cargoType) {

        } else if (CargoType.LiquidBulkUnitisedCargo == cargoType) {

        } else if (CargoType.DryBulkUnitisedCargo == cargoType) {
            this.cargoList.add(new DryBulkAndUnitisedCargoImpl(value, hazardList, stowage, fragile, grainSize));
        } else {
            // throw error + event msg
        }
        System.out.println("cargo created");
    }

    public void addCargo(CargoImpl c){
        this.cargoList.add(c);
    }

    public void editCargo(){}

    public CargoImpl findCargoByID(UUID cid){
        for (CargoImpl c : this.cargoList){
            if (cid == c.getId())
                return c;
        }
        return null;
    }

    public boolean removeCargo(Cargo c){
        return this.cargoList.remove(c);
    }

    public boolean removeCargoByID(UUID cid){
        CargoImpl c = findCargoByID(cid);
        if (c == null)
            return false;
        return this.cargoList.remove(c);
    }

    private int getNextStorageLocation(){
        return 0;
    }

    public void notifyCustomerMgmt(UUID customerID){
        System.out.println("notifying CMgmt");
        this.handler.handle(new RequestCustomerEvent(this, customerID));
    }

}

/*
* To implement:
*
* Decorators:
* https://www.baeldung.com/java-decorator-pattern
* https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
*
* Composition:
* https://www.javatpoint.com/composition-in-java
* https://www.geeksforgeeks.org/composition-in-java/
*
*/