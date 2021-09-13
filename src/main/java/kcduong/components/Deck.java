package kcduong.components;

import kcduong.model.Card;

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
    private final Stack<Card> currentDeck = new Stack<>();

    public Deck() {
        createDeck();
        shuffleDeck();
    }

    /**
     * Creates new deck of cards
     */
    void createDeck() {
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

    /**
     * Deals a card that's on top of the deck (stack)
     * @return card popped out of the top of the stack
     */
    public Card deal(){
        if(currentDeck.size() > 0) {
            return currentDeck.pop();
        }
        else {
            System.out.println("We've run out of cards!");
            return null;
        }
    }

}
