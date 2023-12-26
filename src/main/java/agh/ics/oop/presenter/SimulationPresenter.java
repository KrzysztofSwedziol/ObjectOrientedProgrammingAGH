package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter {
    private GrassField map;

    @FXML
    private Label infoLabel;
    @FXML
    private TextField movesField;
    @FXML
    private GridPane mapGrid;

    private static final int CELL_WIDTH = 45;
    private static final int CELL_HEIGHT = 45;

    public void setWorldMap(GrassField map){

        this.map = map;
    }
    public void drawMap(){
        clearGrid();
        Boundary bounds = map.getCurrentBounds();

        for (int i = 0; i < bounds.upperRight().getX(); i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }
        for (int i = 0; i < bounds.upperRight().getY(); i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }
        for (int x = 0; x < bounds.upperRight().getX(); x++) {
            for (int y = 0; y < bounds.upperRight().getY(); y++) {
                Vector2d position = new Vector2d(x, y);
                Label label = new Label();
                WorldElement object = map.objectAt(position);
                if(object == null){
                    label.setText(" ");
                }else{
                    label.setText(object.toString());
                }

                GridPane.setHalignment(label, HPos.CENTER);
                mapGrid.add(label, x, y);
            }
        }

    }
    public String[] getMoves(){
        String moves = movesField.getText();
        String[] movesArray = moves.split(",");
        return movesArray;
    }
    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
    @FXML
    public void onSimulationStartClicked(){
        String[] movesArray = getMoves();

        GrassField map1 = new GrassField(10, 1);
        List<Vector2d> positions1 = new ArrayList<>();
        positions1.add(new Vector2d(2, 2));
        positions1.add(new Vector2d(3,4));
        positions1.add(new Vector2d(3,5));

        OptionsParser optionsParser = new OptionsParser();

        List<MoveDirection> moves1 = optionsParser.Parser(movesArray);

        map1.registerObserver(this);
        this.setWorldMap(map1);

        Simulation sim1 = new Simulation(positions1, moves1, map1);

        new Thread(() -> {
            sim1.run();
            Platform.runLater(this::drawMap);
        }).start();
    }
}
