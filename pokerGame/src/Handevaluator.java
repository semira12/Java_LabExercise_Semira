import java.util.*;

public class Handevaluator {
    public static final int HIGH_CARD       = 1;
    public static final int ONE_PAIR        = 2;
    public static final int TWO_PAIR        = 3;
    public static final int THREE_OF_A_KIND = 4;
    public static final int STRAIGHT        = 5;
    public static final int FLUSH           = 6;
    public static final int FULL_HOUSE      = 7;
    public static final int FOUR_OF_A_KIND  = 8;
    public static final int STRAIGHT_FLUSH  = 9;
    public static final int ROYAL_FLUSH     = 10;




    private static boolean checkFlush(List<Card> cards) {
        Card.Suit suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit() != suit) return false;
        }
        return true;
    }
    private static List<Integer> getSortedValues(List<Card> cards) {
        List<Integer> values = new ArrayList<>();
        for (Card card : cards) {
            values.add(card.getRank().getValue());
        }
        Collections.sort(values);
        return values;
    }
    private static boolean checkStraight(List<Card> cards) {
        List<Integer> values = getSortedValues(cards);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) != values.get(i - 1) + 1) return false;
        }
        return true;
    }
    private static int getHighCard(List<Card> cards) {
        int max = 0;
        for (Card card : cards) {
            max = Math.max(max, card.getRank().getValue());
        }
        return max;
    }
    private static Map<Integer, Integer> getFrequencyMap(List<Card> cards) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Card card : cards) {
            int val = card.getRank().getValue();
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        return freq;
    }

    public static int evaluate(Hand hand) {
        List<Card> cards = hand.getCards();

        boolean isFlush    = checkFlush(cards);
        boolean isStraight = checkStraight(cards);
        Map<Integer, Integer> freq = getFrequencyMap(cards);

        if (isFlush && isStraight && getHighCard(cards) == 14) return ROYAL_FLUSH;
        if (isFlush && isStraight)                              return STRAIGHT_FLUSH;
        if (freq.containsValue(4))                              return FOUR_OF_A_KIND;
        if (freq.containsValue(3) && freq.containsValue(2))    return FULL_HOUSE;
        if (isFlush)                                            return FLUSH;
        if (isStraight)                                         return STRAIGHT;
        if (freq.containsValue(3))                              return THREE_OF_A_KIND;
        if (Collections.frequency(new ArrayList<>(freq.values()), 2) == 2) return TWO_PAIR;
        if (freq.containsValue(2))                              return ONE_PAIR;

        return HIGH_CARD;
    }

    public static String getHandName(int score) {
        switch (score) {
            case ROYAL_FLUSH:     return "Royal Flush";
            case STRAIGHT_FLUSH:  return "Straight Flush";
            case FOUR_OF_A_KIND:  return "Four of a Kind";
            case FULL_HOUSE:      return "Full House";
            case FLUSH:           return "Flush";
            case STRAIGHT:        return "Straight";
            case THREE_OF_A_KIND: return "Three of a Kind";
            case TWO_PAIR:        return "Two Pair";
            case ONE_PAIR:        return "One Pair";
            default:              return "High Card";
        }
    }
}
