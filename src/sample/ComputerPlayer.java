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
}
