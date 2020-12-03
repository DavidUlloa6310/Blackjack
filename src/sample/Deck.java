package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        generateDeck();
    }

    public void generateDeck() {
        deck = new ArrayList<Card>();

        deck.add(new Card("images/card_b_c2_large.png", 2));
        deck.add(new Card("images/card_b_c3_large.png",3));
        deck.add(new Card("images/card_b_c4_large.png",4));
        deck.add(new Card("images/card_b_c5_large.png",5));
        deck.add(new Card("images/card_b_c6_large.png",6));
        deck.add(new Card("images/card_b_c7_large.png",7));
        deck.add(new Card("images/card_b_c8_large.png",8));
        deck.add(new Card("images/card_b_c9_large.png",9));
        deck.add(new Card("images/card_b_c10_large.png",10));
        deck.add(new Card("images/card_b_ca_large.png",11));
        deck.add(new Card("images/card_b_cj_large.png",10));
        deck.add(new Card("images/card_b_ck_large.png",10));
        deck.add(new Card("images/card_b_cq_large.png",10));

        deck.add(new Card("images/card_b_d2_large.png", 2));
        deck.add(new Card("images/card_b_d3_large.png",3));
        deck.add(new Card("images/card_b_d4_large.png",4));
        deck.add(new Card("images/card_b_d5_large.png",5));
        deck.add(new Card("images/card_b_d6_large.png",6));
        deck.add(new Card("images/card_b_d7_large.png",7));
        deck.add(new Card("images/card_b_d8_large.png",8));
        deck.add(new Card("images/card_b_d9_large.png",9));
        deck.add(new Card("images/card_b_d10_large.png",10));
        deck.add(new Card("images/card_b_da_large.png",11));
        deck.add(new Card("images/card_b_dj_large.png",10));
        deck.add(new Card("images/card_b_dk_large.png",10));
        deck.add(new Card("images/card_b_dq_large.png",10));

        deck.add(new Card("images/card_b_h2_large.png", 2));
        deck.add(new Card("images/card_b_h3_large.png",3));
        deck.add(new Card("images/card_b_h4_large.png",4));
        deck.add(new Card("images/card_b_h5_large.png",5));
        deck.add(new Card("images/card_b_h6_large.png",6));
        deck.add(new Card("images/card_b_h7_large.png",7));
        deck.add(new Card("images/card_b_h8_large.png",8));
        deck.add(new Card("images/card_b_h9_large.png",9));
        deck.add(new Card("images/card_b_h10_large.png",10));
        deck.add(new Card("images/card_b_ha_large.png",11));
        deck.add(new Card("images/card_b_hj_large.png",10));
        deck.add(new Card("images/card_b_hk_large.png",10));
        deck.add(new Card("images/card_b_hq_large.png",10));

        deck.add(new Card("images/card_b_s2_large.png", 2));
        deck.add(new Card("images/card_b_s3_large.png",3));
        deck.add(new Card("images/card_b_s4_large.png",4));
        deck.add(new Card("images/card_b_s5_large.png",5));
        deck.add(new Card("images/card_b_s6_large.png",6));
        deck.add(new Card("images/card_b_s7_large.png",7));
        deck.add(new Card("images/card_b_s8_large.png",8));
        deck.add(new Card("images/card_b_s9_large.png",9));
        deck.add(new Card("images/card_b_s10_large.png",10));
        deck.add(new Card("images/card_b_sa_large.png",11));
        deck.add(new Card("images/card_b_sj_large.png",10));
        deck.add(new Card("images/card_b_sk_large.png",10));
        deck.add(new Card("images/card_b_sq_large.png",10));

    }

    public class Card {
        private int value;
        private boolean isAce;

        private ImageView cardImageView;

        public Card(String imagePath, int value) {
            cardImageView = new ImageView(imagePath);
            this.value = value;

            isAce = value == 11;
        }
    }

}
