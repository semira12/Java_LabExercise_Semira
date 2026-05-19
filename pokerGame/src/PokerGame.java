import java.util.Scanner;

public class PokerGame {

    private Deck deck;
    private Player[] players;
    private Scanner scanner;

    public PokerGame(String[] playerNames) {
        deck    = new Deck();
        deck.shuffle();
        scanner = new Scanner(System.in);

        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
    }

    public void dealHands() {
        for (int card = 0; card < Hand.HAND_SIZE; card++) {
            for (Player player : players) {
                player.receiveCard(deck.dealCard());
            }
        }
    }

    public void exchangeRound() {

        System.out.println("      EXCHANGE ROUND        ");
        System.out.println("  (Discard up to 3 cards each)");

        for (Player player : players) {
            System.out.println("--- " + player.getName() + "'s turn ---");
            System.out.println("Your hand: " + player.getHand());
            System.out.println("Cards left in deck: " + deck.remaining());
            System.out.println();

            int exchanged = 0;

            while (exchanged < 3) {
                System.out.print("Enter card number to discard [1-5], or 0 to keep remaining cards: ");
                int choice = readInt();

                if (choice == 0) {
                    System.out.println(player.getName() + " keeps the rest of their hand.\n");
                    break;
                }


                if (choice < 1 || choice > 5) {
                    System.out.println("  ⚠️  Invalid choice. Enter a number between 1 and 5 (or 0 to stop).");
                    continue;
                }

                if (deck.remaining() == 0) {
                    System.out.println("  ⚠️  No cards left in deck! Cannot exchange.");
                    break;
                }

                player.discardAndDraw(choice - 1, deck);
                exchanged++;

                System.out.println("  Updated hand: " + player.getHand());
                System.out.println();
            }

            if (exchanged == 3) {
                System.out.println("  Maximum exchanges (3) reached for " + player.getName() + ".\n");
            }
        }
    }


    public void showHands() {
        System.out.println("      FINAL HANDS            ");
        for (Player player : players) {
            int score       = Handevaluator.evaluate(player.getHand());
            String handName = Handevaluator.getHandName(score);
            System.out.println(player);
            System.out.println(  handName + " (score: " + score + ")\n");
        }
    }
    public void announceWinner() {
        Player winner  = players[0];
        int bestScore  = Handevaluator.evaluate(winner.getHand());

        for (int i = 1; i < players.length; i++) {
            int score = Handevaluator.evaluate(players[i].getHand());
            if (score > bestScore) {
                bestScore = score;
                winner    = players[i];
            }
        }

        System.out.println("   WINNER: " + winner.getName() + "!");
        System.out.println("  Winning hand: " + Handevaluator.getHandName(bestScore));

    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("  Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static void main(String[] args) {
        System.out.println("\n Welcome to 5-Card Draw Poker! 🃏\n");

        String[] playerNames = {"Alice", "Bob", "Charlie"};

        PokerGame game = new PokerGame(playerNames);

        System.out.println(">> Dealing hands...");
        game.dealHands();

        game.exchangeRound();

        game.showHands();
        game.announceWinner();
    }
}