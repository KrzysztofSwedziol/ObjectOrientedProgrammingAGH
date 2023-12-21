package agh.ics.oop.model;
import java.util.Map;
public class RectangularMap extends AbstractWorldMap implements WorldMap {
    private Boundary boundary;


    public RectangularMap(int width, int height, int ID){
        this.width = width;
        this.height = height;
        this.ID = ID;
        boundary = new Boundary(new Vector2d(0, 0), new Vector2d(width-1, height-1));
    }

    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }
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
