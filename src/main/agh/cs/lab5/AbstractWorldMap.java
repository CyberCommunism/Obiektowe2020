package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap {
    public List<AbstractWorldMapElement> obiektyNaMapie = new LinkedList<>();
    public final Vector2d LEFT = new Vector2d(0,0);
    protected Vector2d TopRight;
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != Optional.empty();
    }
    @Override
    public Object objectAt(Vector2d position) {
        Iterator<AbstractWorldMapElement> it = this.obiektyNaMapie.iterator();
        while(it.hasNext()){
            AbstractWorldMapElement curr = it.next();
            if(curr.getPosition().equals(position))
                return curr;
        }
        return Optional.empty();
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(new Vector2d(0,0)) && (!isOccupied(position) || objectAt(position) instanceof Grass);
    }
    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            this.obiektyNaMapie.add(animal);
            return true;
        }
        else return false;
    }
    @Override
    public String toString(){ return new MapVisualizer(this).draw(LEFT,getTopRight()); }
    abstract public Vector2d getTopRight();
}
