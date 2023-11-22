package agh.ics.oop.model;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import agh.ics.oop.OptionsParser;

import java.util.List;

public class SimulationTest {
    @Test
    public void testOrientation(){
        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        MoveValidator validator = new RectangularMapMoveValidator(map);
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.LEFT, validator);
        assertEquals(MapDirection.NORTH, animal.getOrientation());

    }
    @Test
    public void testPosition(){
        Animal animal = new Animal();
        WorldMap map = new RectangularMap(5, 5);
        map.place(animal);
        MoveValidator validator = new RectangularMapMoveValidator(map);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        animal.isAt(new Vector2d(2,3));
    }
    @Test
    public void testMapBoundary(){
        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        MoveValidator validator = new RectangularMapMoveValidator(map);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        animal.isAt(new Vector2d(2,4));
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        animal.isAt(new Vector2d(2, 0));
        map.move(animal, MoveDirection.RIGHT, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        map.move(animal, MoveDirection.FORWARD, validator);
        animal.isAt(new Vector2d(4, 0));
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        map.move(animal, MoveDirection.BACKWARD, validator);
        animal.isAt(new Vector2d(0,0));

    }
    @Test
    public void testInput(){
        String[] args = {"f", "b", "r", "l"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT), directions);
    }
}
