/**
 * プレーヤーの内部情報保持クラス
 */
public class Player {
	private boolean isDefence;
	private Hand hand;
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
		hand = new Hand();
		this.strategy = setStrategy(strategyName);
		this.isDefence = true;
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
		return strategy.getHp();
	}

	public void setHand(Hand hand) {
		this.hand = hand;
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
		return strategy.getMaisuu();
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
	 * 相手からのダメージのセッター
	 * @param pain 痛み
	 */
	public void setPain(int pain) {
		this.pain = pain;
	}

	/**
	 * 痛みを返す
	 * @return 相手の攻撃力
	 */
	public int getPain() {
		return pain;
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
}
