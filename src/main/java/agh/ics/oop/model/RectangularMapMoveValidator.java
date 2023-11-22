package agh.ics.oop.model;

public class RectangularMapMoveValidator implements MoveValidator{
    private final WorldMap map;
    public RectangularMapMoveValidator(WorldMap map){
        this.map = map;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(map.canMoveTo(position)){
            return true;
        }
        return false;
    }
}
