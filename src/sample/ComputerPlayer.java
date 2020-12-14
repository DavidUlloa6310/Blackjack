package sample;

public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        super();
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
}
