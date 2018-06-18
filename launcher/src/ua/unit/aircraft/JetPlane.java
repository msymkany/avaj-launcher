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
        int height = this.coordinates.getHeight();
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather){
            case "SUN": {
                if (height >= 98){
                    coordinates = new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude() + 10, 100);
                }
                else
                    coordinates = new Coordinates(coordinates.getLongitude() + 10,
                            coordinates.getLatitude(), coordinates.getHeight() + 2);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): I follow the Sun.");
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                        height);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): The rain falls down.");
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1,
                        height);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): Tuman yarom, tuman dolynoyu.");
                break;
            }
            case "SNOW": {
                if (height <= 7) {
                    Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Simulator.printWriter.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                else {
                    Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): Let it snow, let it snow, let it snow.");
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                            height - 7);
                }
                break;
            }
            default: break;
        }
    }

    public void    registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
