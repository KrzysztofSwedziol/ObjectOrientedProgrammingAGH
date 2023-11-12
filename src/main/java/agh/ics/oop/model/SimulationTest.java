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
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());

    }
    @Test
    public void testPosition(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.isAt(new Vector2d(2,3));
    }
    @Test
    public void testMapBoundary(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.isAt(new Vector2d(2,4));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.isAt(new Vector2d(2, 0));
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.isAt(new Vector2d(4, 0));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.isAt(new Vector2d(0,0));

    }
    @Test
    public void testInput(){
        String[] args = {"f", "b", "r", "l"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT), directions);
    }
}
