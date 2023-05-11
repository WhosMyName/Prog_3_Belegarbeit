package eventhandling;

import cargo.CargoType;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.UUID;

public class CreateCargoEvent extends EventObject implements BasicEvent {

    private CargoType cargoType;
    private BigDecimal value;
    private Collection<Hazard> hazardList;
    private UUID customerID;
    private boolean fragile;
    private boolean isPressurized;
    private int grainSize;

    public CreateCargoEvent(Object source, CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, UUID customerID, boolean fragile, boolean isPressurized, int grainSize) {
        super(source);
        this.cargoType = cargoType;
        this.value = value;
        this.hazardList = hazardList;
        this.customerID = customerID;
        this.fragile = fragile;
        this.isPressurized = isPressurized;
        this.grainSize = grainSize;
    }

    public CreateCargoEvent(Object source, CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, UUID customerID) {
        super(source);
        this.cargoType = cargoType;
        this.value = value;
        this.hazardList = hazardList;
        this.customerID = customerID;
        this.fragile = false;
        this.isPressurized = false;
        this.grainSize = 0;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Collection<Hazard> getHazardList() {
        return hazardList;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public boolean isFragile() {
        return fragile;
    }

    public boolean isPressurized() {
        return isPressurized;
    }

    public int getGrainSize() {
        return grainSize;
    }
}
