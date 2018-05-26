package ua.unit.aircraft;

/**
 * Created by msymkany on 5/26/18.
 */

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates){
        this.coordinates = coordinates;
        this.name = name;
//        this.id = idCounter++;
        this.id = this.incrementIdCounter();
    }

    private long incrementIdCounter(){
        return idCounter++;
    }
}
