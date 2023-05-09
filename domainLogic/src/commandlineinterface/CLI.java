package commandlineinterface;

import cargo.Hazard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CLI {
    protected Scanner scan;
    protected CLIMode currentMode;

    public CLI(){
        this.scan = new Scanner(System.in);
    }

    public CLI(Scanner sc){
        this.scan = sc;
    }

    public void run(){
        // implement this
        //  Create
        //  List
        //  Inspect
        //  Delete
    }

    private String getString(){
        if (this.scan.hasNext()){
            return this.scan.nextLine();
        }
        return "";
    }

    private int getInt(){
        if (this.scan.hasNextInt()) {
            int retVal = this.scan.nextInt();
            this.scan.nextLine();
            return retVal;
        }
        return Integer.MIN_VALUE;
    }

    private BigDecimal getDecimal(){
        if (this.scan.hasNextBigDecimal()){
            BigDecimal value = this.scan.nextBigDecimal();
            this.scan.nextLine();
            return value;
        }
        return BigDecimal.ZERO;
    }

    private Collection<Hazard> getHazard(){
        boolean exit = false;
        Collection<Hazard> hazardList = new ArrayList<>();
        int scanInt = 0;
        while (!exit){
            System.out.println("Please enter a number for the corresponding Hazard:" +
                    "1) explosive" +
                    "2) flammable" +
                    "3) toxic" +
                    "4) radioactive" +
                    "5) Exit" +
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
