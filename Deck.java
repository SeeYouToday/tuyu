import java.util.ArrayList;
import java.util.Random;

public class Deck {

    protected ArrayList<Card> decks = new ArrayList<>();
    Random rand = new Random();

    public Deck(){

    }

    public void shuffle(){

    }

    public Card drow(){
        return decks.remove(0);
    }
}
