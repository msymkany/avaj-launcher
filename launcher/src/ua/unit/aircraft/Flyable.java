package ua.unit.aircraft;

/**
 * Created by msymkany on 5/26/18.
 */

public interface Flyable {
    void    updateConditions();
    void    registerTower(WeatherTower weatherTower);
}
