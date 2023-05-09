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

    public void handle(){
        for (EventListener listener : this.listeners){
            listener.onEvent();
        }
    }
}

