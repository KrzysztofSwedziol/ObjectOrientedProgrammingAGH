package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;
public class OptionsParser {
    public static List<MoveDirection> Parser(String[] args){
        List<MoveDirection> Directions = new ArrayList<>();
        for(String arg : args){
            switch(arg){
                case "f" -> Directions.add(MoveDirection.FORWARD);
                case "b" -> Directions.add(MoveDirection.BACKWARD);
                case "r" -> Directions.add(MoveDirection.RIGHT);
                case "l" -> Directions.add(MoveDirection.LEFT);
                default ->
                    throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return Directions;
    }
}
