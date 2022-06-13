import java.util.ArrayList;

/**
 * このゲームのメインとなるクラス
 * @author 北川奨真
 */
public class Tuyu {
	/*
	 * player: ゲームを行うプレイヤーのリスト
	 * deck: シングルトンパターンであるDeckクラスの参照型変数
	 */
	protected ArrayList<Player> players;
	Deck deck = Deck.getInstance();
	/**
	 * コンストラクタ
	 * playerのArrayList作成
	 */
    public Tuyu(){
        players = new ArrayList<>();
    }

    /**
     * プレイヤーを追加します
     * @param strategy プレイヤーの戦略名
     */
    public void addPlayer(String strategy){
        players.add(new Player(strategy));
    }
    
    /**
     * プレイヤーのゲッター
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 
     */
    public Player getPlayer(int playerNum) {
    	return players.get(playerNum);
    }

    /**
     * 最初の手札を割り振る
     */
    public void makePlayerHand() {
    	for (Player player : players) {
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
		return players.get(playerNum).getHand().check(cardNum);
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

    /**
     * 下記のメソッドで使うプレイヤーの攻撃カードを選ぶ
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 攻撃で選ばれたCardオブジェクト
     */
    private Card decideAttackCard(int playerNum) {
    	return players.get(playerNum).getHand().use(players.get(playerNum).getStrategy().decideAttack(players.get(playerNum)));
    }
    
    /**
     * 攻撃カードの名前を返す
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 攻撃カードの名前
     */
    public String getAttackCardName(int playerNum) {
    	return decideAttackCard(playerNum).getName();
    }

    /**
     * 攻撃カードの攻撃力を返す
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 攻撃カードの攻撃力
     */
    public int getAttackCardPower(int playerNum) {
    	return decideAttackCard(playerNum).getNum();
    }

    /**
     * 下記のメソッドで使うプレイヤーの防御カードを選ぶ
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 防御で選ばれたCardオブジェクト
     */
    private Card decideDefenceCard(int playerNum) {
    	return players.get(playerNum).getHand().use(players.get(playerNum).getStrategy().decideDefence(players.get(playerNum)));
    }
    
    /**
     * 防御カードの名前を返す
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 防御カードの名前
     */
    public String getDefenceCardName(int playerNum) {
    	return decideDefenceCard(playerNum).getName();
    }

    /**
     * 防御カードの防御力を返す
     * @param playerNum プレイヤー（はじめの人が0）
     * @return 防御カードの防御力
     */
    public int getDefenceCardPower(int playerNum) {
    	return decideDefenceCard(playerNum).getNum();
    }
    
    /**
     * player0の行動メソッド
     */
    private void playerZeroAction() {
    	TuyuAction tuyuAction = new TuyuAction(decideAttackCard(0), decideDefenceCard(1), this);
    	tuyuAction.action(1);
    	
    }
    
    /**
     * player1の行動メソッド
     */
    private void playerOneAction() {
    	TuyuAction tuyuAction = new TuyuAction(decideAttackCard(1), decideDefenceCard(0), this);
    	tuyuAction.action(0);
    	
    }
    
    /**
     * 試合を進行します
     */
    public void actions() {
		System.out.println("player0のHP: "+getPlayer(0).getHP());
		System.out.println("player1のHP: "+getPlayer(1).getHP());
		System.out.println();
    	while (getPlayer(0).getHP()>0 && getPlayer(1).getHP()>0) {
			playerZeroAction();
			System.out.println("player0のHP: "+getPlayer(0).getHP());
    		System.out.println("player1のHP: "+getPlayer(1).getHP());
    		System.out.println();
			playerOneAction();
    		System.out.println("player0のHP: "+getPlayer(0).getHP());
    		System.out.println("player1のHP: "+getPlayer(1).getHP());
    		System.out.println();
    		if (getPlayer(0).getHand().check(0).getKind()==Card.KIND.END 
    				|| getPlayer(1).getHand().check(0).getKind()==Card.KIND.END) {
    			getPlayer(0).getHand().clearHand();
    			getPlayer(1).getHand().clearHand();
    			System.out.println("デッキがなくなりました");
				break;
			}
		}
    	if (getPlayer(0).getHP()>getPlayer(1).getHP()) {
    		getPlayer(0).getHand().add(new Card(0, Card.KIND.WIN, ""));
    		getPlayer(1).getHand().add(new Card(0, Card.KIND.LOSE, ""));
		}else if (getPlayer(0).getHP()<getPlayer(1).getHP()) {
			getPlayer(0).getHand().add(new Card(0, Card.KIND.LOSE, ""));
    		getPlayer(1).getHand().add(new Card(0, Card.KIND.WIN, ""));
		}else {
			getPlayer(0).getHand().add(new Card(0, Card.KIND.PEACE, ""));
    		getPlayer(1).getHand().add(new Card(0, Card.KIND.PEACE, ""));
		}
    }
}
