package agh.ics.oop.model;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.List;

abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Collection<WorldElement> worldElements = new ArrayList<>();
    protected MapVisualizer mapVisualizer;
    protected int width;
    protected int height;
    protected List<MapChangeListener> observers = new ArrayList<>();
    protected int ID;
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        Vector2d position = animal.getPosition();
        if ((objectAt(position) instanceof Animal) == false) {
            this.animals.put(position, animal);
            mapChanged(animal + " placed at " + position);
            return true;
        } else {
            throw new PositionAlreadyOccupiedException(position);
        }
    }
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        Animal animal_check = new Animal(oldPosition);
        animal_check.move(direction, this);
        if (canMoveTo(animal_check.getPosition())) {
            animal.move(direction, this);
            animals.remove(oldPosition);
            animals.put(animal.getPosition(), animal);
            mapChanged(animal + " Moved to " + direction);
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

    public abstract Boundary getCurrentBounds();
    @Override
    public final String toString(){
        MapVisualizer vizualizer = new MapVisualizer(this);
        Boundary boundary = getCurrentBounds();
        return  vizualizer.draw(boundary.lowerLeft(), boundary.upperRight());
    }
    public void registerObserver(MapChangeListener observer){

        observers.add(observer);
    }
    public void unregisterObserver(MapChangeListener observer){

        observers.remove(observer);
    }
    public void mapChanged(String message){
        for(MapChangeListener observer : observers){
            observer.mapChanged(this, message);
        }
    }
    public int getID(){
        return this.ID;
    }
}
