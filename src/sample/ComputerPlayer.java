package sample;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    private ArrayList<String> names = new ArrayList<String>();

    public ComputerPlayer() {
        super();
        names.add("James Harrison");
        names.add("Ol' James");
        names.add("David Ulloa");
        names.add("Kyle Mendez");
        names.add("Nicholas Jimenez");
        names.add("Gabriel Waelter");
        names.add("Robert Princeton");
        names.add("Angie Smith");
        names.add("Daniel Diaz");
        names.add("Tristan Waterberry");
        generateName();
    }

    public boolean willHit() {
        if (getCardValue() < 17) {
            return true;
        } else {
            setHasPassed(true);
            return false;
        }
    }

    public void betRandomChip() {

        int numChips;

        if (getChips().size() > 10) {
            numChips = 2;
        } else {
            numChips = 1;
        }

        for (int i = 0; i < numChips; i++) {
            Chip chip = getChips().remove(getRandom().nextInt(getChips().size()));
            getChipBox().addChip(chip);
        }
    }

    public void generateName() {
        int index = getRandom().nextInt(names.size());
        setName(names.remove(index));
    }
}
