
public class TuyuAction {
	private Card attackCard, defenceCard;
	private Tuyu tuyu;
	
	public TuyuAction(Card attackCard, Card defenceCard, Tuyu tuyu) {
		this.attackCard = attackCard;
		this.defenceCard = defenceCard;
		this.tuyu = tuyu;
	}
	
	public int getAttackCardPower() {
		return attackCard.getNum();
	}
	
	public int getDefenceCardPower() {
		return defenceCard.getNum();
	}
	
	public String getAttackCardName() {
		return attackCard.getName();
	}
	
	public String getDefenceCardName() {
		return defenceCard.getName();
	}
	
	public Card.KIND getAttackCardKind() {
		return attackCard.getKind();
	}
	
	public Card.KIND getDefenceCardKind() {
		return defenceCard.getKind();
	}
	
    public void action(int DefencePlayerNum) {
        actionHP(DefencePlayerNum);
    }
    
    private void actionHP(int DefencePlayerNum) {
    	int hp = tuyu.getPlayer(DefencePlayerNum).getHP();
    	int newHp;
    	if ((getAttackCardPower()<=getDefenceCardPower())) {
    		System.out.println("ガード成功");
    		tuyu.getPlayer(0).getHand().add(Deck.getInstance().draw());
    		tuyu.getPlayer(1).getHand().add(Deck.getInstance().draw());
			return;
		}else {
			newHp = hp-(getAttackCardPower()-getDefenceCardPower());    
			tuyu.getPlayer(DefencePlayerNum).setHP(newHp);
			System.out.println((getAttackCardPower()-getDefenceCardPower()) + "ダメージ！");
			tuyu.getPlayer(0).getHand().add(Deck.getInstance().draw());
    		tuyu.getPlayer(1).getHand().add(Deck.getInstance().draw());
		}
    	
    }
}
