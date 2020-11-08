package agh.cs.lab5;
import agh.cs.lab2.Vector2d;
import java.util.*;
public class GrassField extends AbstractWorldMap {
    public int ileTrawy;
    public GrassField(int ileTrawy){
        this.ileTrawy = ileTrawy;
        int index = 0;
        boolean flaga;
        while (index < ileTrawy) {
            flaga = true;
            int randF = (int) (Math.random()*Math.sqrt(10 * ileTrawy));
            int randS = (int) (Math.random()*Math.sqrt(10 * ileTrawy));
            for(AbstractWorldMapElement elementListy : super.obiektyNaMapie)
                if(elementListy instanceof Grass && elementListy.getPosition().equals(new Vector2d(randF,randS))){ flaga = false; }
            if(flaga){
                super.obiektyNaMapie.add(new Grass(new Vector2d(randF,randS)));
                index++;
            }
        }
    }
    @Override
    public Vector2d getTopRight(){
        Iterator<AbstractWorldMapElement> kamil = super.obiektyNaMapie.iterator();
        Vector2d start = new Vector2d(0,0);
        while (kamil.hasNext()){
            start = kamil.next().getPosition().upperRight(start);
        }
        return start;
    }
}
