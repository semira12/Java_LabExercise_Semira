import java.util.ArrayList;
import java.util.List;

public class Hand {

    public static final int HAND_SIZE = 5;

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    public Card removeCard(int index) {
        if (index < 0 || index >= cards.size()) {
            throw new IllegalArgumentException("Invalid card index: " + index);
        }
        return cards.remove(index);
    }

    // --- NEW: How many cards are currently in hand ---
    public int size() {
        return cards.size();
    }


    public void addCard(Card card) {
        if (cards.size() >= HAND_SIZE) {
            throw new IllegalStateException("Hand is already full (5 cards max).");
        }
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append("[").append(i + 1).append("]").append(cards.get(i)).append("  ");
        }
        return sb.toString();
    }

}
