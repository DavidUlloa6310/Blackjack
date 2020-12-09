package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dealer extends Player {

    Deck deck = new Deck();
    HBox deckHBox = new HBox();

    public Dealer() {
        super();
        super.getFirstRow().getChildren().remove(super.getChipBox());
        super.getFirstRow().setSpacing(20);

        deckHBox.getChildren().add(deck);
        deckHBox.setAlignment(Pos.CENTER_LEFT);

        deckHBox.setPrefWidth(600);

        super.getFirstRow().getChildren().add(deckHBox);

        Rectangle chipPile = new Rectangle(2000,200, Color.WHITE);
        getChildren().addAll(chipPile);
    }
}
