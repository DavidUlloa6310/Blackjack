package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {
    private int value;
    private boolean isAce;
    private String imagePath;

    public Card(String imagePath, int value) {
        this.imagePath = imagePath;
        setImage(new Image(imagePath));
        this.value = value;

        isAce = value == 11;
    }

    public int getValue() {
        return value;
    }

    public boolean isAce() {
        return isAce;
    }

    public void flipDown() {
        setImage(new Image("images/cards/deck_1.png"));
    }

    public void flipUp() {
        setImage(new Image(imagePath));
    }

}
