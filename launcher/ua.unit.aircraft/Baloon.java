package ua.unit.aircraft;

/**
 * Created by msymkany on 5/26/18.
 */

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void    updateConditions(){
        int height = this.coordinates.getHeight();
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather){
            case "SUN": {
                if (height >= 96){
                    coordinates = new Coordinates(coordinates.getLongitude() + 2,
                            coordinates.getLatitude(), 100);
                }
                else
                    coordinates = new Coordinates(coordinates.getLongitude() + 2,
                            coordinates.getLatitude(), coordinates.getHeight() + 4);
                Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Mmmmmmm... You're so hot, Sunny");
                break;
            }
            case "RAIN": {
                if (height <= 5) {
                    Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Simulator.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                else {
                    coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                            height - 5);
                    Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): I feel those little drops everywhere on my body. I'm moisty");
                }
                break;
            }
            case "FOG": {
                if (height <= 3) {
                    Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Simulator.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                else {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                            height - 3);
                    Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): I can't see you. But I feel you behind the Fog.");
                }
                break;
            }
            case "SNOW": {
                if (height <= 15) {
                    Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Simulator.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                else {
                    Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Every time I leak snow is like the first time.");
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                            height - 15);
                }
                break;
            }
            default: break;
        }
    }

    public void    registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
