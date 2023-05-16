package commandlineinterface;

import cargo.CargoType;
import cargo.Hazard;
import eventhandling.CreateCargoEvent;
import eventhandling.EventHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;

public class CLI {
    protected Scanner scan;
    protected CLIMode currentMode;
    private EventHandler handler;

    public CLI(EventHandler handler){
        this.scan = new Scanner(System.in);
        this.handler = handler;
    }

    public CLI(Scanner sc, EventHandler handler){
        this.scan = sc;
        this.handler = handler;
    }

    public void run(){
        boolean eggsit = false;
        while (!eggsit){
            // TODO: fix input
            // TODO: fix modes
            System.out.println("Please enter the mode of operation:\n" +
                    ":c - Create Cargo\n" +
                    ":r - List Cargo\n" +
                    ":u - Edit Cargo\n" +
                    ":d - Delete Cargo\n" +
                    ":p - Persistence Mode\n" +
                    ":q - Quit\n" +
                    "Enter command here:");
            String mode = this.getString();
            if (":C".equals(mode)){
                this.createCargo();
            } else if (":L".equals(mode)) {

            } else if (":E".equals(mode)) {

            } else if (":D".equals(mode)) {

            } else if (":Q".equals(mode)) {
                eggsit = true;
            } else {
                eggsit = true;
            }
        }
    }

    private void createCargo() {
        System.out.println("Welcome to creation mode!");
        this.handler.handle(new CreateCargoEvent(
                this,
                getCargoType(),
                getDecimal("Please insert the value of the cargo:"),
                getHazards(),
                UUID.randomUUID()
                ));

    }

    private CargoType getCargoType() {
        System.out.println("Please enter a number for the corresponding Hazard:\n" +
                "1) Cargo (implemented)\n" +
                "2) UnitisedCargo\n" +
                "3) DryBulkCargo\n" +
                "4) LiquidBulkCargo\n" +
                "5) LiquidDryBulkCargo\n" +
                "6) DryBulkUnitisedCargo (implemented)\n" +
                "7) LiquidBulkUnitisedCargo\n" +
                "0) Exit\n" +
                "Please enter a number:");
        int cargoType = getInt();
        if (cargoType == 1)
            return CargoType.Cargo;
        else if (cargoType == 2) {
            return CargoType.UnitisedCargo;
        } else if (cargoType == 3) {
            return CargoType.DryBulkCargo;
        } else if (cargoType == 4) {
            return CargoType.LiquidBulkCargo;
        } else if (cargoType == 5) {
            return CargoType.LiquidDryBulkCargo;
        } else if (cargoType == 6) {
            return CargoType.DryBulkUnitisedCargo;
        } else if (cargoType == 7) {
            return CargoType.LiquidBulkUnitisedCargo;
        } else
            return CargoType.Cargo;
    }

    private String getString(){
        if (this.scan.hasNext()){
            return this.scan.nextLine();
        }
        return null;
    }

    private String getString(String text){
        System.out.println(text);
        return this.getString();
    }

    private int getInt(){
        if (this.scan.hasNextInt()) {
            int retVal = this.scan.nextInt();
            this.scan.nextLine();
            return retVal;
        }
        return Integer.MIN_VALUE;
    }

    private int getInt(String text){
        System.out.println(text);
        return this.getInt();
    }

    private BigDecimal getDecimal(){
        if (this.scan.hasNextBigDecimal()){
            BigDecimal value = this.scan.nextBigDecimal();
            this.scan.nextLine();
            return value;
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getDecimal(String text){
        System.out.println(text);
        return this.getDecimal();
    }

    private Collection<Hazard> getHazards(){
        boolean exit = false;
        Collection<Hazard> hazardList = new ArrayList<>();
        int scanInt = 0;
        while (!exit){
            System.out.println("Please enter a number for the corresponding Hazard:\n" +
                    "1) explosive\n" +
                    "2) flammable\n" +
                    "3) toxic\n" +
                    "4) radioactive\n" +
                    "5) Exit\n" +
                    "Please enter a number:");
            if (this.scan.hasNextInt()){
                scanInt = this.getInt();
                if (1 == scanInt){
                    hazardList.add(Hazard.explosive);
                } else if (2 == scanInt) {
                    hazardList.add(Hazard.flammable);
                } else if (3 == scanInt) {
                    hazardList.add(Hazard.toxic);
                } else if (4 == scanInt) {
                    hazardList.add(Hazard.radioactive);
                } else {
                    exit = true;
                }
            }
        }
        return hazardList;
    }

}
