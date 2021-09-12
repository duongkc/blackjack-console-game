package blackjack;

import blackjack.model.Card;

import java.util.Arrays;

/**
 * A classic game of blackjack. played solely through console commands.
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Blackjack {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card[] newDeck = deck.createDeck();
        System.out.println(Arrays.toString(newDeck));
    }
}
