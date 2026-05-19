import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck(){
        cards=new ArrayList<>();
        for(Card.Suit suit:Card.Suit.values()){
            for(Card.Rank rank:Card.Rank.values()){
                Card card=new Card(rank,suit);
                cards.add(card);
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card dealCard(){
        if(cards.isEmpty()){
            throw new IllegalStateException("deck is empty.");
        }
        return cards.remove(0);
    }
    public int remaining(){
        return cards.size();
    }
}
