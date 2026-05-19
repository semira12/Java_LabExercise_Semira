
# Java Poker Game

A console-based Poker Game developed in Java using object-oriented programming principles.  
This project simulates a simple poker game with card dealing, hand evaluation, and winner determination.

---

# Features

- Standard 52-card deck
- Card shuffling
- Multiple players
- Card dealing system
- Hand management
- Poker hand evaluation
- Winner comparison
- Console-based gameplay


# Class Descriptions

## Card.java
Represents a single playing card.

Responsibilities:
- Store card rank
- Store card suit
- Display card information

---

## Deck.java
Represents the full deck of cards.

Responsibilities:
- Create 52 cards
- Shuffle deck
- Deal cards to players

---

## Hand.java
Represents a player's hand.

Responsibilities:
- Store cards
- Add/remove cards
- Display hand

---

## Player.java
Represents a player in the game.

Responsibilities:
- Store player name
- Store player hand
- Manage player actions

---

## Handevaluator.java
Handles poker hand evaluation.

Detects:
- Pair
- Two Pair
- Three of a Kind
- Straight
- Flush
- Full House
- Four of a Kind
- Straight Flush
- Royal Flush

---

## PokerGame.java
Main game controller.

Responsibilities:
- Start the game
- Create players
- Deal cards
- Evaluate hands
- Determine winner

---

# How to Run

1. Open the project in IntelliJ IDEA or any Java IDE
2. Compile all Java files
3. Run `PokerGame.java`

---

# Author

Developed for learning Java programming and object-oriented software development.
