package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
public class GrassField extends AbstractWorldMap {
    public int ileTrawy;
    public GrassField(int ileTrawy){
        this.ileTrawy = ileTrawy;
        int index = 0;
        while (index < ileTrawy) {
            int randF = (int) (Math.random()*Math.sqrt(10 * ileTrawy));
            int randS = (int) (Math.random()*Math.sqrt(10 * ileTrawy));

            if(!super.mapFields.containsKey(new Vector2d(randF,randS))){
                super.mapFields.put(new Vector2d(randF,randS),new Grass(new Vector2d(randF,randS)));
                index++;
            }
        }
    }
    @Override
    public Vector2d getTopRight(){
        Vector2d start = new Vector2d(0,0);
        for(Vector2d x:super.mapFields.keySet()){
            start = x.upperRight(start);
        }
        return start;
    }
    private void getGrass(Vector2d position)
    {
        if(super.mapFields.get(position)!=null && super.mapFields.get(position).isOverwritable()){
            while (true) {
                int randF = (int) (Math.random()*Math.sqrt(10 * this.ileTrawy));
                int randS = (int) (Math.random()*Math.sqrt(10 * this.ileTrawy));
                if(!mapFields.containsKey(new Vector2d(randF,randS))){
                    mapFields.put(new Vector2d(randF,randS),new Grass(new Vector2d(randF,randS)));
                    mapFields.remove(position);
                    break;
                }
            }
        }
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        getGrass(newPosition);
        if(!oldPosition.equals(newPosition)){
            AbstractWorldMapElement g = mapFields.get(oldPosition);
            mapFields.remove(oldPosition);
            mapFields.put(newPosition,g);
        }
    }
}
