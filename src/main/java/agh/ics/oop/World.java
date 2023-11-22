package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartował");
        List<MoveDirection> directions = OptionsParser.Parser(args);
        run(directions);
        System.out.println("system zakończył działanie");


        Animal animal = new Animal();
        System.out.println(animal);


    }
    public static void run(List<MoveDirection> directions) {
        /*
        for(MoveDirection direction : directions){
            switch(direction){
                case FORWARD -> {
                    System.out.println("zwierzak idzie do przodu");
                }
                case BACKWARD -> {
                    System.out.println("zwierzak idzie do tyłu");
                }
                case RIGHT -> {
                    System.out.println("zwierzak idzie w prawo");
                }
                case LEFT -> {
                    System.out.println("Zwierzak idzie w lewo");
                }
            }
        }

         */
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new RectangularMap(6,4);
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

    }
}
