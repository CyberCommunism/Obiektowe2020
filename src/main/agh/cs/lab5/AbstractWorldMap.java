package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;
import java.util.*;
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final HashMap<Vector2d, AbstractWorldMapElement> mapFields = new HashMap<>();
    protected static final Vector2d LEFT = new Vector2d(0,0);
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }
    @Override
    public Optional<AbstractWorldMapElement> objectAt(Vector2d position) {
        if(mapFields.get(position) == null){
            return Optional.empty();
        }else {
            return Optional.of(mapFields.get(position));
        }
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(LEFT) && (!isOccupied(position) || objectAt(position).get().isOverwritable());
    }
    @Override
    public void place(Animal animal) throws Exception{
        if (canMoveTo(animal.getPosition())) {
            positionChanged(animal.getPosition(), animal.getPosition());
            this.mapFields.put(animal.getPosition(),animal);
        }else {
            throw new IllegalArgumentException(animal.getPosition() + " cos nie tak");
        }
    }
    @Override
    public String toString(){ return new MapVisualizer(this).draw(LEFT,getTopRight()); }
    abstract protected Vector2d getTopRight();
    public abstract void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
