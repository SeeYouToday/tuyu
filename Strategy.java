/**
 * 戦略のあれ
 * Enumのあるよ！！！
 */
public abstract class Strategy {
	protected int hp;
	protected int maisuu;

	public enum STRATEGY {
		PLAYERSTRATEGY("プレイヤー"), BOYSTRATEGY("男の子"), GIRLSTRATEGY("女の子"), GANDOUSTRATEGY("がんどう");

		private final String strategyName;

		public static STRATEGY[] getStrategy() {
			return STRATEGY.values();
		}

		STRATEGY(String strategyName){
			this.strategyName = strategyName;
		}

		public String toString(){
			return strategyName;
		}
	}

	/**
	 * ストラテジーのセッター
	 * @param strategy
	 * @return 引数に応じたストラテジークラス
	 */
	public Strategy setStrategy(STRATEGY strategy) {
		if (strategy == STRATEGY.BOYSTRATEGY) {
			return new BoyStrategy();
		} else if (strategy == STRATEGY.GIRLSTRATEGY) {
			return new GirlStrategy();
		} else if (strategy == STRATEGY.PLAYERSTRATEGY) {
			return new PlayerStrategy();
		}
		return null;
	}

	/**
	 * hpのゲッター
	 * @return 現在の体力
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * hpのセッター
	 * @param 現在の体力
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * maisuuのゲッター
	 * @return 手札の枚数
	 */
	public int getMaisuu() {
		return maisuu;
	}

	/**
	 * handのセッター
	 * @param 手札の枚数
	 */
	public void setMaisu(int maisuu) {
		this.maisuu = maisuu;
	}

	/**
	 * 攻撃判定メソ
	 * @return 攻撃カード
	 */
	public abstract int decideAttack(Player player);

	/**
	 * 防御判定メソ
	 * @return 防御カード
	 */
	public abstract int decideDefence(Player player);

}
