import java.util.ArrayList;
import java.util.Random;
/**
 * デッキクラス
 */
public class Deck {

    protected ArrayList<Card> decks = new ArrayList<>();
    Random rand = new Random();

    public Deck(){

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
