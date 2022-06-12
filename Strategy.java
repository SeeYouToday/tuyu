/**
 * 戦略のあれ
 * Enumのあるよ！！！
 */
public abstract class Strategy {
	protected int hp;
	protected int maisuu;

	public enum STRATEGY {
		PLAYERSTRATEGY, BOYSTRATEGY, GIRLSTRATEGY, GANDOUSTRATEGY;

		public static STRATEGY[] getStrategy() {
			return STRATEGY.values();
		}
	}

	public Strategy setStrategy(STRATEGY strategy) {
		if (strategy == STRATEGY.BOYSTRATEGY) {
			return new BoyStrategy();
		} else if (strategy == STRATEGY.GIRLSTRATEGY) {
			return new GirlStrategy();
		}
		return null;
	}

	/**
	 * hpのゲッター
	 * @return 現在の体力
	 */
	public int getterHp() {
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
	public int getterMaisuu() {
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
