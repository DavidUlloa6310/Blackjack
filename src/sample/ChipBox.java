package sample;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ChipBox extends StackPane {

    private ArrayList<Chip> betChips = new ArrayList<Chip>();
    private ImageView boxImageView = new ImageView("images/chipArea.png");
    private int totalChipAmount = 0;
    private Text chipAmountText = new Text("");

    public ChipBox() {

        chipAmountText.setFont(Font.font("Bauhaus 93", 50));
        chipAmountText.setFill(Color.GOLD);

        getChildren().addAll(chipAmountText, boxImageView);
    }

    public void addChip(Chip chip) {
        if (!betChips.contains(chip)) {
            betChips.add(chip);
            getChildren().add(chip);
            totalChipAmount += chip.getValue();

            chipAmountText.setText("$" + totalChipAmount);
            chipAmountText.toFront();
        }
    }

    public void makeEmpty() {
        for (Chip chip : betChips) {
            getChildren().remove(chip);
        }
        betChips = new ArrayList<Chip>();
        totalChipAmount = 0;
        chipAmountText.setText("");
    }
}
