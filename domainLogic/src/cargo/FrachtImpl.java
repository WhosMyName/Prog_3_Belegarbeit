package cargo;

import administration.CargoImpl;
import administration.Customer;
import administration.StorableImpl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class FrachtImpl implements Fracht {
    private CargoImpl cargoInfo;
    private StorableImpl storageInfo;

    public FrachtImpl(CargoImpl cargoInfo, StorableImpl storageInfo) {
        this.cargoInfo = cargoInfo;
        this.storageInfo = storageInfo;
    }

// Storable
    @Override
    public Customer getOwner() {
        return this.storageInfo.getOwner();
    }

    @Override
    public Duration getDurationOfStorage() {
        return this.storageInfo.getDurationOfStorage();
    }

    @Override
    public Date getLastInspectionDate() {
        return this.storageInfo.getLastInspectionDate();
    }

    @Override
    public int getStorageLocation() {
        return this.storageInfo.getStorageLocation();
    }

// Cargo
    @Override
    public BigDecimal getValue() {
        return this.cargoInfo.getValue();
    }

    @Override
    public Collection<Hazard> getHazards() {
        return this.cargoInfo.getHazards();
    }
}
