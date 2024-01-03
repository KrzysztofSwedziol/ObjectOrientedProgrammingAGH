package agh.ics.oop.model;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Collection<WorldElement> worldElements = new ArrayList<>();
    protected int width;
    protected int height;
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        Animal animal_check = new Animal(oldPosition);
        animal_check.move(direction, this);
        if (canMoveTo(animal_check.getPosition())) {
            animal.move(direction, this);
            animals.remove(oldPosition);
            animals.put(animal.getPosition(), animal);
        }
    }
    public boolean canMoveTo(Vector2d position){
        return position.follows(new Vector2d(this.width, this.height)) &&
                position.precedes(new Vector2d(0, 0)) &&
                !isOccupied(position);
    }
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Collection<WorldElement> getElements(){
        worldElements.addAll(animals.values());

        return worldElements;
    }
}
