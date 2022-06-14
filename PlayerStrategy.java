/**
 * プレイヤーのクラスだお
 */
public class PlayerStrategy extends Strategy {

	public PlayerStrategy() {
		hp = 20;
		maisuu = 3;
	}

	/**
	 * 手札を一周見て攻撃カードがなかったら-1を返すやでぇ
	 * 攻撃カードがあれば選択したカードが手札の何番目にあるかを返す構造になる予定や
	 */
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

	/**
	 * 手札を一周見て防御カードがなかったら-1を返すやでぇ
	 * 防御カードがあれば選択したカードが手札の何番目にあるかを返す構造になる予定や
	 */
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
