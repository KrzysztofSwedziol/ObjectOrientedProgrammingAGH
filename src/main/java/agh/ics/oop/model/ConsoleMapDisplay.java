package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int operations_amount = 0;
    public void mapChanged(WorldMap worldMap, String message){
        System.out.println(worldMap.getID());
        System.out.println(message);
        System.out.println(worldMap);
        operations_amount += 1;
        System.out.println("Update amount : " + operations_amount);

    }
}
