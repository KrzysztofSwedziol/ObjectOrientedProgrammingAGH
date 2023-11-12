package agh.ics.oop.model;
import agh.ics.oop.model.MapDirection;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal(Vector2d initialPosition){
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }
    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (new Vector2d(4, 4).precedes(newPosition) && new Vector2d(0, 0).follows(newPosition)) {
                    this.position = newPosition;
                }
                break;
            case BACKWARD:
                Vector2d newPositionBack = this.position.subtract(this.orientation.toUnitVector());
                if (new Vector2d(4, 4).precedes(newPositionBack) && new Vector2d(0, 0).follows(newPositionBack)) {
                    this.position = newPositionBack;
                }
                break;
        }
    }
    @Override
    public String toString(){
        return "Animal at "+position+" Looking at "+orientation;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }

}
