package management;

import cargo.Cargo;
import cargo.CargoImpl;

import java.util.ArrayList;
import java.util.UUID;

public class Lager {
    ArrayList<CargoImpl> cargoList;

    public Lager(){
        this.cargoList = new ArrayList<>();
    }

    public void addCargo(CargoImpl c){
        this.cargoList.add(c);
    }

    public void editCargo(){}

    public CargoImpl findCargoByID(UUID cid){
        for (CargoImpl c : this.cargoList){
            if (cid == c.getId())
                return c;
        }
        return null;
    }

    public boolean removeCargo(Cargo c){
        return this.cargoList.remove(c);
    }

    public boolean removeCargoByID(UUID cid){
        CargoImpl c = findCargoByID(cid);
        if (c != null)
            return this.cargoList.remove(c);
        return false;
    }

}

/*
* To implement:
*
* Decorators:
* https://www.baeldung.com/java-decorator-pattern
* https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
*
* Composition:
* https://www.javatpoint.com/composition-in-java
* https://www.geeksforgeeks.org/composition-in-java/
*
*/