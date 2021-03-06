/**
 * プレーヤーの内部情報保持クラス
 */
public class Player {
	private boolean isDefence;
	private Hand hand;
	private int pain;
	private Strategy strategy;
	private String playerName;

	/**
	 *
	 * @param hp，体力
	 * @param handMaisu，手札数
	 * @param isDefence，前回相手プレイヤーが防御行動をとったか否か，初期はtrue
	 *
	 */

	public Player(String strategyName, String playerName) {
		hand = new Hand();
		this.playerName = playerName;
		this.strategy = setStrategy(strategyName);
		this.isDefence = true;
	}
	
	public String getPlayerName() {
		return playerName;
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
		} else if (strategyName.equals(Strategy.STRATEGY.GANDOUSTRATEGY.name())) {
			return new GandouStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.PLAYERSTRATEGY.name())) {
			return new PlayerStrategy();
		}
		return null;
	}

	/**
	 * hpのセッター
	 * HPがマイナスになると0に変更します
	 */
	public void setHP(int hp) {
		int newHP = hp;
		if (newHP<0) {
			newHP = 0;
		}
		strategy.setHp(newHP);
	}

	/**
	 * hpのゲッター
	 * @return 現在の体力
	 *
	 */
	public int getHP() {
		return strategy.getHp();
	}

	/**
	 * 手札のセッター
	 * @param hand
	 */
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
		//		return strategy.getMaisuu();
		return hand.getHands().size();
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

	/**
	 * ストラテジーのゲッター
	 * @return 戦略
	 */
	public Strategy getStrategy() {
		return strategy;
	}
}
