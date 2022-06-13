import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private static Deck deck = new Deck();
    protected ArrayList<Card> decks = new ArrayList<>();
    Random rand = new Random();

    private Deck(){
    	Card card = new Card(10, Card.KIND.DEFENCE, "gandou"); 
    	Card card2 = new Card(100000, Card.KIND.ATTACK, "uono");  
    	decks.add(card);
    	decks.add(card2);
    	decks.add(card);
    	decks.add(card2);
    	decks.add(card);
    	decks.add(card);
    	decks.add(card2);
    	decks.add(card);
    	}
    
    public static Deck getInstance() {
		return deck;
	}

    /**
     * デッキの内容をシャッフルするよ
     */
    public void shuffle(){

    }

    /**
     * デッキのトップから一枚ひくyp
     * @return
     */
    public Card draw(){
        return decks.remove(0);
    }
}
