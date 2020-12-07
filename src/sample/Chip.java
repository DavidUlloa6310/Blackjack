package sample;

import javafx.scene.image.ImageView;

public class Chip {
    private int value;
    private ImageView chipImageView;

    public Chip(ChipType chipType) {
        switch(chipType) {
            case FIFTY:
                value = 50;
                chipImageView = new ImageView("images/chips/chip_white_top.png");
                break;
            case ONEHUNDRED:
                value = 100;
                chipImageView = new ImageView("images/chips/chip_red_top.png");
                break;
            case TWOHUNDREDFIFTY:
                value = 250;
                chipImageView = new ImageView("images/chips/chip_blue_top.png");
                break;
            case FIVEHUNDRED:
                value = 500;
                chipImageView = new ImageView("images/chips/chip_purple_top.png");
                break;
            case THOUSAND:
                value = 1000;
                chipImageView = new ImageView("images/chips/chip_black_top.png");
                break;
        }
    }

    public int getValue() {
        return value;
    }

    public ImageView getChipImageView() {
        return chipImageView;
    }
}
