package sample;

import java.util.ArrayList;

public class Player {
    private int totalChipValue;
    private ArrayList<Chip> chips;
    private ArrayList<Card> cards;

    public Player() {
        this.chips = generateChips();
        cards = new ArrayList<Card>();
        totalChipValue = getTotalChipValue();
    }

    private ArrayList<Chip> generateChips() {

        ArrayList<Chip> chips = new ArrayList<Chip>();

        for (int i = 0; i < 3; i++)
            chips.add(new Chip(ChipType.FIFTY));
        for (int i = 0; i < 2; i++)
            chips.add(new Chip(ChipType.ONEHUNDRED));

        chips.add(new Chip(ChipType.TWOHUNDREDFIFTY));

        return chips;
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
    }
    public void addChip(Chip chip) {
        chips.add(chip);
    }
    public void removeChip(Chip chip) {
        chips.remove(chip);
    }

}
