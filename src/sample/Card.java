package sample;

import javafx.scene.image.ImageView;

public class Card {
    private int value;
    private boolean isAce;

    private ImageView cardImageView;

    public Card(String imagePath, int value) {
        cardImageView = new ImageView(imagePath);
        this.value = value;

        isAce = value == 11;
    }

    public ImageView getCardImageView() {
        return cardImageView;
    }
}
