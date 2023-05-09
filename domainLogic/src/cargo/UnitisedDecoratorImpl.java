package cargo;

import administration.Customer;
import administration.StorableImpl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class UnitisedDecoratorImpl implements UnitisedCargo {
    StorableImpl stowage;
    protected CargoImpl cargo;
    boolean fragile;

    @Override
    public Customer getOwner() {
        return this.stowage.getOwner();
    }

    @Override
    public Duration getDurationOfStorage() {
        return this.stowage.getDurationOfStorage();
    }

    @Override
    public Date getLastInspectionDate() {
        return this.stowage.getLastInspectionDate();
    }

    @Override
    public int getStorageLocation() {
        return this.stowage.getStorageLocation();
    }

    @Override
    public boolean isFragile() {
        return this.fragile;
    }

    @Override
    public BigDecimal getValue() {
        return this.cargo.getValue();
    }

    @Override
    public Collection<Hazard> getHazards() {
        return this.cargo.getHazards();
    }
}
