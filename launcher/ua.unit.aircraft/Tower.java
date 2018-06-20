package ua.unit.aircraft;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by msymkany on 5/26/18.
 */

public class Tower {
    private List<Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable flyable){
        if (!this.observers.contains(flyable)){
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable){
        if (this.observers.contains(flyable)){
            observers.remove(flyable);
        }

    }

    protected void conditionsChanged(){
        int size = observers.size();
        for (int i = 0; i <  observers.size(); i++){
            observers.get(i).updateConditions();
            if (size > observers.size()){
                i--;
                size--;
            }
        }
    }

    public int getObserversSize() {
        return this.observers.size();
    }

}
