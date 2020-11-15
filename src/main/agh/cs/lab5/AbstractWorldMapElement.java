package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

abstract public class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;
    protected IWorldMap map;
    @Override
    public Vector2d getPosition() {
        return this.position;
    }
}
