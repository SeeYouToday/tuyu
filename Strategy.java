/**
 * 戦略のあれ
 * Enumのあるよ！！！
 */
public interface Strategy {
    public enum STRATEGY{
        BOYSTRATEGY, GIRLSTRATEGY, GANDOUSTRATEGY;

        public static STRATEGY[] getStrategy(){
            return STRATEGY.values();
        }
    }
    /**
     * 攻撃判定メソ
     * @return 攻撃カード
     */
    public int decideAttack();
    /**
     * 防御判定メソ
     * @return 防御カード
     */
    public int decideDefence();
}
