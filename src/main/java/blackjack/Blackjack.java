package blackjack;

import blackjack.model.Card;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * A classic game of blackjack. played solely through console commands.
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Blackjack {
    static Deck deck = new Deck();
    static Hand hand = new Hand();
    static boolean done = false;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(deck.currentDeck.toArray()));

        System.out.println("Welcome to Blackjack!");
        System.out.println("Would you like to play? y/n");
        String play = s.nextLine();
        if (play.equals("y")){
            System.out.println("Shuffling new deck...");
            System.out.println("Handing out cards...");
            hand.addCard(deck.deal());
            hand.addCard(deck.deal());
            giveStatus(hand);
            while (!done){
                String choice = s.nextLine();
                if (choice.equals("k") || choice.equals("p") || choice.equals("q")) {
                    handleChoice(choice);
                } else {
                    System.out.println("Please pick give a valid answer ('k' | 'p' | 'q')");
                }


            }
        } else {
            System.out.println("Goodbye!");
        }
    }

    private static void handleChoice(String choice) {
        if (choice.equals("q")){
            System.out.println("Let's play again sometime, Goodbye!");
            done = true;
        } else if (choice.equals("k")){
            hand.addCard(deck.deal());
            giveStatus(hand);
        } else {
            ;
        }
    }

    static void giveStatus(Hand hand) {
        System.out.println("Your current hand is: " + hand.handCards);
        System.out.println("Number of cards drawn: " + hand.numberOfCards);
        System.out.println("Value of hand: " + hand.handValue);
        System.out.println("press k to draw a card, press p to pass, press q to quit game");
    }
}
