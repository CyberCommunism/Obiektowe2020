package agh.cs.lab1;

import agh.cs.lab2.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestyIntegracyjnyMapy {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream outOrigin = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(outOrigin);
    }


    @Test
    void testAll() throws Exception {
        String[] val = {"f","f","f","f","f","f","f","f",};
        World.main(val);
        String expected = new Vector2d(2, 5).toString() + "N" + new Vector2d(3, 5).toString() + "N";
        assertEquals(expected, out.toString());
    }
    @Test
    void testAll1() throws Exception {
        String[] val = {"r","r","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f",};
        World.main(val);
        String expected = new Vector2d(10, 2).toString() + "E" + new Vector2d(10, 4).toString() + "E";
        assertEquals(expected, out.toString());
    }
    @Test
    void testAll2() throws Exception {
        String[] val = {"b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b",};
        World.main(val);
        String expected = new Vector2d(2, 0).toString() + "N" + new Vector2d(3, 0).toString() + "N";
        assertEquals(expected, out.toString());
    }
    @Test
    void testAll3() throws Exception {
        String[] val = {"f","b","r","l","f","f","b","b"};
        World.main(val);
        String expected = new Vector2d(1, 3).toString() + "E" + new Vector2d(4, 3).toString() + "W";
        assertEquals(expected, out.toString());
    }

}