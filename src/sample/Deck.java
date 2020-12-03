package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {

    }

    public void generateDeck() {
        deck.add(new Card("images/card_b_c2_large.png", 2));
        deck.add(new Card("images/card_b_c3_large.png",3));
        deck.add(new Card("images/card_b_c4_large.png",4));
        deck.add(new Card("images/card_b_c5_large.png",5));
        deck.add(new Card("images/card_b_c6_large.png",6));
        deck.add(new Card("images/card_b_c7_large.png",7));
        deck.add(new Card("images/card_b_c8_large.png",8));
        deck.add(new Card("images/card_b_c9_large.png",9));
        deck.add(new Card("images/card_b_c10_large.png",10));
        deck.add(new Card("images/card_b_ca_large.png",1));
        deck.add(new Card("images/card_b_c3_large.png",3));
        deck.add(new Card("images/card_b_c3_large.png",3));
        deck.add(new Card("images/card_b_c3_large.png",3));

    }

    public class Card {
        private int value;
        private boolean isAce;

        private ImageView cardImageView;

        public Card(String imagePath, int value) {
            cardImageView = new ImageView(imagePath);
            this.value = value;

            isAce = value == 1;
        }
    }

}
