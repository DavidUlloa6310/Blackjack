package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Chip extends ImageView {
    private int value;
    private ChipType chipType;
    private ImageView chipImageView;
    private Chip chip = this;
    private Player player;

    public Chip(ChipType chipType, Player player) {

        this.player = player;
        this.chipType = chipType;

        switch(chipType) {
            case FIFTY:
                value = 50;
                setImage(new Image(("images/chips/chip_white_top.png")));
                break;
            case ONEHUNDRED:
                value = 100;
                setImage(new Image(("images/chips/chip_red_top.png")));
                break;
            case TWOHUNDREDFIFTY:
                value = 250;
                setImage(new Image(("images/chips/chip_blue_top.png")));
                break;
            case FIVEHUNDRED:
                value = 500;
                setImage(new Image(("images/chips/chip_purple_top.png")));
                break;
            case THOUSAND:
                value = 1000;
                setImage(new Image(("images/chips/chip_black_top.png")));
                break;
        }

        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (player.isHuman() && !player.isHasLost() && player.getCards().size() == 0) {
                    moveChip();
                }
            }
        });

    }

    public int getValue() {
        return value;
    }

    public void moveChip() {
        player.removeChip(chip);
        player.getChipBox().addChip(chip);
    }

    public ChipType getChipType() {
        return chipType;
    }
}
