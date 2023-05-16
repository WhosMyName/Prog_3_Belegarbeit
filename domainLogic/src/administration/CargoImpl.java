package administration;

import cargo.Cargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;


public class CargoImpl implements Cargo {
    BigDecimal value;
    Collection<Hazard> hazardCollection;

    public CargoImpl() {
        this.value = BigDecimal.ZERO;
        this.hazardCollection = new ArrayList<>();
    }

    public CargoImpl(BigDecimal value, Collection<Hazard> hazardList){
        this.value = value;
        this.hazardCollection = hazardList;
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
