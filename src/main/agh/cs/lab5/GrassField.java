package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
import agh.cs.lab7.IPositionChangeObserver;
import agh.cs.lab7.MapBoundary;
import java.util.LinkedList;
import java.util.List;

public class GrassField extends AbstractWorldMap {
    protected int howManyGrasses;
    protected final List<IPositionChangeObserver> listOfObserver = new LinkedList<>();

    public GrassField(int howManyGrasses){
        this.howManyGrasses = howManyGrasses;
        int index = 0;
        while (index < howManyGrasses) {
            int randF = (int) (Math.random()*Math.sqrt(10 * howManyGrasses));
            int randS = (int) (Math.random()*Math.sqrt(10 * howManyGrasses));
            if(!super.mapFields.containsKey(new Vector2d(randF,randS))){
                Grass x = new Grass(new Vector2d(randF,randS));
                super.mapFields.put(new Vector2d(randF,randS),x);
                index++;
            }
        }
    }
    public GrassField(int howManyGrasses, Vector2d[] tab){
        this.howManyGrasses = howManyGrasses;
        for(Vector2d y:tab){
            Grass x = new Grass(y);
            super.mapFields.put(y,x);
        }
    }
    public void upDate(){
        for(IPositionChangeObserver observer:this.listOfObserver){
            for(Vector2d x:super.mapFields.keySet()) observer.positionChanged(x, x);
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        this.listOfObserver.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.listOfObserver.remove(observer);
    }

    @Override
    public Vector2d getTopRight(){
        return MapBoundary.getTop();
    }
    private void getGrass(Vector2d position)
    {
        if(super.mapFields.get(position)!=null && super.mapFields.get(position).isOverwritable()){
            while (true) {
                int randF = (int) (Math.random()*Math.sqrt(10 * this.howManyGrasses));
                int randS = (int) (Math.random()*Math.sqrt(10 * this.howManyGrasses));
                if(!mapFields.containsKey(new Vector2d(randF,randS))){
                    mapFields.put(new Vector2d(randF,randS),new Grass(new Vector2d(randF,randS)));
                    mapFields.remove(position);
                    for(IPositionChangeObserver observer:this.listOfObserver){
                        observer.positionChanged(position,new Vector2d(randF,randS));
                    }
                    break;
                }
            }
        }
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        getGrass(newPosition);
        if(!oldPosition.equals(newPosition)){
            IMapElement g = mapFields.get(oldPosition);
            mapFields.remove(oldPosition);
            mapFields.put(newPosition,g);
        }
    }
}
