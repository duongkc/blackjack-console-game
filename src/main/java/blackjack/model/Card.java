package blackjack.model;

/**
 * Card Model required to build a card deck with playing cards
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Card {
    private String suit;
    private String value;

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
}
