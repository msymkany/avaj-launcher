package ua.unit.aircraft;

/**
 * Created by msymkany on 5/26/18.
 */

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather(){
        this.conditionsChanged();
    }
}
