/**
 * ゲームのカード、HPを扱う
 * @author 北川奨真
 */
public class TuyuAction {
	/*
	 * attackCard: 攻撃カードのインスタンス
	 * defenceCard: 防御カードのインスタンス
//	 * tuyu: 移譲するためのインスタンス
	 */
	private Card attackCard, defenceCard;
	private Tuyu tuyu;
	
	/**
	 * コンストラクタ
	 * @param attackCard 攻撃カード
	 * @param defenceCard 防御カード
	 * @param tuyu 移譲するためのインスタンス
	 */
	public TuyuAction(Card attackCard, Card defenceCard, Tuyu tuyu) {
		this.attackCard = attackCard;
		this.defenceCard = defenceCard;
		this.tuyu = tuyu;
	}
	
	/**
	 * 攻撃カードの攻撃力を返す
	 * @return 攻撃力
	 */
	public int getAttackCardPower() {
		return attackCard.getNum();
	}
	
	/**
	 * 防御カードの防御力を返す
	 * @return 防御力
	 */
	public int getDefenceCardPower() {
		return defenceCard.getNum();
	}
	
	/**
	 *  攻撃カードの名前を返す
	 * @return カード名
	 */
	public String getAttackCardName() {
		return attackCard.getName();
	}
	
	/**
	 * 防御カードの名前を返す
	 * @return カード名
	 */
	public String getDefenceCardName() {
		return defenceCard.getName();
	}
	
	/**
	 * 攻撃カードとして選択されたカードの種類を返す
	 * @return カード種類
	 */
	public Card.KIND getAttackCardKind() {
		return attackCard.getKind();
	}
	
	/**
	 * 防御カードとして選択されたカードの種類を返す
	 * @return カード種類
	 */
	public Card.KIND getDefenceCardKind() {
		return defenceCard.getKind();
	}
	
	/**
	 * メインの処理
	 * @param DefencePlayerNum 防御側のプレイヤ番号
	 */
    public void action(int DefencePlayerNum) {
        actionHP(DefencePlayerNum);
    }
    
    /**
     * メインの処理(HP処理)
     * @param DefencePlayerNum 防御側のプレイヤ番号
     */
    private void actionHP(int DefencePlayerNum) {
    	int hp = tuyu.getPlayer(DefencePlayerNum).getHP();
    	int newHp;
    	//どちらも該当するカードがない場合
    	if (getAttackCardKind()==Card.KIND.TOKEN&&getDefenceCardKind()==Card.KIND.TOKEN){
    		System.out.println("どちらもカードなし");
    		tuyu.getPlayer(0).getHand().add(Deck.getInstance().draw());
    		tuyu.getPlayer(1).getHand().add(Deck.getInstance().draw());
			return;
		}
    	//攻撃側に該当するカードがない場合
    	if (getAttackCardKind()==Card.KIND.TOKEN) {
    		System.out.println("攻撃側カードなし");
    		tuyu.getPlayer(DefencePlayerNum==1?0:1).getHand().add(Deck.getInstance().draw());
    		return;
		}
    	//防御力のほうが高かった場合
    	if ((getAttackCardPower()<=getDefenceCardPower())) {
    		System.out.println("ガード成功");
    		tuyu.getPlayer(0).getHand().add(Deck.getInstance().draw());
    		tuyu.getPlayer(1).getHand().add(Deck.getInstance().draw());
			return;
		}else {
			newHp = hp-(getAttackCardPower()-getDefenceCardPower());    
			tuyu.getPlayer(DefencePlayerNum).setHP(newHp);
			System.out.print("player" + String.valueOf(DefencePlayerNum)+"に");
			System.out.println((getAttackCardPower()-getDefenceCardPower()) + "ダメージ！");
			tuyu.getPlayer(0).getHand().add(Deck.getInstance().draw());
    		tuyu.getPlayer(1).getHand().add(Deck.getInstance().draw());
		}
    	
    }
}
