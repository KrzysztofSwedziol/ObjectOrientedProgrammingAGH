package agh.ics.oop;
import java.util.List;
import agh.ics.oop.model.*;
import java.util.ArrayList;

public class Simulation {
    private List<Animal> animals;
    private List<MoveDirection> directions;
    public Simulation(List<Vector2d> positions, List<MoveDirection> directions){
        this.directions = directions;
        this.animals = new ArrayList<>();
        for(Vector2d position : positions){
            this.animals.add(new Animal(position));
        }
    }
    public void run(){
        int AnSize = animals.size();
        for(int i = 0; i < directions.size(); i++){
            Animal animal = animals.get(i%AnSize);
            animal.move(directions.get(i));
            System.out.println("Zwierzę " + (i % AnSize) + ": " + animal);

        }
    }
}
