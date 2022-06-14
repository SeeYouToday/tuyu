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
	int i = 0;
	
	/**
	 * コンストラクタ
	 * @param attackCard 攻撃カード
	 * @param defenceCard 防御カード
	 * @param tuyu 移譲するためのインスタンス
	 */
	public TuyuAction(Tuyu tuyu) {
		this.tuyu = tuyu;
	}
	
	public void setAttackCard(Card attackCard) {
		this.attackCard = attackCard;
	}
	
	public void setDefenceCard(Card defenceCard) {
		this.defenceCard = defenceCard;
	}
	
	/**
	 * 攻撃カードの攻撃力を返す
	 * @return 攻撃力
	 */
	public int getAttackCardPower() {
		int dm = attackCard.getNum();
//		System.out.println("攻撃力"+dm);
		return dm;
	}
	
	/**
	 * 防御カードの防御力を返す
	 * @return 防御力
	 */
	public int getDefenceCardPower() {
		int df = defenceCard.getNum();
//		System.out.println("防御力"+df);
		return df;
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
    
    public void draw() {
    	if (Deck.getInstance().draw().getKind()==Card.KIND.END) {
			tuyu.getPlayer(0).getHand().clearHand();
			tuyu.getPlayer(1).getHand().clearHand();
		}
    	tuyu.getPlayer(0).getHand().add(Deck.getInstance().draw());
    	tuyu.getPlayer(1).getHand().add(Deck.getInstance().draw());
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
    		draw();
			return;
		}
    	//攻撃側に該当するカードがない場合
    	if (getAttackCardKind()==Card.KIND.TOKEN) {
    		System.out.println("攻撃側カードなし");
    		Card card = Deck.getInstance().draw();
    		if (card.getKind() == Card.KIND.END) {
    			tuyu.getPlayer(0).getHand().clearHand();
    			tuyu.getPlayer(1).getHand().clearHand();
			}
    		tuyu.getPlayer(DefencePlayerNum==1?0:1).getHand().add(card);
    		return;
		}
    	//防御力のほうが高かった場合
    	if ((getAttackCardPower()<=getDefenceCardPower())) {
    		System.out.println("ガード成功");
    		draw();
			return;
		}else {
			newHp = hp-(getAttackCardPower()-getDefenceCardPower()); 
			System.out.println((getAttackCardPower()-getDefenceCardPower()) + "ダメージ！");
			tuyu.getPlayer(DefencePlayerNum).setHP(newHp);
			draw();
			System.out.print("player" + String.valueOf(DefencePlayerNum)+"に");
			System.out.println((getAttackCardPower()-getDefenceCardPower()) + "ダメージ！");
			
		}
    	
    	if (tuyu.getPlayer(DefencePlayerNum).getHP()==0 || tuyu.getPlayer(DefencePlayerNum==1?0:1).getHP()==0) {
    		tuyu.getPlayer(0).getHand().clearHand();
			tuyu.getPlayer(1).getHand().clearHand();
			tuyu.getPlayer(0).getHand().add(new Card(0, Card.KIND.END, ""));
			tuyu.getPlayer(1).getHand().add(new Card(0, Card.KIND.END, ""));
		}
    	
    }
}
