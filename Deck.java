import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private static Deck deck = new Deck();
    protected ArrayList<Card> decks = new ArrayList<>();
    Random rand = new Random();


    private Deck(){
    	for(int i = 0; i < 3; i++){
            decks.add(new Card(10, Card.KIND.DEFENCE, "gandou"));
            decks.add(new Card(100000, Card.KIND.ATTACK, "uono"));
            decks.add(new Card(1, Card.KIND.ATTACK, "ちくりんてぉ"));
            decks.add(new Card(2, Card.KIND.DEFENCE, "カエルくん"));
            decks.add(new Card(2, Card.KIND.ATTACK, "c"));
            decks.add(new Card(3, Card.KIND.ATTACK, "d"));
            decks.add(new Card(4, Card.KIND.ATTACK, "e"));
            decks.add(new Card(5, Card.KIND.ATTACK, "f"));
            decks.add(new Card(6, Card.KIND.ATTACK, "g"));
            decks.add(new Card(7, Card.KIND.ATTACK, "h"));
        }
        shuffle();
    	}
    
    public static Deck getInstance() {
		return deck;
	}

    /**
     * デッキの内容をシャッフルするよ
     */
    public void shuffle(){
        for(int i = 0; i < decks.size(); i++){
            int shu = rand.nextInt(decks.size());
            decks.add(decks.remove(shu-1));
        }
        for(int i = 0; i < decks.size(); i++){
            int shu = rand.nextInt(decks.size());
            decks.add(decks.remove(shu-1));
        }
    }

    /**
     * デッキのトップから一枚ひくyp
     * @return
     */
    public Card draw(){
        return decks.remove(0);
    }

    public ArrayList<Card> getDeck(){
        return decks;
    }
}
