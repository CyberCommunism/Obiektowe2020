package agh.cs.lab3;
import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.AbstractWorldMapElement;
import agh.cs.lab5.Grass;
import agh.cs.lab5.GrassField;

import java.util.Iterator;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orietationt = MapDirection.NORTH;
    public Animal(IWorldMap map) throws Exception {
        this(map,new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition) throws Exception {
        super.map = map;
        super.position = initialPosition.add(new Vector2d(-1,-1));
        if(!map.place(this)){
            throw new Exception("nie da sie stowyrz zwierza");
        }
    }
    public String toString(){
        return this.orietationt.toString();
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orietationt = this.orietationt.next();
            case LEFT -> this.orietationt = this.orietationt.previous();
            case FORWARD -> changePositionIfPosibble(this.orietationt.toUnitVector());
            case BACKWARD -> changePositionIfPosibble(this.orietationt.toUnitVector().opposite());
        }
    }
    private void changePositionIfPosibble(Vector2d gdzie){
        Vector2d nowyTestowy = this.position.add(gdzie);
        if(map.canMoveTo(nowyTestowy)){
            Object x = super.map.objectAt(nowyTestowy);
            if(x instanceof Grass){
                GrassField currMap = ((GrassField) super.map);
                currMap.obiektyNaMapie.remove(x);
                boolean flaga=false;
                int randF = (int) (Math.random()*Math.sqrt(10 * currMap.ileTrawy));
                int randS = (int) (Math.random()*Math.sqrt(10 * currMap.ileTrawy));
                while (!flaga) {
                    flaga = true;
                    randF = (int) (Math.random()*Math.sqrt(10 * currMap.ileTrawy));
                    randS = (int) (Math.random()*Math.sqrt(10 * currMap.ileTrawy));

                    Iterator<AbstractWorldMapElement> it = currMap.obiektyNaMapie.iterator();
                    while (it.hasNext())
                        if(it.next().getPosition().equals(new Vector2d(randF,randS))){ flaga = false; }

                    if(flaga)
                        currMap.obiektyNaMapie.add(new Grass(new Vector2d(randF,randS)));

                }
                currMap.obiektyNaMapie.add(new Grass(new Vector2d(randF,randS)));
            }
            super.position = nowyTestowy;
        }
    }
}