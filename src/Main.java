import eventhandling.EventHandler;
import management.CustomerManagement;
import management.Lager;
import commandlineinterface.CLI;
import management.LagerListener;

public class Main {

    public static void main(String[] args) {
        CLI cli = new CLI();
        Lager lager = new Lager();
        CustomerManagement management = new CustomerManagement();
        EventHandler handler = new EventHandler();
        LagerListener lagerListener = new LagerListener(lager);
        handler.addListener(lagerListener);
        cli.run();
    }
}
