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

        List<Simulation> sims = new ArrayList<>();
        for(int i = 0; i<=1000; i++){
            GrassField map = new GrassField(10, i);
            List<Vector2d> positions = new ArrayList<>();
            positions.add(new Vector2d(10, 10));
            positions.add(new Vector2d(4, 7));
            positions.add(new Vector2d(3,5));

            List<MoveDirection> moves = List.of (MoveDirection.FORWARD, MoveDirection.FORWARD
                    , MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD
                    , MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT
                    , MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD);
            ConsoleMapDisplay follower = new ConsoleMapDisplay();
            map.registerObserver(follower);
            Simulation sim = new Simulation(positions, moves, map);
            sims.add(sim);
        }
        SimulationEngine simEng = new SimulationEngine(sims);
        //simEng.runAsync();
        try{
            simEng.runAsyncInThreadPool();
        }catch(InterruptedException e){
            System.out.println("Interrupted Exception");
        }
        simEng.awaitSimulationsEnd();

    }
    public static void run(List<MoveDirection> directions) {
        /*GrassField map1 = new GrassField(10, 1);
        RectangularMap map2 = new RectangularMap(10, 10, 2);
        List<Vector2d> positions1 = new ArrayList<>();
        List<Vector2d> positions2 = new ArrayList<>();
        positions1.add(new Vector2d(2, 2));
        positions1.add(new Vector2d(3,4));
        positions1.add(new Vector2d(3,5));

        List<MoveDirection> moves1 = List.of (MoveDirection.FORWARD, MoveDirection.FORWARD
        , MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD
        , MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT
        , MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD);

        ConsoleMapDisplay follower1 = new ConsoleMapDisplay();
        map1.registerObserver(follower1);

        positions2.add(new Vector2d(1, 2));
        positions2.add(new Vector2d(3,4));
        positions2.add(new Vector2d(5, 6));

        List<MoveDirection> moves2 = List.of (MoveDirection.FORWARD, MoveDirection.FORWARD
        , MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD
        , MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT
        , MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD);

        ConsoleMapDisplay follower2 = new ConsoleMapDisplay();
        map2.registerObserver(follower2);

        Simulation sim1 = new Simulation(positions1, moves1, map1);
        Simulation sim2 = new Simulation(positions2, moves2, map2);
        List<Simulation> sims = List.of(sim1, sim2);
        SimulationEngine simEng = new SimulationEngine(sims);
        simEng.runAsync();
        simEng.awaitSimulationsEnd();
        */

    }

}
