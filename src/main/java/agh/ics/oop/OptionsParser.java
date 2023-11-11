package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.Arrays;
public class OptionsParser {
    public static MoveDirection[] Parser(String[] args){
        MoveDirection[] Directions = new MoveDirection[args.length];
        int counter = 0;
        for(String arg : args){
            Directions[counter] = switch(arg){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> {
                    counter --;
                    yield null;
                }


            };
            counter++;

        }
        return  Directions;
    }
}
