package agh.cs.lab4;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;
    List<Animal> animals = new LinkedList<>();
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        for(Vector2d x : positions) {
            try {
                Animal kamil = new Animal(map, x);
                animals.add(kamil);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run(){
        Iterator<Animal> curr = animals.listIterator();
        for(MoveDirection x:this.moves){
            curr.next().move(x);
            if(!curr.hasNext())
                curr = animals.listIterator();
        }
    }
}