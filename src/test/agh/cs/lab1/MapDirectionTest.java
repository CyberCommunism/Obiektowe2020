package agh.cs.lab1;
import agh.cs.lab2.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MapDirectionTest {
    public static MapDirection[] testy = {MapDirection.NORTH,MapDirection.EAST,MapDirection.SOUTH,MapDirection.WEST};
    @Test
    void previous() {
        for(int i=0;i< testy.length;i++){
            assertEquals(testy[i],testy[(i+1) % testy.length].previous());
        }
    }
    @Test
    void next() {
        for(int i=0;i< testy.length;i++){
            assertEquals(testy[(i+1) % testy.length],testy[i].next());
        }
    }
}