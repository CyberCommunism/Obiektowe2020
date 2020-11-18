package agh.cs.lab3;
import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.AbstractWorldMapElement;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.LinkedList;
import java.util.List;
public class Animal extends AbstractWorldMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private final List<IPositionChangeObserver> listOfObservers = new LinkedList<>();
    public Animal(IWorldMap map) throws Exception {
        this(map,new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition) throws Exception {
        super.map = map;
        super.position = initialPosition.add(new Vector2d(-1,-1));
        try {
            map.place(this);
            positionChanged(this.position,this.position);
        } catch (Exception e) {
            throw e;
        }
    }
    public String toString(){
        return this.orientation.toString();
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> {
                this.orientation = this.orientation.next();
            }
            case LEFT ->{
                this.orientation = this.orientation.previous();
            }
            case FORWARD -> {
                changePositionIfpossible(this.orientation.toUnitVector());
            }
            case BACKWARD -> {
                changePositionIfpossible(this.orientation.toUnitVector().opposite());
            }
        }
    }
    private void changePositionIfpossible(Vector2d where){
        Vector2d newTest = this.position.add(where);
        if(map.canMoveTo(newTest)){
            positionChanged(this.position,newTest);
            super.position = newTest;
        }
    }
    @Override
    public boolean isOverwritable() {
        return false;
    }
    public void addObserver(IPositionChangeObserver observer){
        this.listOfObservers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.listOfObservers.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition,Vector2d newPosition){
        for(IPositionChangeObserver x:this.listOfObservers)
        {
            x.positionChanged(oldPosition, newPosition);
        }
    }
}