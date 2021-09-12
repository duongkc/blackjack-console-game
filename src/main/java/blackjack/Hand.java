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
        calcHandValue();
    }

    /**
     * Calculates total value of card hand
     */
    private void calcHandValue() {
        int valueWithoutAce = 0;
        int aceCount = 0;
        for (Card handCard : handCards) {
            String value = handCard.getValue();
            if (!"A".equals(value)) {
                if (value.equals("J") || value.equals("Q") || value.equals("K")) {
                    valueWithoutAce += 10;
                } else {
                    try {
                        valueWithoutAce += Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid card value");
                    }
                }
            } else {
                aceCount++;
            }
        }
        if (aceCount > 0) {
            if ((valueWithoutAce + 11 + (aceCount - 1)) <= 21) {
                handValue = valueWithoutAce + 11 + (aceCount - 1);
            } else {
                handValue = valueWithoutAce + aceCount;
            }
        } else {
            handValue = valueWithoutAce;
        }
    }
}
