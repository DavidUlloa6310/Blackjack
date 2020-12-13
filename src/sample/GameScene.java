package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameScene extends VBox {

    private ArrayList<Player> players = new ArrayList<Player>();

    private HBox rowOne = new HBox();
    private HBox rowTwo = new HBox();

    private Player player = new Player();

    Deck deck = new Deck(player);
    private Dealer dealer = new Dealer(deck);

    private ComputerPlayer computerOne = new ComputerPlayer();
    private ComputerPlayer computerTwo = new ComputerPlayer();
    private ComputerPlayer computerThree = new ComputerPlayer();
    private ComputerPlayer computerFour = new ComputerPlayer();

    public GameScene() {

        player.setIsHuman(true);

        rowOne.setAlignment(Pos.CENTER);
        rowOne.setSpacing(20);
        rowTwo.setAlignment(Pos.CENTER);
        rowTwo.setSpacing(20);

        addPlayers();

        for (Player player : players) {
            player.addCard(deck.getRandomCard());
            player.addCard(deck.getRandomCard());
//            player.addCard(deck.getRandomCard());
            player.paintCards();
        }

        rowOne.getChildren().addAll(computerOne, computerTwo);
        rowTwo.getChildren().addAll(computerThree, computerFour);

        getChildren().addAll(dealer, rowOne, rowTwo, player);

        dealer.alignPlayer(Pos.CENTER_RIGHT);
        player.alignPlayer(Pos.CENTER_RIGHT);


        addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.ENTER) {
                player.setHasPassed(true);
                startBotPlay();
            }
        });

        if (player.isHasLost()) {
            startBotPlay();
        }

        setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void startBotPlay() {

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
