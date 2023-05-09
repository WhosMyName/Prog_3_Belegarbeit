package administration;

import java.util.ArrayList;
import java.util.UUID;

public class CustomerImpl implements Customer{

    private String name;
    private UUID id;
    private ArrayList<Integer> cargoIDs;

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Integer> getCargoIDs() {
        return cargoIDs;
    }

    public CustomerImpl() {
        this.name = "";
        this.id = UUID.randomUUID();
        this.cargoIDs = new ArrayList<>();
    }

    public CustomerImpl(String name, UUID id, ArrayList<Integer> cargoIDs) {
        this.name = name;
        this.id = id;
        this.cargoIDs = cargoIDs;
    }

    public CustomerImpl(String name, UUID id) {
        this.name = name;
        this.id = id;
        this.cargoIDs = new ArrayList<>();
    }

    public void addCargoID(int cargoID){
        this.cargoIDs.add(cargoID);
    }

    public void removeCargoID(int cargoID){
        this.cargoIDs.remove(cargoID);
    }


}
