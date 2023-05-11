package eventhandling;

import cargo.CargoType;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

public class EditCargoEvent extends CreateCargoEvent{

    private UUID cargoID;

    public EditCargoEvent(Object source, CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, UUID customerID, UUID cargoID, boolean fragile, boolean isPressurized, int grainSize) {
        super(source, cargoType, value, hazardList, customerID, fragile, isPressurized, grainSize);
        this.cargoID = cargoID;
    }

    public EditCargoEvent(Object source, CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, UUID customerID, UUID cargoID) {
        super(source, cargoType, value, hazardList, customerID);
        this.cargoID = cargoID;
    }

    public UUID getCargoID() {
        return cargoID;
    }
}
