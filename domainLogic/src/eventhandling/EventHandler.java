package eventhandling;

import java.util.ArrayList;

public class EventHandler {
    private ArrayList<EventListener> listeners;

    public EventHandler(ArrayList<EventListener> listeners) {
        this.listeners = listeners;
    }

    public EventHandler(){
        this.listeners = new ArrayList<>();
    }

    public void addListener(EventListener listener){
        this.listeners.add(listener);
    }

    public void removeListener(EventListener listener){
        this.listeners.remove(listener);
    }

    /*
    public void handle(CreateCargoEvent event){
        System.out.println("received CCE");
        for (EventListener listener : this.listeners){
            listener.onEvent(event);
        }
    }

    public void handle(EditCargoEvent event){
        System.out.println("received ECE");
        for (EventListener listener : this.listeners){
            listener.onEvent(event);
        }
    }

    public void handle(RequestCustomerEvent event){
        System.out.println("received RCE");
        for (EventListener listener : this.listeners){
            listener.onEvent(event);
        }
    }

    public void handle(ReturnCustomerEvent event){
        System.out.println("received RCE_2");
        for (EventListener listener : this.listeners){
            listener.onEvent(event);
        }
    }
    */

    public void handle(BasicEvent event){
        System.out.println("received BE");
        for (EventListener listener : this.listeners){
            listener.onEvent(event);
        }
    }
}

