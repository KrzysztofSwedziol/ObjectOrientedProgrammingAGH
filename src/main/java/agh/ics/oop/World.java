package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartował");
        List<MoveDirection> directions = new ArrayList<>();
        try {
            directions = OptionsParser.Parser(args);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        run(directions);
        System.out.println("system zakończył działanie");

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
        /*
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(10);
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
    */
        /*WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 4));
        Animal animal3 = new Animal(new Vector2d(3, 5));
        Animal animal4 = new Animal(new Vector2d(3, 6));
        Animal animal5 = new Animal(new Vector2d(3, 7));
        Animal animal6 = new Animal(new Vector2d(3, 8));
        try {
            map.place(animal2);
            map.place(animal1);
            map.place(animal3);
            map.place(animal4);
            map.place(animal5);
            map.place(animal6);
        }catch(PositionAlreadyOccupiedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(map);
        System.out.println(map.getElements());
        */
         GrassField map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 4));
        Animal animal3 = new Animal(new Vector2d(3, 5));
        ConsoleMapDisplay follower = new ConsoleMapDisplay();
        map.registerObserver(follower);
        try{
            map.place(animal1);
        }catch(PositionAlreadyOccupiedException e){
            System.out.println(e.getMessage());
        }

        try{
            map.place(animal2);
        }catch(PositionAlreadyOccupiedException e){
            System.out.println(e.getMessage());
        }
        try{
            map.place(animal3);
        }catch(PositionAlreadyOccupiedException e){
            System.out.println(e.getMessage());
        }

        map.move(animal1, MoveDirection.FORWARD);


    }

}
