package agh.cs.lab1;
import agh.cs.lab2.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class Vector2dTest {
    @Test
    void testToString() {
        Vector2d testowy = new Vector2d();
        assertEquals("(0,0)", testowy.toString());
        Vector2d testowy1 = new Vector2d(2, 4);
        assertEquals("(2,4)", testowy1.toString());
        Vector2d testowy2 = new Vector2d(-1, -3);
        assertEquals("(-1,-3)", testowy2.toString());

    }
    @Test
    void precedes() {
        Vector2d basic = new Vector2d(0, 0);
        Vector2d basic1 = new Vector2d(0, 1);
        Vector2d basic2 = new Vector2d(1, 1);
        Vector2d basic3 = new Vector2d(1, 0);
        Vector2d basic4 = new Vector2d(1, -1);
        Vector2d basic5 = new Vector2d(0, -1);
        Vector2d basic6 = new Vector2d(-1, -1);
        Vector2d basic7 = new Vector2d(-1, 0);
        Vector2d basic8 = new Vector2d(-1, 1);
        assertFalse(basic1.precedes(basic));
        assertFalse(basic2.precedes(basic));
        assertFalse(basic3.precedes(basic));
        assertFalse(basic4.precedes(basic));
        assertTrue(basic5.precedes(basic));
        assertTrue(basic6.precedes(basic));
        assertTrue(basic7.precedes(basic));
        assertFalse(basic8.precedes(basic));
    }
    @Test
    void follows() {
        Vector2d basic = new Vector2d(0, 0);
        Vector2d basic1 = new Vector2d(0, 1);
        Vector2d basic2 = new Vector2d(1, 1);
        Vector2d basic3 = new Vector2d(1, 0);
        Vector2d basic4 = new Vector2d(1, -1);
        Vector2d basic5 = new Vector2d(0, -1);
        Vector2d basic6 = new Vector2d(-1, -1);
        Vector2d basic7 = new Vector2d(-1, 0);
        Vector2d basic8 = new Vector2d(-1, 1);
        assertTrue(basic1.follows(basic));
        assertTrue(basic2.follows(basic));
        assertTrue(basic3.follows(basic));
        assertFalse(basic4.follows(basic));
        assertFalse(basic5.follows(basic));
        assertFalse(basic6.follows(basic));
        assertFalse(basic7.follows(basic));
        assertFalse(basic8.follows(basic));
    }
    @Test
    void upperRight() {
        Vector2d position0 = new Vector2d(0, 0);
        Vector2d position1 = new Vector2d(0, 1);
        Vector2d position2 = new Vector2d(1, 1);
        Vector2d position3 = new Vector2d(1, 0);
        assertEquals(new Vector2d(1, 1), position0.upperRight(position2));
        assertEquals(new Vector2d(1, 1), position1.upperRight(position3));
        assertEquals(new Vector2d(1, 1), position1.upperRight(position2));
        assertEquals(new Vector2d(1, 1), position2.upperRight(position3));
        assertEquals(new Vector2d(), position0.upperRight(position0));
    }
    @Test
    void lowerLeft() {
        Vector2d position0 = new Vector2d(0, 0);
        Vector2d position1 = new Vector2d(0, 1);
        Vector2d position2 = new Vector2d(1, 1);
        Vector2d position3 = new Vector2d(1, 0);
        assertEquals(new Vector2d(), position0.lowerLeft(position2));
        assertEquals(new Vector2d(), position1.lowerLeft(position3));
        assertEquals(new Vector2d(0,1), position1.lowerLeft(position2));
        assertEquals(new Vector2d(1,0), position2.lowerLeft(position3));
        assertEquals(new Vector2d(), position0.lowerLeft(position0));
        assertEquals(new Vector2d(1,1), position2.lowerLeft(position2));
    }
    @Test
    void add() {
        Vector2d testowy1 = new Vector2d(2, 3);
        Vector2d testowy2 = new Vector2d(1, 2);
        Vector2d testowy3 = new Vector2d();
        assertEquals(new Vector2d(3, 5), testowy1.add(testowy2));
        assertEquals(testowy1, testowy1.add(testowy3));
    }
    @Test
    void subtract() {
        Vector2d testowy1 = new Vector2d(2, 3);
        Vector2d testowy2 = new Vector2d(1, 2);
        Vector2d testowy3 = new Vector2d(1, 2);
        assertEquals(new Vector2d(1, 1), testowy1.subtract(testowy2));
        assertEquals(new Vector2d(), testowy2.subtract(testowy3));
    }
    @Test
    void opposite() {
        Vector2d testowy1 = new Vector2d(2, -3);
        Vector2d testowy2 = new Vector2d();
        assertEquals(new Vector2d(-2, 3), testowy1.opposite());
        assertEquals(new Vector2d(), testowy2.opposite());
    }
    @Test
    void testEquals() {
        int x = 0;
        Vector2d testowy = new Vector2d(1, 1);
        Vector2d testowy1 = new Vector2d(1, 2);
        Vector2d testowy2 = new Vector2d(1, 1);
        Vector2d testowy3 = testowy1;
        assertNotEquals(x, testowy);
        assertNotEquals(x, testowy1);
        assertNotEquals(x, testowy2);
        assertNotEquals(x, testowy3);
        assertNotEquals(testowy1, testowy);
        assertEquals(testowy2, testowy);
        assertNotEquals(testowy3, testowy);
        assertNotEquals(testowy2, testowy1);
        assertEquals(testowy3, testowy1);
        assertNotEquals(testowy3, testowy2);
    }
}