package blackjack;

import blackjack.model.Card;

import java.util.Collections;
import java.util.Stack;

/**
 * A Deck built of 52 different cards
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Deck {
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    Stack<Card> currentDeck = new Stack<>();
    Card topCard;

    public Deck() {
        createDeck();
        shuffleDeck();
    }

    /**
     * Creates new deck of cards
     */
    void createDeck() {
        int deckIndex = 0;
        for (String suit : suits) {
            for (String value : values) {
                // Puts new card on top of the stack
                this.currentDeck.push(new Card(suit, value));
            }
        }
    }

    /**
     * Shuffles deck of cards
     */
    void shuffleDeck() {
        if (currentDeck.size() > 1) {
            Collections.shuffle(this.currentDeck);
        }
        else {
            System.out.println("Not enough cards left to shuffle.");
        }
    }

    Card deal(){
        if(currentDeck.size() > 0) {
            return currentDeck.pop();
        }
        else {
            System.out.println("We've run out of cards!");
            return null;
        }
    }

}
