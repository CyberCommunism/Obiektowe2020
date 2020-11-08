package agh.cs.lab4;
import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMap;
public class RectangularMap extends AbstractWorldMap {
    private final Vector2d RIGHT;
    public RectangularMap(int x, int y){
        this.RIGHT = new Vector2d(x-1,y-1);
    }
    private boolean isInRangeOfMap(Vector2d position){ return position.precedes(this.RIGHT) && position.follows(LEFT); }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return isInRangeOfMap(position) && super.canMoveTo(position);
    }
    @Override
    public Vector2d getTopRight(){ return RIGHT; }
}
