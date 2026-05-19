
public class Player {

    private String name;
    private Hand hand;
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    public void receiveCard(Card card) {
        hand.addCard(card);
    }
    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
    public void discardAndDraw(int index, Deck deck) {
        Card discarded = hand.removeCard(index);
        Card newCard   = deck.dealCard();
        hand.addCard(newCard);
        System.out.println("  Discarded: " + discarded + "  |  Drew: " + newCard);
    }
    @Override
    public String toString() {
        return name + "'s Hand: " + hand;
    }
}
