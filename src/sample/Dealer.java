package sample;

import javafx.scene.layout.Pane;

public class Dealer extends Player {
    public Dealer() {
        super();

        Pane chipPile = new Pane();
        chipPile.setPrefSize(200,200);
        getChildren().add(chipPile);
    }
}
