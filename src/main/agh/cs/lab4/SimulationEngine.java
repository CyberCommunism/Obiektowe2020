package agh.cs.lab4;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab7.IPositionChangeObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    List<Animal> animals = new LinkedList<>();
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) throws Exception{
        this.moves = moves;
        for (Vector2d x : positions) {
            try {
                Animal newAnimal = new Animal(map, x);
                IPositionChangeObserver obs = (IPositionChangeObserver) map;
                newAnimal.addObserver(obs);
                animals.add(newAnimal);
            } catch (Exception e) {
                throw e;
            }
        }
    }
    @Override
    public void run() {
        Iterator<Animal> it = animals.iterator();
        for(MoveDirection x:this.moves){
            it.next().move(x);
            if(!it.hasNext()) it = animals.iterator();
        }
    }
}