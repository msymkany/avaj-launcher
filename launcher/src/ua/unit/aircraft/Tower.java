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
        int j;
        for (int i = 0; i < (j = observers.size()); i++){
            observers.get(i).updateConditions();
            if (j > observers.size())
                i--;
        }

    }
}
