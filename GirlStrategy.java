/**
 * ストラテジーの具象クラス
 * 女の子を表し，初期体力は30，初期手札は4
 */
public class GirlStrategy extends Strategy {

	public GirlStrategy() {
		hp = 30;
		maisuu = 4;
	}

	/**
	 * 攻撃カードの選択をする
	 * ただし選択してreturnするのはCardクラスのオブジェクトじゃなくカードが手札の何番目にあるかを返す
	 *
	 * 選択基準は相手が前回防御カードを使用したか否か
	 * @return 使用カードが手札の何番目にあるか
	 */
	public int decideAttack(Player girl) {
		int ret = -1;
		Card max = null;
		Card min = null;
		Card tmp;
		boolean flag = false;
		for (int i = 0; i < girl.getHandMaisu(); i++) {
			if (girl.getHand().check(i).getKind() == Card.KIND.ATTACK) {
				max = girl.getHand().check(i);
				min = max;
				flag = true;
				ret = i;
				break;
			}
		}
		if (flag) {
			if (girl.getIsDefence()) {
				for (int i = 1; i < girl.getHandMaisu(); i++) {
					tmp = girl.getHand().check(i);
					if (max.getNum() < tmp.getNum() && tmp.getKind() == Card.KIND.ATTACK) {
						max = tmp;
						ret = i;
					}
				}
			} else {
			for (int i = 0; i < girl.getHandMaisu(); i++) {
				tmp = girl.getHand().check(i);
				if (min.getNum() > tmp.getNum() && tmp.getKind() == Card.KIND.ATTACK) {
					min = tmp;
					ret = i;
				}
			}
			}
		}
		if (ret == -1) {
			girl.getHand().add(Deck.getInstance().draw());
		}
		return ret;
	}

	/**
	 * 防御カードを選択する
	 * 攻撃と同様手札の何番目にあるかを返す
	 *
	 * 選択基準は自身の体力
	 * 今回相手が選択した攻撃カードの攻撃力より小さい最大防御力または攻撃力より大きい最小防御力
	 * @return 使用カードが手札の何番目にあるか
	 */
	public int decideDefence(Player girl) {
		int ret = -1;
		Card max = null;
		Card min = null;
		Card tmp;
		boolean flag = false;
		boolean flag2 = false;
		for (int i = 0; i < girl.getHandMaisu(); i++) {
			if (girl.getHand().check(i).getKind() == Card.KIND.DEFENCE) {
				max = girl.getHand().check(i);
				min = max;
				flag = true;
				ret = i;
				break;
			}
		}
		if (flag) {
			if (girl.getHP() > 10) {
				for (int i = 1; i < girl.getHandMaisu(); i++) {
					tmp = girl.getHand().check(i);
					if (max.getNum() < tmp.getNum() && girl.getPain() >= tmp.getNum() && tmp.getKind() == Card.KIND.DEFENCE) {
						max = tmp;
						ret = i;
						flag2 = true;
					}
				}
				if (!flag2) {
					for (int i = 0; i < girl.getHandMaisu(); i++) {
						tmp = girl.getHand().check(i);
						if (min.getNum() > tmp.getNum() && girl.getPain() <= tmp.getNum() && tmp.getKind() == Card.KIND.DEFENCE) {
							min = tmp;
							ret = i;
						}
					}
				}
			} else {
				for (int i = 0; i < girl.getHandMaisu(); i++) {
					tmp = girl.getHand().check(i);
					if (min.getNum() > tmp.getNum() && girl.getPain() <= tmp.getNum() && tmp.getKind() == Card.KIND.DEFENCE) {
						min = tmp;
						ret = i;
						flag2 = true;
					}
				}
				if (!flag2) {
					for (int i = 1; i < girl.getHandMaisu(); i++) {
						tmp = girl.getHand().check(i);
						if (max.getNum() < tmp.getNum() && girl.getPain() >= tmp.getNum() && tmp.getKind() == Card.KIND.DEFENCE) {
							max = tmp;
							ret = i;
							flag2 = true;
						}
					}
				}
			}
		}
		if (ret == -1) {
			girl.getHand().add(Deck.getInstance().draw());
		}
		return ret;
	}
}
