/*
package agh.cs.lab1;

import agh.cs.lab2.*;
import agh.cs.lab3.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestyIntegracyjneAnimal {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream outOrigin = System.out;

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(out));
    }
    @AfterEach
    public void restoreStream(){
        System.setOut(outOrigin);
    }
    @Test
    void testParse() throws Exception {
        String[] val ={"f","123", "forward", "b","haha", "backward", "r", "right", "l", "left","x","mapa","1piwo","to","nie","piwo"};
        World.main(val);
        String expected = new Vector2d(2,2).toString() + "N";
        assertEquals(expected,out.toString());

    }
    @Test
    void testParse1() throws Exception {
        String[] val ={};
        World.main(val);
        String expected = new Vector2d(2,2).toString() + "N";
        assertEquals(expected,out.toString());
    }

    @Test
    void testNaOrientacje() throws Exception {
        IWorldMap ma = new RectangularMap(4,4);
        Animal noweZwierze = new Animal(ma);

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,noweZwierze.getDirection());

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH,noweZwierze.getDirection());

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST,noweZwierze.getDirection());

        noweZwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH,noweZwierze.getDirection());
    }
    @Test
    void testNaPozycje() throws Exception {
        IWorldMap ma = new RectangularMap(4,4);
        Animal noweZwierze = new Animal(ma);

        MoveDirection idztyl = MoveDirection.BACKWARD;
        MoveDirection idzprzod = MoveDirection.FORWARD;
        MoveDirection obrocprawo = MoveDirection.RIGHT;
        MoveDirection obroclewo = MoveDirection.LEFT;

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,3),noweZwierze.getPosition());

        noweZwierze.move(idztyl);
        assertEquals(new Vector2d(2,2),noweZwierze.getPosition());

        noweZwierze.move(obroclewo);
        noweZwierze.move(obroclewo);
        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,1),noweZwierze.getPosition());

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,0),noweZwierze.getPosition());

        noweZwierze.move(obrocprawo);
        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(1,0),noweZwierze.getPosition());

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(0,0),noweZwierze.getPosition());

        for(int i=0; i<4; i++){
            noweZwierze.move(idztyl);
        }
        assertEquals(new Vector2d(4,0),noweZwierze.getPosition());
    }
    @Test
    void testNaOgraniczeniaMapy() throws Exception {
        IWorldMap ma = new RectangularMap(4,4);
        Animal noweZwierze = new Animal(ma);

        MoveDirection idztyl = MoveDirection.BACKWARD;
        MoveDirection idzprzod = MoveDirection.FORWARD;
        MoveDirection obrocprawo = MoveDirection.RIGHT;

        noweZwierze.move(idzprzod);
        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,4),noweZwierze.getPosition());

        noweZwierze.move(idzprzod);
        assertEquals(new Vector2d(2,4),noweZwierze.getPosition());

        noweZwierze.move(obrocprawo);
        for (int i=0; i<100; i++){
            noweZwierze.move(idztyl);
        }
        assertEquals(new Vector2d(0,4),noweZwierze.getPosition());

    }

}
*/