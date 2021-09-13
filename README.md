# Java Blackjack

A Java Blackjack game played solely using the command line

####Rules
- The goal is to beat the dealer's hand without going over 21.
- Jack, Queen and King are worth 10.
- Aces are worth 1 or 11, whichever makes a better hand.
- You start with 2 cards and can ask for additional hits or pass.
- If you go over 21 you bust, and the dealer wins, regardless of the dealer's hand.
- If you are dealt 21 from the start (Ace & 10), you got a blackjack.
- Once passed, it's the dealer's turn.
- The dealer will hit until their total is 17 or higher. Higher than 21 means you win.
- In case of a point tie, the one with the least cards in their hand wins.


## Getting Started

```
git clone https://github.com/duongkc/blackjack-console-game
```
Clone the project and open the Gradle project (run build.gradle) with your IDE.  
Select Java version 11. 
Run the main java class `Blackjack.java`

## Built With

* [Gradle](https://gradle.org/) - Dependency Management
* [Java JDK 11](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

## Author
* **Kim Chau Duong** - [duongkc](https://github.com/duongkc/)


