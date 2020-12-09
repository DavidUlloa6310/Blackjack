package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameScene extends VBox {

    private ArrayList<Player> players = new ArrayList<Player>();

    private HBox rowOne = new HBox();
    private HBox rowTwo = new HBox();

    private Dealer dealer = new Dealer();
    private Player computerOne = new Player();
    private Player computerTwo = new Player();
    private Player computerThree = new Player();
    private Player computerFour = new Player();
    private Player player = new Player();

    public GameScene() {

        rowOne.setAlignment(Pos.CENTER);
        rowOne.setSpacing(20);
        rowTwo.setAlignment(Pos.CENTER);
        rowTwo.setSpacing(20);

        Deck deck = new Deck();

        addPlayers();

        for (Player player : players) {
            player.addCard(deck.getRandomCard());
            player.addCard(deck.getRandomCard());
        }

        rowOne.getChildren().addAll(computerOne, computerTwo);
        rowTwo.getChildren().addAll(computerThree, computerFour);

        getChildren().addAll(dealer, rowOne, rowTwo, player);

        dealer.alignPlayer(Pos.CENTER_RIGHT);
        player.alignPlayer(Pos.CENTER_RIGHT);

        setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void addPlayers() {
        players.add(dealer);
        players.add(computerOne);
        players.add(computerTwo);
        players.add(computerThree);
        players.add(computerFour);
        players.add(player);
    }
}
