package agh.ics.oop;
import java.util.List;
import agh.ics.oop.model.*;
import java.util.ArrayList;

public class Simulation {
    private List<Animal> animals;
    private List<MoveDirection> directions;
    private WorldMap map;
    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap map) {
        this.map = map;
        this.directions = directions;
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            this.animals.add(animal);
            map.place(animal);
        }
    }
    public void run(){
        int AnSize = animals.size();
        MoveValidator moveValidator = new RectangularMapMoveValidator(map);
        for(int i = 0; i < directions.size(); i++){
            Animal animal = animals.get(i%AnSize);
            map.move(animal, directions.get(i), moveValidator);
            animal.move(directions.get(i), moveValidator);
            System.out.println("Zwierzę " + (i % AnSize) + ": " + animal);

        }
    }
}
