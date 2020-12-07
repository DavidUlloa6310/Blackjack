package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Player extends VBox {
    private int totalChipValue;

    private ArrayList<Chip> chips;
    private ArrayList<Card> cards;

    private HBox firstRow = new HBox();
    private HBox cardHBox = new HBox();
    private Pane chipBox = new Pane();

    Random random = new Random();

    public Player() {
        chipBox.setPrefSize(750,250);
        cardHBox.setPrefSize(750,250);
        cardHBox.setAlignment(Pos.CENTER);

        generateChips();
        paintChips();

        cards = new ArrayList<Card>();
        totalChipValue = getTotalChipValue();

        firstRow.getChildren().addAll(cardHBox, chipBox);
        getChildren().add(firstRow);
    }

    public void alignPlayer(Pos align) {
        cardHBox.setAlignment(align);
    }

    public void generateChips() {

        ArrayList<Chip> chips = new ArrayList<Chip>();

        for (int i = 0; i < 3; i++)
            chips.add(new Chip(ChipType.FIFTY));
        for (int i = 0; i < 2; i++)
            chips.add(new Chip(ChipType.ONEHUNDRED));

        chips.add(new Chip(ChipType.TWOHUNDREDFIFTY));

        this.chips = chips;
    }

    public void paintChips() {

        int x = 0;
        int y = 50;

        for (Chip chip : this.chips) {

            chip.getChipImageView().relocate(x,y);
            chipBox.getChildren().add(chip.getChipImageView());

            x += 10;
        }
    }

    public void paintCards() {
        for (Card card : cards) {
            cardHBox.getChildren().add(card);
        }
    }

    public int getTotalChipValue() {
        int amount = 0;
        for (Chip chip : chips) {
            amount += chip.getValue();
        }
        return amount;
    }

    public void addCard(Card card) {
        cards.add(card);
        cardHBox.getChildren().add(card);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public void removeChip(Chip chip) {
        chips.remove(chip);
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public HBox getCardHBox() {
        return cardHBox;
    }

    public Pane getChipBox() {
        return chipBox;
    }
}
