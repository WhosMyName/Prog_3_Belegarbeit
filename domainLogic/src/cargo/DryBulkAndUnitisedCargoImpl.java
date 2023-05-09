package cargo;

import administration.Customer;

import java.time.Duration;
import java.util.Date;

public class DryBulkAndUnitisedCargoImpl extends CargoImpl implements DryBulkAndUnitisedCargo {

    private boolean fragile;
    private int grainSize;


    @Override
    public int getGrainSize() {
        return this.grainSize;
    }

    @Override
    public boolean isFragile() {
        return this.fragile;
    }

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
}
