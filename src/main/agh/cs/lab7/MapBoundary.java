package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MapBoundary implements IPositionChangeObserver {
    private final static HashSet<Vector2d> elementy = new HashSet<>();
    private final static LinkedList<Vector2d> orderedByX = new LinkedList<>();
    private final static LinkedList<Vector2d> orderedByY = new LinkedList<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elementy.remove(oldPosition);
        elementy.add(newPosition);

        if (!newPosition.precedes(getTop()) || oldPosition.equals(getTop())) {
            orderedByX.clear();
            orderedByY.clear();
            orderedByX.addAll(elementy);
            orderedByY.addAll(elementy);
            orderedByX.sort(new Comparator<Vector2d>() {
                @Override
                public int compare(Vector2d o1, Vector2d o2) {
                    if (o1.getX() > o2.getX() || (o1.getX() == o2.getX() && o1.getY() > o2.getY())) {
                        return 1;
                    }
                    if (o1.getX() < o2.getX() || (o1.getX() == o2.getX() && o1.getY() < o2.getY())) {
                        return -1;
                    }
                    return 0;
                }
            });
            orderedByY.sort(new Comparator<Vector2d>() {
                @Override
                public int compare(Vector2d o1, Vector2d o2) {
                    if (o1.getY() > o2.getY() || (o1.getY() == o2.getY() && o1.getX() > o2.getX())) {
                        return 1;
                    }
                    if (o1.getY() < o2.getY() || (o1.getY() == o2.getY() && o1.getX() < o2.getX())) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
    }

    public static Vector2d getTop() {
        try{
            orderedByX.getLast();
            orderedByY.getLast();
            return new Vector2d(orderedByX.getLast().getX(), orderedByY.getLast().getY());
        } catch (NoSuchElementException e){
            return new Vector2d(0,0);
        }

    }

}
