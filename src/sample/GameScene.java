package sample;

import javafx.animation.AnimationTimer;
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
    private Button reset;

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

        reset = new Button("Next Round");
        reset.setFont(Font.font("Bauhaus 93", 50));
        reset.setStyle("-fx-background-color: #ff0000;");
        reset.setTextFill(Color.WHITE);
        reset.setPrefSize(300, 100);

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
                startDealerPlay();
                if (player.getCardValue() <= dealer.getCardValue() && dealer.getCardValue() <= 21) {
                    JOptionPane.showMessageDialog(null, "You have lost with score of " + player.getCardValue() + ", while the dealer had a score of " + dealer.getCardValue() + "\nYou have lost $" + player.getChipBox().getTotalChipAmount());
                } else {
                    JOptionPane.showMessageDialog(null, "You have won with score of " + player.getCardValue() + ", while the dealer had a score of " + dealer.getCardValue() + "\nYou have won $" + player.getChipBox().getTotalChipAmount());
                }
                checkBets();

                buttonRow.getChildren().remove(pass);
                buttonRow.getChildren().remove(hit);
                buttonRow.getChildren().add(reset);
            }
        });

        hit.setOnAction(e -> {
            if (!player.isHasLost()) {
                deck.giveRandomCard(player);
                if (player.isHasLost()) {
                    JOptionPane.showMessageDialog(null, "You have lost with score of " + player.getCardValue() + ", while the dealer had a score of " + dealer.getCardValue() + "\nYou have lost $" + player.getChipBox().getTotalChipAmount());
                    startBotPlay();
                    startDealerPlay();
                    checkBets();

                    buttonRow.getChildren().clear();
                    buttonRow.getChildren().add(reset);
                }
            }
        });

        reset.setOnAction(e -> {
            for (Player player : players) {
                player.reset();
            }

            dealer.reset();
            buttonRow.getChildren().remove(0);
            buttonRow.getChildren().add(pass);
            deck.generateDeck();
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

    public void startDealerPlay() {
        dealer.getCards().get(1).flipUp();
        while (dealer.getCardValue() < 17) {
            dealer.addCard(deck.getRandomCard());
        }
        dealer.paintCards();
    }

    public void checkBets() {

        for (Player player : players) {
            if ((dealer.isHasLost() || player.getCardValue() > dealer.getCardValue()) && !player.isHasLost()) {
                player.doubleChips();
            } else {
                player.getChipBox().makeEmpty();
            }
        }

        for (Player player : players) {
            if (!player.isHasLost() && player.getCardValue() > dealer.getCardValue()) {

                player.getChipBox().makeEmpty();
                player.paintChips();
            } else {
                player.getChipBox().makeEmpty();
                if (player.getTotalChipValue() == 0) {
                    player.generateChips();
                    player.paintChips();
                }
            }
        }
    }

    public void addPlayers() {
        players.add(computerOne);
        players.add(computerTwo);
        players.add(computerThree);
        players.add(computerFour);
        players.add(player);
    }

}
