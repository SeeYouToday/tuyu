/**
 * プレーヤーの内部情報保持クラス
 */
public class Player {
	private int hp;
	private int maisuu;
	private boolean isDefence;
	private Hand hand;
	private Deck deck;
	private int pain;
	private Strategy strategy;

	/**
	 *
	 * @param hp，体力
	 * @param handMaisu，手札数
	 * @param isDefence，前回相手プレイヤーが防御行動をとったか否か，初期はtrue
	 *
	 */

	public Player(String strategyName) {
		this.strategy = setStrategy(strategyName);
		this.isDefence = true;
		/*
		for (int i = 0; i < handMaisu; i++) {
			hand.add(deck.draw());
		}
		*/
	}

	/**
	 * 戦略のインスタンス化するセッター
	 * @param strategyName 戦略の名前
	 * @return インスタンスを返す
	 */
	public Strategy setStrategy(String strategyName) {
		if (strategyName.equals(Strategy.STRATEGY.BOYSTRATEGY.name())) {
			return new BoyStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.GIRLSTRATEGY.name())) {
			return new GirlStrategy();
		}

		return null;

	}

	/**
	 * hpのセッター
	 * @param 現在の体力
	 */
	public void setHP(int hp) {
		strategy.setHp(hp);
	}

	/**
	 * hpのゲッター
	 * @return 現在の体力
	 *
	 */
	public int getHP() {
		return strategy.getterHp();
	}

	/**
	 * maisuuのセッター
	 * @param 現在の手札
	 */
	public void setMaisuu(int maisuu) {
		strategy.setMaisu(maisuu);
	}

	/**
	 * handのゲッター
	 * @return 現在の手札枚数
	 */
	public int getHandMaisu() {
		return strategy.getterMaisuu();
	}

	/**
	 * isDefenceのセッター
	 * @param isDefence
	 */
	public void setIsDefence(boolean isDefence) {
		this.isDefence = isDefence;
	}

	/**
	 * isDefenceのゲッター
	 * @return 前回の防御行動の有無
	 */
	public boolean getIsDefence() {
		return isDefence;
	}

	/**
	 * 手札を返すゲッター
	 * @return 手札
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * デッキを返すゲッター
	 * @return デッキ
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * 相手からのダメージのセッター
	 * @param pain 痛み
	 */
	public void setPain(int pain) {
		this.pain = pain;
	}

	/**
	 * 痛みを返す
	 * @return　相手の攻撃力
	 */
	public int getPain() {
		return pain;
	}
}
