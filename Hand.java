import java.util.ArrayList;
/**
 * 手札のクラス
 */
public class Hand {
    protected ArrayList<Card> hands = new ArrayList<>();
    public Hand(){

    }

    /**
     * 手札に一枚カードを追加するお
     * ５枚超えてたら１枚目から消すお
     * @param card: 追加するカード
     */
    public void add(Card card){
        this.hands.add(card);
        if(hands.size() > 5){
            hands.remove(0);
        }
    }

    /**
     * 引数で指定した場所にあるカードを使用するよ
     * と言っても手札から消すだけだから使用処理に関しては任した！
     * @param i
     * @return 指定した手札位置のカード
     */
    public Card use(int i){
        if(i == -1){
            Card token = new Card(0, Card.KIND.TOKEN, "何もできないお！");

            return token;
        }else{
            Card.KIND kind = this.hands.get(i).getKind();
            switch(kind){
                case ATTACK:
                //ここにでも攻撃カードの処理を書いてくれるとスムーズに繋がる予定してる．
                break;
                case DEFENCE:
                //ここの防御のカードの処理を書くとうまくいく．保証はしない．
                break;
                case HEAL:
                //吾輩はヒールである．実装はまだない．
                break;
            }
            return this.hands.remove(i);
        }
        
    }

    /**
     * 引数で指定した手札のカードを参照する
     * 手札枚数に関しては健康しないお
     * @param i
     * @return 指定した手札位置のカード
     */
    public Card check(int i){
        return this.hands.get(i);
    }
}
