package agh.ics.oop.model;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RectangularMapTest {

    @Test
    public void placeTest(){
        RectangularMap map = new RectangularMap(6, 4);
        Animal animal = new Animal();
        Animal animal2 = new Animal(new Vector2d(1, 3));
        map.place(animal);
        map.place(animal2);
        Map<Vector2d, Animal> animals = map.getAnimals();
        assertEquals(animal, animals.get(new Vector2d(2,2)));
        assertEquals(animal2, animals.get(new Vector2d(1,3)));
    }

    @Test
    public void moveTest(){
        RectangularMap map = new RectangularMap(6, 4);
        Animal animal = new Animal();
        MoveValidator validator = new RectangularMapMoveValidator(map);
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD, validator);
        assertEquals(animal.getPosition(), new Vector2d(2, 3));
    }
    @Test
    public void canMoveToTest(){
        RectangularMap map = new RectangularMap(6, 4);
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        MoveValidator validator = new RectangularMapMoveValidator(map);
        assertEquals(map.canMoveTo(new Vector2d(2,2)), true);
        map.place(animal);
        assertEquals(map.canMoveTo(new Vector2d(2, 2)), false);
        assertEquals(map.canMoveTo(new Vector2d(10,10)), false);
    }

    @Test
    public void isOccupiedTest(){
        RectangularMap map = new RectangularMap(6, 4);
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        map.place(animal);
        assertEquals(map.isOccupied(new Vector2d(2, 2)), true);
    }
    @Test
    public void objectAtTest(){
        RectangularMap map = new RectangularMap(6, 4);
        Animal animal = new Animal(new Vector2d(1, 3));
        map.place(animal);
        assertEquals(animal, map.objectAt(new Vector2d(1, 3)));

    }
}
