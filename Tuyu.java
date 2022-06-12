import java.util.ArrayList;

/**
 * このゲームのメインとなるクラス
 */
public class Tuyu {
	private ArrayList<Player> player;
	Deck deck = Deck.getInstance();

    public Tuyu(){
        player = new ArrayList<>();
    }

    public void addPlayer(String strategy){
        player.add(new Player(strategy));
    }
    
    public void makePlayerHand() {
    	for (Player player : player) {
    		int max = player.getStrategy().getMaisuu();
    		for (int i = 0; i < max; i++) {
    			player.getHand().add(deck.draw());
    		}
		}	
	}
    
    /**
     * プレイヤーのカードオブジェクトを返します
     * @param playerNum プレイヤー（はじめの人が0）
     */
    private Card getCard(int playerNum, int cardNum) {
		return player.get(playerNum).getHand().check(cardNum);
	}
    
    public String getCardName(int playerNum, int cardNum) {
		return getCard(playerNum, cardNum).getName();
	}
    
    public int getCardPower(int playerNum, int cardNum) {
		return getCard(playerNum, cardNum).getNum();
	}
    
    public Card.KIND getCardKind(int playerNum, int cardNum) {
		return getCard(playerNum, cardNum).getKind();
	}

}
