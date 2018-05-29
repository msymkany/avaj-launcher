package ua.unit.aircraft;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by msymkany on 5/26/18.
 */

public class Tower {
    private List<Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){

    }
}
