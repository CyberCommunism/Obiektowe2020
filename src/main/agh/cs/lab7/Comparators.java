package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

public class Comparators {
    public static int compare1(Vector2d o1, Vector2d o2) {
        if(o1.getX() > o2.getX() || (o1.getX() == o2.getX() && o1.getY() > o2.getY())){
            return 1;
        }
        if(o1.getX() < o2.getX() || (o1.getX() == o2.getX() && o1.getY() < o2.getY())){
            return -1;
        }
        return 0;
    }
}
