import java.util.ArrayList;

/**
 * このゲームのメインとなるクラス
 */
public class Tuyu {
	/*
	 * player: ゲームを行うプレイヤーのリスト
	 * deck: シングルトンパターンであるDeckクラスの参照型変数
	 */
	private ArrayList<Player> player;
	Deck deck = Deck.getInstance();

	/**
	 * コンストラクタ
	 * playerのArrayList作成
	 */
    public Tuyu(){
        player = new ArrayList<>();
    }

    /**
     * プレイヤーを追加します
     * @param strategy プレイヤーの戦略名
     */
    public void addPlayer(String strategy){
        player.add(new Player(strategy));
    }

    /**
     * 最初の手札を割り振る
     */
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

    /**
     * 指定したプレイヤーのカード名を返します
     * @param playerNum プレイヤー（はじめの人が0）
     * @param cardNum カード番号
     * @return カード名
     */
    public String getCardName(int playerNum, int cardNum) {
		return getCard(playerNum, cardNum).getName();
	}

    /**
     * 指定したプレイヤーのカードの攻撃力(防御力)を返します
     * @param playerNum プレイヤー（はじめの人が0）
     * @param cardNum カード番号
     * @return 攻撃力(防御力)
     */
    public int getCardPower(int playerNum, int cardNum) {
		return getCard(playerNum, cardNum).getNum();
	}

    /**
     * 指定したプレイヤーのカードの種類を返します
     * @param playerNum プレイヤー（はじめの人が0）
     * @param cardNum カード番号
     * @return カードの種類
     */
    public Card.KIND getCardKind(int playerNum, int cardNum) {
		return getCard(playerNum, cardNum).getKind();
	}

}
