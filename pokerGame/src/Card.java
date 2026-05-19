public class Card {
    public enum Suit{
        HEARTS,DIAMONDS,SPADES,CLUBS;
    }
    public enum Rank{
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13), ACE(14);
        private final int value;
        Rank(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    private final Rank rank;
    private final Suit suit;
    public Card(Rank rank,Suit suit){
        this.suit=suit;
        this.rank=rank;
    }
    public Rank getRank(){
        return rank;
    }
    public Suit getSuit(){
        return suit;
    }
    @Override
    public String toString(){
        String rankStr;
        switch(rank){
            case JACK:
                rankStr="J";
                break;
            case ACE:
                rankStr="A";
                break;
            case QUEEN:
                rankStr="Q";
                break;
            case KING:
                rankStr="K";
                break;
            default:
                rankStr=String.valueOf(rank.getValue());
        }
        String suitSymbol;
        switch (suit) {
            case HEARTS:   suitSymbol = "♥"; break;
            case DIAMONDS: suitSymbol = "♦"; break;
            case CLUBS:    suitSymbol = "♣"; break;
            default:       suitSymbol = "♠"; // SPADES
        }
        return rankStr + suitSymbol;
    }
}


