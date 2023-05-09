package cargo;

import administration.CustomerImpl;
import administration.StorableImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;


public abstract class CargoImpl implements Cargo{

    UUID id;
    BigDecimal value;
    Collection<Hazard> hazardCollection;
    StorableImpl storageInfo;

    public CargoImpl() {
        this.value = BigDecimal.ZERO;
        this.hazardCollection = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.storageInfo = new StorableImpl();
    }

    public CargoImpl(BigDecimal value, Collection<Hazard> hazardList, StorableImpl storageInfo){
        this.id = UUID.randomUUID();
        this.value = value;
        this.hazardCollection = hazardList;
        this.storageInfo = storageInfo;

    }

    public CargoImpl(BigDecimal value, Collection<Hazard> hazardList, CustomerImpl owner, int storageLocation){
        this.id = UUID.randomUUID();
        this.value = value;
        this.hazardCollection = hazardList;
        this.storageInfo = new StorableImpl(owner, storageLocation);

    }

    public UUID getId() {
        return id;
    }

    @Override
    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public Collection<Hazard> getHazards() {
        return this.hazardCollection;
    }


}
