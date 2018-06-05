package ua.unit.aircraft;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by msymkany on 5/26/18.
 */

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        return (WeatherProvider.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
//        return weather[ThreadLocalRandom.current().nextInt(1, 5)]; //some random here
        int num = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4;
        return weather[num];
    }

}
