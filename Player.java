public class Player {
    private int hp;
    private int handMaisu;
    private boolean isDefence;
    private Hand hand;
    private Deck deck;
    private int pain;

    /**
     * 
     * @param hp，体力
     * @param handMaisu，手札数
     * @param isDefence，前回相手プレイヤーが防御行動をとったか否か，初期はtrue
     * 
     */

    public Player(int hp, int handMaisu){
        this.hp = hp;
        this.handMaisu = handMaisu;
        this.isDefence = true;
        for(int i = 0; i < handMaisu; i++){
            hand.add(deck.drow());
        }
    }

    /**
     * hpのセッター
     * @param hp
     */
    public void setHP(int hp){
        this.hp = hp;
    }

    /**
     * hpのゲッター
     * @return 現在の体力
     * 
     */
    public int getHP(){
        return hp;
    }

    /**
     * handのセッター
     * @param handMaisu
     */
    public void setHandMaisu(int handMaisu){
        this.handMaisu = handMaisu;
    }

    /**
     * handのゲッター
     * @return 現在の手札枚数
     */
    public int getHandMaisu(){
        return handMaisu;
    }

    /**
     * isDefenceのセッター
     * @param isDefence
     */
    public void setIsDefence(boolean isDefence){
        this.isDefence = isDefence;
    }

    /**
     * isDefenceのゲッター
     * @return 前回の防御行動の有無
     */
    public boolean getIsDefence(){
        return isDefence;
    }

    public Hand getHand(){
        return hand;
    }

    public Deck getDeck(){
        return deck;
    }

    public void setPain(int pain){
        this.pain = pain;
    }

    public int getPain(){
        return pain;
    }
}
