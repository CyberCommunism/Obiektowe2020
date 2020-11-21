package agh.cs.lab1;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.*;
import agh.cs.lab4.*;
import agh.cs.lab5.GrassField;

public class World {
    public static void main(String[] args){
        try {
            String[] tab = {"f", "f", "r", "f","l","r","f"};
            MoveDirection[] directions = OptionsParser.parse(tab);
            IWorldMap map = new GrassField(2);

            Vector2d[] positions = {new Vector2d(2, 2),new Vector2d(1,1)};
            System.out.println(map);
            IEngine enegine = new SimulationEngine(directions, map, positions);
            System.out.println(map);
            enegine.run();
            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}