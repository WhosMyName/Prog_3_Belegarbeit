package administration;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class StorableImpl implements  Storable{
    CustomerImpl owner;
    private LocalDate arrivalDate;
    private LocalDate lastInspectionDate;
    private int storageLocation;

    public StorableImpl(CustomerImpl owner, int storageLocation) {
        this.arrivalDate = LocalDate.now();
        this.lastInspectionDate = LocalDate.now();
        this.owner = owner;
        this.storageLocation = storageLocation;
    }

    public StorableImpl() {
        this.owner = new CustomerImpl();
        this.storageLocation = -1;
        this.arrivalDate = LocalDate.now();
        this.lastInspectionDate = LocalDate.now();
    }

    @Override
    public Customer getOwner() {
        return this.owner;
    }

    @Override
    public Duration getDurationOfStorage() {
        return Duration.between(this.arrivalDate, LocalDateTime.now());
    }

    @Override
    public Date getLastInspectionDate() {
        return Date.from(Instant.from(this.lastInspectionDate));
    }

    @Override
    public int getStorageLocation() {
        return this.storageLocation;
    }
}
