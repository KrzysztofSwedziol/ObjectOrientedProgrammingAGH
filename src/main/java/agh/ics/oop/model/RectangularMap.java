package agh.ics.oop.model;
import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.MoveValidator;

public class RectangularMap extends AbstractWorldMap implements WorldMap {
    //private Map<Vector2d, Animal> animals = new HashMap<>();
    //private int width;
    //private int height;
    private Boundary boundary;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        boundary = new Boundary(new Vector2d(0, 0), new Vector2d(width-1, height-1));
    }

    /*public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }*/
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
        return position.follows(new Vector2d(width, height)) &&
                position.precedes(new Vector2d(0, 0)) &&
                !isOccupied(position);
    }*/

    /*public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }*/

    public Animal objectAt(Vector2d position) {
        /*WorldElement element = super.objectAt(position);
        if(element == null) {
            element = animals.get(position);
        }
        return element;*/
        return animals.get(position);
    }

    /*public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(width - 1, height - 1);
        return visualizer.draw(lowerLeft, upperRight);
    }*/


    public Map<Vector2d, Animal> getAnimals(){
        return animals;
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
        Vector2d lowerLeft = new Vector2d(min_x, min_y);
        Vector2d upperRight = new Vector2d(max_x, max_y);
        boundary = new Boundary(new Vector2d(min_x, min_y), new Vector2d(max_x, max_y));
        return boundary;
    }

}
