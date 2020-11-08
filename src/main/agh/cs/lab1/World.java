package agh.cs.lab1;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.*;
import agh.cs.lab4.*;
import agh.cs.lab5.GrassField;

public class World {
    public static void main(String[] args) throws Exception {
        String[] tab = {"f","f","r","f"};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new GrassField(8);
        Vector2d[] positions = { new Vector2d(2,2)};
        IEngine enegine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        enegine.run();
        System.out.println(map);
    }
}