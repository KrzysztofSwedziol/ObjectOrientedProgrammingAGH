package agh.ics.oop.model;
import java.util.Map;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

public class GrassFieldTest {
    @Test
    public void placeGrassTest(){
        GrassField map = new GrassField(10);
        Map<Vector2d, Grass> grass = map.getGrass();
        assertEquals(grass.size(), 10);

        GrassField map2 = new GrassField(100);
        Map<Vector2d, Grass> grass2 = map2.getGrass();
        assertEquals(grass2.size(), 100);

        GrassField map3 = new GrassField(25);
        Map<Vector2d, Grass> grass3 = map3.getGrass();
        assertEquals(grass3.size(), 25);

        GrassField map4 = new GrassField(300);
        Map<Vector2d, Grass> grass4 = map4.getGrass();
        assertEquals(grass4.size(), 300);
    }

    @Test
    public void objectAtTest(){
        GrassField map = new GrassField(10);
        Animal animal = new Animal(new Vector2d(1,2));
        Animal animal2 = new Animal(new Vector2d(3,4));
        Grass grass = new Grass(new Vector2d(6,7));
        Grass grass2 = new Grass(new Vector2d(3, 4));
        try{
            map.place(animal);
            assertEquals(map.objectAt(new Vector2d(1,2)), animal);
            map.place(animal2);
            map.setGrass(grass);
            assertEquals(map.getGrass().get(new Vector2d(6,7)), grass);
        }catch(PositionAlreadyOccupiedException e){

        }
        map.setGrass(grass2);
        assertEquals(map.objectAt(new Vector2d(3, 4)), animal2); //Testing if animal has priority over grass
        Animal animal3 = new Animal(new Vector2d(1, 2));
        try{
            map.place(animal3);
        }catch(PositionAlreadyOccupiedException e2){

        }
    }
}
