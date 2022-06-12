import java.util.ArrayList;

public class Hand {
    protected ArrayList<Card> hands = new ArrayList<>();
    public Hand(){

    }

    public void add(Card card){
        this.hands.add(card);
        if(hands.size() > 5){
            hands.remove(0);
        }
    }

    public Card use(int i){
        return this.hands.remove(i);
    }

    public Card check(int i){
        return this.hands.get(i);
    }
}
