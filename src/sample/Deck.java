package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

import java.util.ArrayList;

public class Deck extends ImageView {

    private ArrayList<Card> deckCards;
    private Random random = new Random();
    private ImageView deckImageView = new ImageView("images/cards/deck_1.png");

    public Deck(Player humanPlayer) {
        setImage(new Image("images/cards/deck_1.png"));
        generateDeck();

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!humanPlayer.isHasLost())
                    giveRandomCard(humanPlayer);
            }
        });
    }

    public void generateDeck() {
        deckCards = new ArrayList<Card>();

        deckCards.add(new Card("images/cards/card_b_c2.png", 2));
        deckCards.add(new Card("images/cards/card_b_c3.png", 3));
        deckCards.add(new Card("images/cards/card_b_c4.png", 4));
        deckCards.add(new Card("images/cards/card_b_c5.png", 5));
        deckCards.add(new Card("images/cards/card_b_c6.png", 6));
        deckCards.add(new Card("images/cards/card_b_c7.png", 7));
        deckCards.add(new Card("images/cards/card_b_c8.png", 8));
        deckCards.add(new Card("images/cards/card_b_c9.png", 9));
        deckCards.add(new Card("images/cards/card_b_c10.png", 10));
        deckCards.add(new Card("images/cards/card_b_ca.png", 11));
        deckCards.add(new Card("images/cards/card_b_cj.png", 10));
        deckCards.add(new Card("images/cards/card_b_ck.png", 10));
        deckCards.add(new Card("images/cards/card_b_cq.png", 10));

        deckCards.add(new Card("images/cards/card_b_d2.png", 2));
        deckCards.add(new Card("images/cards/card_b_d3.png", 3));
        deckCards.add(new Card("images/cards/card_b_d4.png", 4));
        deckCards.add(new Card("images/cards/card_b_d5.png", 5));
        deckCards.add(new Card("images/cards/card_b_d6.png", 6));
        deckCards.add(new Card("images/cards/card_b_d7.png", 7));
        deckCards.add(new Card("images/cards/card_b_d8.png", 8));
        deckCards.add(new Card("images/cards/card_b_d9.png", 9));
        deckCards.add(new Card("images/cards/card_b_d10.png", 10));
        deckCards.add(new Card("images/cards/card_b_da.png", 11));
        deckCards.add(new Card("images/cards/card_b_dj.png", 10));
        deckCards.add(new Card("images/cards/card_b_dk.png", 10));
        deckCards.add(new Card("images/cards/card_b_dq.png", 10));

        deckCards.add(new Card("images/cards/card_b_h2.png", 2));
        deckCards.add(new Card("images/cards/card_b_h3.png", 3));
        deckCards.add(new Card("images/cards/card_b_h4.png", 4));
        deckCards.add(new Card("images/cards/card_b_h5.png", 5));
        deckCards.add(new Card("images/cards/card_b_h6.png", 6));
        deckCards.add(new Card("images/cards/card_b_h7.png", 7));
        deckCards.add(new Card("images/cards/card_b_h8.png", 8));
        deckCards.add(new Card("images/cards/card_b_h9.png", 9));
        deckCards.add(new Card("images/cards/card_b_h10.png", 10));
        deckCards.add(new Card("images/cards/card_b_ha.png", 11));
        deckCards.add(new Card("images/cards/card_b_hj.png", 10));
        deckCards.add(new Card("images/cards/card_b_hk.png", 10));
        deckCards.add(new Card("images/cards/card_b_hq.png", 10));

        deckCards.add(new Card("images/cards/card_b_s2.png", 2));
        deckCards.add(new Card("images/cards/card_b_s3.png", 3));
        deckCards.add(new Card("images/cards/card_b_s4.png", 4));
        deckCards.add(new Card("images/cards/card_b_s5.png", 5));
        deckCards.add(new Card("images/cards/card_b_s6.png", 6));
        deckCards.add(new Card("images/cards/card_b_s7.png", 7));
        deckCards.add(new Card("images/cards/card_b_s8.png", 8));
        deckCards.add(new Card("images/cards/card_b_s9.png", 9));
        deckCards.add(new Card("images/cards/card_b_s10.png", 10));
        deckCards.add(new Card("images/cards/card_b_sa.png", 11));
        deckCards.add(new Card("images/cards/card_b_sj.png", 10));
        deckCards.add(new Card("images/cards/card_b_sk.png", 10));
        deckCards.add(new Card("images/cards/card_b_sq.png", 10));

    }

    public Card getRandomCard() {
        return deckCards.remove(random.nextInt(deckCards.size()));
    }

    public void giveRandomCard(Player player) {
        player.addCard(getRandomCard());
        player.paintCards();
    }

}
