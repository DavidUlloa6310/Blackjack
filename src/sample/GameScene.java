package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.*;
import java.util.ArrayList;

public class GameScene extends VBox {

    private ArrayList<Player> players = new ArrayList<Player>();

    private HBox rowOne = new HBox();
    private HBox rowTwo = new HBox();
    private HBox buttonRow = new HBox();

    private Player player = new Player();

    Deck deck = new Deck(player);
    private Dealer dealer = new Dealer(deck);

    private ComputerPlayer computerOne = new ComputerPlayer();
    private ComputerPlayer computerTwo = new ComputerPlayer();
    private ComputerPlayer computerThree = new ComputerPlayer();
    private ComputerPlayer computerFour = new ComputerPlayer();

    private Button pass;
    private Button hit;

    public GameScene() {

        player.setIsHuman(true);

        rowOne.setAlignment(Pos.CENTER);
        rowOne.setSpacing(20);
        rowTwo.setAlignment(Pos.CENTER);
        rowTwo.setSpacing(20);

        addPlayers();

        rowOne.getChildren().addAll(computerOne, computerTwo);
        rowTwo.getChildren().addAll(computerThree, computerFour);

        getChildren().addAll(dealer, rowOne, rowTwo, player, buttonRow);

        dealer.alignPlayer(Pos.CENTER_RIGHT);
        player.alignPlayer(Pos.CENTER_RIGHT);

        pass = new Button("Get Cards");
        pass.setFont(Font.font("Bauhaus 93", 50));
        pass.setStyle("-fx-background-color: #ff0000;");
        pass.setTextFill(Color.WHITE);
        pass.setPrefSize(300, 100);

        hit = new Button("Hit");
        hit.setFont(Font.font("Bauhaus 93", 50));
        hit.setStyle("-fx-background-color: #ff0000;");
        hit.setTextFill(Color.WHITE);
        hit.setPrefSize(300, 100);

        buttonRow.getChildren().add(pass);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setSpacing(100);

        pass.setOnAction(e -> {
            if (player.getCards().isEmpty()) {

                if (player.getChipBox().getTotalChipAmount() < 50) {
                    JOptionPane.showMessageDialog(null, "Please bet at least $50. ");
                } else {
                    for (Player player : players) {
                        player.addCard(deck.getRandomCard());
                        player.addCard(deck.getRandomCard());
                        player.paintCards();
                    }

                    for (ComputerPlayer computerPlayer : getComputers()) {
                        computerPlayer.betRandomChip();
                    }

                    dealer.addCard(deck.getRandomCard());
                    dealer.addCard(deck.getRandomCard());
                    dealer.getCards().get(1).flipDown();
                    dealer.paintCards();

                    pass.setText("Pass");
                    buttonRow.getChildren().add(hit);
                }

            } else {
                player.setHasPassed(true);
                startBotPlay();
            }
        });

        hit.setOnAction(e -> {
            if (!player.isHasLost()) {
                deck.giveRandomCard(player);
                if (player.isHasLost()) {
                    JOptionPane.showMessageDialog(null, "You have lost with score of " + player.getCardValue());
                    startBotPlay();
                }
            }
        });

        setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public ArrayList<ComputerPlayer> getComputers() {
        ArrayList<ComputerPlayer> arrayList = new ArrayList<ComputerPlayer>();
        arrayList.add(computerOne);
        arrayList.add(computerTwo);
        arrayList.add(computerThree);
        arrayList.add(computerFour);
        return arrayList;
    }

    public void startBotPlay() {
        for (ComputerPlayer bot : getComputers()) {
            while (bot.willHit()) {
                bot.addCard(deck.getRandomCard());
                bot.paintCards();
                if (bot.getCardValue() > 21) {
                    bot.getChipBox().makeEmpty();
                    bot.setHasLost(true);
                }
            }
        }
    }

    public void addPlayers() {
        //players.add(dealer);
        players.add(computerOne);
        players.add(computerTwo);
        players.add(computerThree);
        players.add(computerFour);
        players.add(player);
    }

}
