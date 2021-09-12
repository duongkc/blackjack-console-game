package blackjack;

import blackjack.model.Card;

import java.util.Stack;

/**
 * Class to
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Deck {
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    Stack<Card> createDeck() {
        Stack<Card> deck = new Stack<>();
        int deckIndex = 0;
        for (String suit : suits) {
            for (String value : values) {
//                deck[deckIndex] = new Card(suit, value);
//                deckIndex++;
                deck.push(new Card(suit, value));
            }

        }

        return deck;
    }

}
