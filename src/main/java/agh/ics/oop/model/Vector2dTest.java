package agh.ics.oop.model;

public class Vector2dTest {
    Vector2d vect1 = new Vector2d(1,1);
    Vector2d vect2 = new Vector2d(1,1);
    Vector2d vect3 = new Vector2d(2,3);

    @Test
    public void equalsTest(){
        System.out.println(vect1.equals(vect2));
        System.out.println((vect1.equals(vect3)));
    }
    @Test
    public void toStringTest(){
        System.out.println(vect1.toString());
    }
    @Test
    public void precedesTest(){
        System.out.println(vect1.precedes(vect3));
        System.out.println(vect3.precedes(vect1));
        System.out.println(vect1.precedes(vect2));
    }
    @Test
    public void followsTest(){
        System.out.println(vect1.follows(vect3));
        System.out.println(vect3.follows(vect1));
        System.out.println(vect1.follows(vect2));
    }
    @Test
    public void upperRightTest(){
        Vector2d vect0 = vect1.upperRight(vect3);
        System.out.println(vect0.getX());
        System.out.println(vect0.getY());
    }
    @Test
    public void lowerLeftTest(){
        Vector2d vect0 = vect1.lowerLeft(vect3);
        System.out.println(vect0.getX());
        System.out.println(vect0.getY());
    }
    @Test
    public void addTest(){
        Vector2d vect0 = vect1.add(vect3);
        System.out.println(vect0.getX());
        System.out.println(vect0.getY());
    }
    @Test
    public void subTest(){
        Vector2d vect0 = vect1.subtract(vect3);
        System.out.println(vect0.getX());
        System.out.println(vect0.getY());
    }
    @Test
    public void oppositeTest(){
        Vector2d vect0 = vect1.opposite();
        System.out.println(vect0.getX());
        System.out.println(vect0.getY());
    }


}
