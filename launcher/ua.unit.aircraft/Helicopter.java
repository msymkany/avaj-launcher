package ua.unit.aircraft;

/**
 * Created by msymkany on 5/26/18.
 */

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void    updateConditions(){
        int height = this.coordinates.getHeight();
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather){
            case "SUN": {
                if (height >= 98){
                    coordinates = new Coordinates(coordinates.getLongitude() + 10,
                            coordinates.getLatitude(), 100);
                }
                else
                    coordinates = new Coordinates(coordinates.getLongitude() + 10,
                            coordinates.getLatitude(), coordinates.getHeight() + 2);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): I swallow the Sun.");
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                        height);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): It's raining man, Halleluja.");
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                        height);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): Oh, Fog it!.");
                break;
            }
            case "SNOW": {
                if (height <= 12) {
                    Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Simulator.printWriter.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                else {
                    Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): Don't eat the yellow snow.");
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        height - 12);
                }
                break;
            }
            default: break;
        }
    }

    public void    registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
