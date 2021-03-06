package kcduong;

import kcduong.components.Deck;
import kcduong.components.Hand;

import java.util.Scanner;

/**
 * A classic game of blackjack. played solely through console commands.
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Blackjack {
    static Deck deck;
    static Hand hand;
    static Hand dealerHand;
    static int playerHandValue;
    static int dealerHandValue;
    static boolean done = false;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Blackjack!");
        System.out.println("Would you like to play? y/n");
        goPlay();
    }

    /**
     * Handles player's choice of wanting to play or not
     */
    private static void goPlay() {
        //noinspection InfiniteLoopStatement
        while (true) {
            String pick = s.nextLine();
            if (pick.equals("y") || pick.equals("n")) {
                run(pick);
            } else {
                System.out.println("Please type 'y' or 'n'");
            }
        }
    }

    /**
     * Either starts the game or exits program
     * @param pick yes/no choice of player
     */
    private static void run(String pick) {

        if (pick.equals("y")){
            System.out.println("Shuffling new deck...");
            System.out.println("Handing out cards...");
            deck = new Deck();
            hand = new Hand();
            dealerHand = new Hand();
            wait(1000);
            hand.addCard(deck.deal());
            dealerHand.addCard(deck.deal());
            hand.addCard(deck.deal());
            dealerHand.addCard(deck.deal());
            giveStatus();
            while (!done){
                String choice = s.nextLine();
                if (choice.equals("k") || choice.equals("p") || choice.equals("q")) {
                    handleChoice(choice);
                } else {
                    System.out.println("Please provide a valid answer ('k' | 'p' | 'q')");
                }
            }
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    /**
     * Handles player's pick during game
     * @param choice the action that the player picked
     */
    private static void handleChoice(String choice) {
        switch (choice) {
            case "q":
                System.out.println("Let's play again sometime, Goodbye!");
                wait(1000);
                System.exit(0);
                break;
            case "k":
                System.out.println("You take another card...");
                wait(1000);
                hand.addCard(deck.deal());
                giveStatus();
                break;
            case "p":
                playerHandValue = hand.getHandValue();
                dealDealerHand();
                decideWinner();

        }
    }

    /**
     * Automates the dealer's turns
     */
    private static void dealDealerHand() {

        System.out.println("Now it's the dealer's turn...");
        wait(1000);
        System.out.println("The dealer reveals their first 2 cards: ");
        getDealerStatus();
        wait(1000);
        while (dealerHand.getHandValue() < 17) {
            System.out.println("They take another card...");
            wait(1000);
            dealerHand.addCard(deck.deal());
            getDealerStatus();
            wait(1000);
        }
        if (dealerHand.getHandValue() > 21) {
            System.out.println("--------------------------------------");
            System.out.println("The dealer went bust! You win!");
            System.out.println("--------------------------------------");
            wait(1000);
            offerReplay();
        } else {
            dealerHandValue = dealerHand.getHandValue();
        }

    }

    /**
     * Asks for a reset
     */
    private static void offerReplay() {
        System.out.println("Would you like to play again? y/n");
        goPlay();
    }

    /**
     * Decide on winner based on hands of either player
     */
    private static void decideWinner() {
        System.out.println("--------------------------------------");
        System.out.println("You have a hand with " + hand.getNumberOfCards() + " cards, totalling: "
                + playerHandValue);
        System.out.println("The dealer has a hand with " + dealerHand.getNumberOfCards() + " cards, totalling: "
                + dealerHandValue);
        wait(1000);
        if (playerHandValue > dealerHandValue ||
                (playerHandValue == dealerHandValue && hand.getNumberOfCards() < dealerHand.getNumberOfCards())) {
            System.out.println("You win! Congratulations!");
        } else if (dealerHandValue > playerHandValue ||
                (playerHandValue == dealerHandValue && hand.getNumberOfCards() > dealerHand.getNumberOfCards())) {
            System.out.println("The dealer wins! Better luck next time!");
        } else if (playerHandValue == dealerHandValue && hand.getNumberOfCards() == dealerHand.getNumberOfCards()){
            System.out.println("It's a tie, baby!");
        }
        System.out.println("--------------------------------------");
        wait(1000);
        offerReplay();
    }

    /**
     * Prints out current status of the dealer's hand
     */
    private static void getDealerStatus() {
        System.out.println("Their current hand is: " + dealerHand.getHandCards());
        System.out.println("Their number of cards drawn: " + dealerHand.getNumberOfCards());
        System.out.println("Their hand value: " + dealerHand.getHandValue());
    }

    /**
     * Prints out current status of the player's hand
     */
    static void giveStatus() {
        System.out.println("Your current hand is: " + hand.getHandCards());
        System.out.println("Number of cards drawn: " + hand.getNumberOfCards());
        System.out.println("Value of hand: " + hand.getHandValue());
        if (hand.getHandValue() > 21) {
            System.out.println("--------------------------------------");
            wait(1000);
            System.out.println("You went bust! The dealer wins!\n--------------GAME OVER---------------");
            wait(1000);
            offerReplay();
        } else {
            System.out.println("press k to draw a card, press p to pass, press q to quit game");
        }
    }

    /**
     * provides delay
     * @param ms time in milliseconds
     */
    static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
