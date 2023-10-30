package agh.ics.oop;

import agh.ics.oop.model.*;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartował");
        MoveDirection[] directions = OptionsParser.Parser(args);
        run(directions);
        System.out.println("system zakończył działanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("Test MapDirection");
        MapDirectionTest a = new MapDirectionTest();
        System.out.println("testuję next najpierw dla :North -> South -> West -> East");
        a.nextTest();
        System.out.println("testuję prev najpierw dla :North -> South -> West -> East");
        a.prevTest();

        System.out.println("Test Vector2d");
        Vector2dTest b = new Vector2dTest();
        System.out.println("Equals najpierw dla dwóch równych wektorów, potem dla różnych: ");
        b.equalsTest();
        System.out.println("toString wektora x = 1 y = 1: ");
        b.toStringTest();
        System.out.println("Precedes najpierw dla dwóch różnych wektorów, następnie dla takich samych : ");
        b.precedesTest();
        System.out.println("Follows najpierw dla dwóch różnych wektorów, następnie dla takich samych: ");
        b.followsTest();
        System.out.println("upperRight dla różnych wektorów x=1y=1 i x=2y=3 : ");
        b.upperRightTest();
        System.out.println("lowerLeft dla różnych wektorów x=1y=1 i x=2y=3 : ");
        b.lowerLeftTest();
        System.out.println("add dla x=1y=1 i x=2y=3: ");
        b.addTest();
        System.out.println("sub dla x=1y=1 i x=2y=3 : ");
        b.subTest();
        System.out.println("opposite dla x=1y=1: ");
        b.oppositeTest();

        System.out.println("OptionsParserTest dla f,b,r,l,l,r");
        OptionParserTest c = new OptionParserTest();
        c.parserTest();


    }
    public static void run(MoveDirection[] directions) {
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

    }
}
