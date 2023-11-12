package agh.ics.oop.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MapDirectionTest {
    MapDirection vect1 = MapDirection.NORTH;
    MapDirection vect2 = MapDirection.SOUTH;
    MapDirection vect3 = MapDirection.WEST;
    MapDirection vect4 = MapDirection.EAST;

    @Test
    public void nextTest(){
        assertEquals(vect1.next(), MapDirection.EAST);
        assertEquals(vect2.next(), MapDirection.WEST);
        assertEquals(vect3.next(), MapDirection.NORTH);
        assertEquals(vect4.next(), MapDirection.SOUTH);
    }
    @Test
    public void prevTest(){
        assertEquals(vect1.previous(), MapDirection.WEST);
        assertEquals(vect2.previous(), MapDirection.EAST);
        assertEquals(vect3.previous(), MapDirection.SOUTH);
        assertEquals(vect4.previous(), MapDirection.NORTH);
    }


}
