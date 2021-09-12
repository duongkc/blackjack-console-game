package blackjack;

import blackjack.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of hand with cards
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Hand {
    private final List<Card> handCards = new ArrayList<>();
    private int numberOfCards = 0;
    private int handValue = 0;

    public List<Card> getHandCards() {
        return handCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public int getHandValue() {
        return handValue;
    }


    /**
     * Adds card to current hand
     * @param card card with suit and value
     */
    void addCard(Card card) {
        this.handCards.add(card);
        numberOfCards++;
        int cardNumValue = calcNumValue(card.getValue());
        handValue += cardNumValue;
    }

    /**
     * Calculates actual value of card
     * @param value String value of card to be converted to its true value
     * @return calculated card value
     */
    private int calcNumValue(String value) {
        if (value.equals("J") || value.equals("Q") || value.equals("K")) {
            return 10;
        } else if (value.equals("A")) {
            if (handValue < 11) {
                return 11;
            } else {
                return 1;
            }
        } else {
            try {
                return Integer.parseInt(value);
            }
            catch (NumberFormatException e) {
                System.out.println("Not a valid card value");
                return 0;
            }
        }
    }
}
