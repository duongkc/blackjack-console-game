package blackjack;

import blackjack.model.Card;

import java.util.Arrays;
import java.util.Stack;

/**
 * A classic game of blackjack. played solely through console commands.
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Blackjack {

    public static void main(String[] args) {
        Deck deck = new Deck();
//        deck.createDeck();
//        deck.shuffleDeck();
        System.out.println(Arrays.toString(deck.currentDeck.toArray()));
    }
}
