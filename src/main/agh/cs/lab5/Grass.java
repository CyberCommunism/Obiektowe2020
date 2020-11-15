package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
public class Grass extends AbstractWorldMapElement{
    public Grass(Vector2d position){
        super.position = position;
    }
    public String toString(){return "*";}

    @Override
    public boolean isOverwritable() {
        return true;
    }
}
