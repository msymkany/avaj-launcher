package ua.unit.aircraft;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.LinkedList;
/**
 * Created by msymkany on 5/26/18.
 */

public class Simulator {

	private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new LinkedList<Flyable>();
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


        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (NewException e){
            System.out.println(e.getMessage());
        }



    }
}
