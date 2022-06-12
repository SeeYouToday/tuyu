/**
 * カードを表すクラス
 * Enumもあるよ！！！
 */
public class Card{

    private int num;
    KIND kind;

    public enum KIND{
        ATTACK, DEFENCE, HEAL;
        public static KIND[] getKind(){
            return KIND.values();
        } 
    }

    public Card(int num, KIND kind){
        this.num = num;
        this.kind = kind;
    }
    /**
     * カードの（攻撃力，防御力などの）値を表すnumを返す
     * @return カードの数値
     * 
     */
    public int getNum(){
        return num;
    }

    /**
     * カードの種類（攻撃カードなのか防御カードなのか）
     * @return カードの種類
     */
    public KIND getKind(){
        return kind;
    }
}