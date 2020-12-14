package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Player extends VBox {

    boolean isHuman = false;

    private int totalChipValue;
    private boolean hasPassed = false;
    private boolean hasLost = false;

    private ArrayList<Chip> chips;
    private ArrayList<Card> cards;

    private ChipBox chipBox = new ChipBox();

    private HBox firstRow = new HBox();
    private HBox cardHBox = new HBox();

    private Pane looseChips = new Pane();

    Random random = new Random();

    public Player() {
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setSpacing(10);

        looseChips.setPrefHeight(250);
        cardHBox.setPrefHeight(250);
        cardHBox.setAlignment(Pos.CENTER);

        generateChips();
        paintChips();

        cards = new ArrayList<Card>();
        totalChipValue = getTotalChipValue();

        firstRow.getChildren().addAll(cardHBox, chipBox, looseChips);
        getChildren().add(firstRow);
    }

    public void alignPlayer(Pos align) {
        cardHBox.setAlignment(align);
    }

    public void generateChips() {

        ArrayList<Chip> chips = new ArrayList<Chip>();

        for (int i = 0; i < 3; i++)
            chips.add(new Chip(ChipType.FIFTY, this));
        for (int i = 0; i < 2; i++)
            chips.add(new Chip(ChipType.ONEHUNDRED, this));

        chips.add(new Chip(ChipType.TWOHUNDREDFIFTY, this));

        this.chips = chips;
    }

    public void paintChips() {

        int x = 0;
        int y = 50;

        for (Chip chip : this.chips) {

            chip.relocate(x,y);
            looseChips.getChildren().add(chip);

            x += 10;
        }
    }

    public void paintCards() {
        for (Card card : cards) {
            if (!cardHBox.getChildren().contains(card)) {
                cardHBox.getChildren().add(card);
            }
        }
    }

    public int getTotalChipValue() {
        int amount = 0;
        for (Chip chip : chips) {
            amount += chip.getValue();
        }
        return amount;
    }

    public int getCardValue() {
        int amount = 0;
        ArrayList<Card> aceCards = new ArrayList<Card>();
        for (Card card : cards) {
            amount += card.getValue();
            if (card.isAce())
                aceCards.add(card);
        }

        if (amount > 21 && !aceCards.isEmpty()) {
            for (Card ace : aceCards) {
                amount -= 10;
                if (amount <= 21)
                    return amount;
            }
        }

        return amount;

    }

    public boolean addCard(Card card) {
        cards.add(card);
        if (getCardValue() > 21) {
            chipBox.makeEmpty();
            this.hasLost = true;
            return false;
        }
        return true;
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

    public HBox getFirstRow() {
        return firstRow;
    }

    public HBox getCardHBox() {
        return cardHBox;
    }

    public Pane getLooseChips() {
        return looseChips;
    }

    public ChipBox getChipBox() {
        return chipBox;
    }

    public boolean isHasPassed() {
        return hasPassed;
    }

    public boolean isHasLost() {
        return hasLost;
    }

    public void setHasPassed(boolean hasPassed) {
        this.hasPassed = hasPassed;
    }

    public void setHasLost(boolean hasLost) {
        this.hasLost = hasLost;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public Random getRandom() {
        return random;
    }
}
