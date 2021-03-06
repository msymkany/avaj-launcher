package ua.unit.aircraft;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by msymkany on 5/26/18.
 */

public class Simulator {

	private static WeatherTower weatherTower = new WeatherTower();
    static PrintWriter printWriter;

    public static void main(String[] args){
        try {
            int simulationsNum = 0;
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            if (line != null) {
                simulationsNum = Integer.parseInt(line.split(" ")[0]);
                if (simulationsNum <= 0) {
                    throw (new NewException("Invalid number of simulations"));
                }
            } else {
                throw (new NewException("Empty file"));
            }

            printWriter = null;
            File file = new File("simulation.txt");
            printWriter = new PrintWriter(file);
            AircraftFactory factory = new AircraftFactory();

            while ((line = reader.readLine()) != null) {

                String regExp = "(Baloon|JetPlane|Helicopter) (\\w+) (\\d+) (\\d+) (\\d+)";
                Pattern pattern = Pattern.compile(regExp);
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    if (Integer.parseInt(matcher.group(5)) > 0) {
                        Flyable flyable = factory.newAircraft(matcher.group(1),
                                matcher.group(2),
                                Integer.parseInt(matcher.group(3)),
                                Integer.parseInt(matcher.group(4)),
                                Integer.parseInt(matcher.group(5)));
                        if (flyable != null)
                            flyable.registerTower(weatherTower);
                    }
                    else throw new IOException("Wrong format of Aircraft height:\n\"" + line + "\"");
                }
                else throw new IOException("Wrong format of Aircraft description:\n\"" + line + "\"");
            }
            for (int i = 0; i < simulationsNum && weatherTower.getObserversSize() != 0; ++i) {
                weatherTower.changeWeather();
            }
            if ( printWriter != null )
                printWriter.close();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please input file with instructions as an argument");
        }
        catch (NumberFormatException e){
            System.out.println("First string in instruction must be valid number of simulations: positive int");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
