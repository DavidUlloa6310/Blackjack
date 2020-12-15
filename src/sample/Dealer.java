package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dealer extends Player {

    HBox deckHBox = new HBox();
    Deck deck;

    public Dealer(Deck deck) {
        super();
        this.deck = deck;
        super.getFirstRow().getChildren().remove(super.getLooseChips());
        super.getFirstRow().setSpacing(20);

        deckHBox.getChildren().add(deck);
        deckHBox.setAlignment(Pos.CENTER_LEFT);

        deckHBox.setPrefWidth(600);

        super.getFirstRow().getChildren().add(deckHBox);
        super.getFirstRow().getChildren().remove(1);

        Rectangle chipPile = new Rectangle(2000,100, Color.WHITE);
        getChildren().addAll(chipPile);

        super.getChildren().remove(getName());

    }
}
