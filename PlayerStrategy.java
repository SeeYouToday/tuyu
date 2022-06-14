
public class PlayerStrategy extends Strategy {

	public PlayerStrategy() {
		hp = 20;
		maisuu = 3;
	}

	@Override
	public int decideAttack(Player player) {
		boolean existAttack = false;
		for(Card card: player.getHand().getHands()){
			if(card.getKind() == Card.KIND.ATTACK){
				existAttack = true;
				break;
			}
		}
		if(existAttack){
			return 0;//ここの0のところにゲーム内で選択したカードの手札での位置番号を入れたいんや
		}else{
			player.getHand().add(Deck.getInstance().draw());
			return -1;
		}
	}

	@Override
	public int decideDefence(Player player) {
		boolean existDefence = false;
		for(Card card: player.getHand().getHands()){
			if(card.getKind() == Card.KIND.DEFENCE){
				existDefence = true;
				break;
			}
		}
		if(existDefence){
			return 0;//ここの0のところにゲーム内で選択したカードの手札での位置番号を入れたいんや
		}else{
			player.getHand().add(Deck.getInstance().draw());
			return -1;
		}
	}

}
