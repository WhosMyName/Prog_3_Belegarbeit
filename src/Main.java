import eventhandling.EventHandler;
import management.CustomerManagement;
import management.Lager;
import commandlineinterface.CLI;
import management.LagerListener;

public class Main {

    public static void main(String[] args) {
        EventHandler handler = new EventHandler();
        Lager lager = new Lager(handler);
        CustomerManagement management = new CustomerManagement(handler);
        LagerListener lagerListener = new LagerListener(lager);
        handler.addListener(lagerListener);
        CLI cli = new CLI(handler);
        cli.run();
    }
}
