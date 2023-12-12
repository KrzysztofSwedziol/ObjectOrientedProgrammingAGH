package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;
import java.util.Random;
import agh.ics.oop.model.util.MapVisualizer;

public class GrassField extends AbstractWorldMap implements WorldMap{
    private int amount;
    private int grassWidth;
    private int grassHeight;
    private Boundary boundary;
    //private Map<Vector2d, Animal> animals = new HashMap<>();
    //private int width;
    //private int height;
    private Map<Vector2d, Grass> grass = new HashMap<>();
    public GrassField(int amount){
        this.amount = amount;
        this.grassHeight = (int)Math.sqrt(amount * 10);
        this.grassWidth = (int)Math.sqrt(amount * 10);
        this.width = Integer.MAX_VALUE;
        this.height = Integer.MAX_VALUE;
        placeGrass();
        this.mapVisualizer = new MapVisualizer(this);
        boundary = new Boundary(new Vector2d(0, 0), new Vector2d(width-1, height-1));
    }

    /*public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;

    }*/
    public void placeGrass(){
        int i = 0;
        Random rand = new Random();
        while(i < this.amount){
            int x = rand.nextInt(grassHeight);
            int y = rand.nextInt(grassWidth);
            if(objectAt(new Vector2d(x, y)) == null){
                Vector2d position = new Vector2d(x, y);
                this.grass.put(position, new Grass(position));
                i+=1;
            }
        }
    }
    @Override
    /*public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        Animal animal_check = new Animal(oldPosition);
        animal_check.move(direction, this);
        if (canMoveTo(animal_check.getPosition())) {
            animal.move(direction, this);
            animals.remove(oldPosition);
            animals.put(animal.getPosition(), animal);
        }
    }*/
    /*public boolean canMoveTo(Vector2d position){
        return position.follows(new Vector2d(this.width, this.height)) &&
                position.precedes(new Vector2d(0, 0)) &&
                !isOccupied(position);
    }*/

    /*public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }*/

    public WorldElement objectAt(Vector2d position) {
        if(animals.get(position) != null) {
            return animals.get(position);
        }
        else if(grass.get(position) != null) {
            return grass.get(position);
        } else {
            return null;
        }
    }
    public Boundary getCurrentBounds(){
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = 0;
        int max_y = 0;
        for(Vector2d position : animals.keySet()){
            int x = position.getX();
            int y = position.getY();
            min_x = Math.min(min_x, x);
            min_y = Math.min(min_y, y);
            max_x = Math.max(max_x, x);
            max_y = Math.max(max_y, y);
        }
        for(Vector2d position : grass.keySet()){
            int x = position.getX();
            int y = position.getY();
            min_x = Math.min(min_x, x);
            min_y = Math.min(min_y, y);
            max_x = Math.max(max_x, x);
            max_y = Math.max(max_y, y);
        }
        Vector2d lowerLeft = new Vector2d(min_x, min_y);
        Vector2d upperRight = new Vector2d(max_x, max_y);
        boundary = new Boundary(new Vector2d(min_x, min_y), new Vector2d(max_x, max_y));
        return boundary;

    }
    /*@Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = 0;
        int max_y = 0;
        for(Vector2d position : animals.keySet()){
            int x = position.getX();
            int y = position.getY();
            min_x = Math.min(min_x, x);
            min_y = Math.min(min_y, y);
            max_x = Math.max(max_x, x);
            max_y = Math.max(max_y, y);
        }
        for(Vector2d position : grass.keySet()){
            int x = position.getX();
            int y = position.getY();
            min_x = Math.min(min_x, x);
            min_y = Math.min(min_y, y);
            max_x = Math.max(max_x, x);
            max_y = Math.max(max_y, y);
        }
        Vector2d lowerLeft = new Vector2d(min_x, min_y);
        Vector2d upperRight = new Vector2d(max_x, max_y);


        return this.mapVisualizer.draw(getCurrentBounds().lowerLeft(), getCurrentBounds().upperRight());
    }*/
    public Map<Vector2d, Grass> getGrass(){
        return grass;
    }
    public void setGrass(Grass gra){    //Only for testing
        this.grass.put(gra.getPosition(), gra);
    }
    public Collection<WorldElement> getElements(){
        worldElements.addAll(grass.values());
        super.getElements();
        return worldElements;
    }
}
