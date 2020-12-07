package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {
    private int value;
    private boolean isAce;

    public Card(String imagePath, int value) {
        setImage(new Image(imagePath));
        this.value = value;

        isAce = value == 11;
    }
}
