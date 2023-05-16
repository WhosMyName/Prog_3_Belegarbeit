package management;

import administration.CargoImpl;
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
    private int capacity;
    private EventHandler handler;

    public Lager(EventHandler handler, int capacity){
        this.cargoList = new ArrayList<>();
        this.handler = handler;
        this.capacity = capacity;
    }


    public void createCargo(CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, CustomerImpl customer, boolean fragile, boolean isPressurized, int grainSize){
        System.out.println("creating Cargo");
        System.out.println("CT: " + cargoType);
        if (this.cargoList.size() >= this.capacity){
            // TODO: add notification to CLI
            return;
        }
        // TODO: check that user exists
        StorableImpl stowage = new StorableImpl(customer, getNextStorageLocation());
        // +++++
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
            // TODO: throw error + event msg
        }
        System.out.println("cargo created");
    }

    public void editCargo(){}

    public CargoImpl findCargoByStorageLocation(int requestedLocation){
        for (CargoImpl c : this.cargoList){
            if (requestedLocation == c.getS)
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
