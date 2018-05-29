package ua.unit.aircraft;

/**
 * Created by msymkany on 5/26/18.
 */

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void    updateConditions(){

    }

    public void    registerTower(WeatherTower weatherTower){

    }
}
