package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GameScene extends Pane {
    public GameScene() {
        Deck deck = new Deck();

        VBox computerOneBox = new VBox();
        computerOneBox.getChildren().add(deck.getRandomCard().getCardImageView());
        computerOneBox.relocate(0,0);

        VBox computerTwoBox = new VBox();
        computerTwoBox.getChildren().add(deck.getRandomCard().getCardImageView());
        computerTwoBox.relocate(800, 0);

        HBox dealerBox = new HBox();
        dealerBox.getChildren().add(deck.getRandomCard().getCardImageView());
        dealerBox.relocate(500, 0);

        HBox playerBox = new HBox();
        playerBox.getChildren().add(deck.getRandomCard().getCardImageView());
        playerBox.relocate(0, 600);

        HBox computerThreeBox = new HBox();
        computerThreeBox.getChildren().add(deck.getRandomCard().getCardImageView());
        computerThreeBox.relocate(500, 600);

        getChildren().add(computerOneBox);
        getChildren().add(dealerBox);
        getChildren().add(playerBox);
        getChildren().add(computerThreeBox);
        getChildren().add(computerTwoBox);

        setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));


    }
}
