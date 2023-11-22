package agh.ics.oop.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Vector2dTest {
    Vector2d vect1 = new Vector2d(1,1);
    Vector2d vect2 = new Vector2d(1,1);
    Vector2d vect3 = new Vector2d(2,3);

    @Test
    public void equalsTest(){
        assertEquals(vect1, vect2);
        assertNotEquals(vect1, vect3);

    }
    @Test
    public void toStringTest(){
        assertEquals(vect1.toString(), "(1,1)");
        assertEquals(vect3.toString(), "(2,3)");
    }
    @Test
    public void precedesTest(){
        assertEquals(vect1.precedes(vect3), false);
        assertEquals(vect1.precedes(vect2), true);
        assertEquals(vect3.precedes(vect1), true);
    }
    @Test
    public void followsTest(){
        assertEquals(vect1.follows(vect3), true);
        assertEquals(vect3.follows(vect1), false);
        assertEquals(vect1.follows(vect2), true);
    }
    @Test
    public void upperRightTest(){
        assertEquals(vect1.upperRight(vect3), new Vector2d(2, 3));
    }
    @Test
    public void lowerLeftTest(){
        assertEquals(vect1.lowerLeft(vect3), new Vector2d(1, 1));
    }
    @Test
    public void addTest(){
        Vector2d vect0 = vect1.add(vect3);
        assertEquals(vect0, new Vector2d(3, 4));
    }
    @Test
    public void subTest(){
        Vector2d vect0 = vect1.subtract(vect3);
        assertEquals(vect0, new Vector2d(-1, -2));
    }
    @Test
    public void oppositeTest(){
        Vector2d vect0 = vect1.opposite();
        assertEquals(vect0, new Vector2d(-1,-1));
    }


}
