package agh.ics.oop.model;

public class MapDirectionTest {
    MapDirection vect1 = MapDirection.NORTH;
    MapDirection vect2 = MapDirection.SOUTH;
    MapDirection vect3 = MapDirection.WEST;
    MapDirection vect4 = MapDirection.EAST;

    @Test
    public void nextTest(){
        System.out.println(vect1.next());
        System.out.println(vect2.next());
        System.out.println(vect3.next());
        System.out.println(vect4.next());
    }
    @Test
    public void prevTest(){
        System.out.println(vect1.previous());
        System.out.println(vect2.previous());
        System.out.println(vect3.previous());
        System.out.println(vect4.previous());
    }


}
