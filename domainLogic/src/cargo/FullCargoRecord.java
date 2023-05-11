package cargo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

public record FullCargoRecord(CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, UUID customerID, boolean fragile, boolean isPressurized, int grainSize) {
    public FullCargoRecord(CargoType cargoType, BigDecimal value, Collection<Hazard> hazardList, UUID customerID, boolean fragile, boolean isPressurized, int grainSize){
        this.cargoType = cargoType;
        this.value = value;
        this.hazardList = hazardList;
        this.customerID = customerID;
        this.fragile = fragile;
        this.isPressurized = isPressurized;
        this.grainSize = grainSize;
    }
}
