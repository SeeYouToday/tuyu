public interface Strategy {
    public enum STRATEGY{
        BOYSTRATEGY, GIRLSTRATEGY, GANDOUSTRATEGY;

        public static STRATEGY[] getStrategy(){
            return STRATEGY.values();
        }
    }
    public int decideAttack();
    public int decideDefence();
}
