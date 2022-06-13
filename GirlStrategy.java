public class GirlStrategy extends Strategy {
	private Player girl;

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
	public int decideAttack() {
		int ret = 999;
		Card max = null;
		Card min = null;
		Card tmp;
		boolean flag = false;
		for (int i = 0; i < girl.getHandMaisu(); i++) {
			if (girl.getHand().check(i).getKind().equals(Card.KIND.ATTACK)) {
				max = girl.getHand().check(i);
				min = max;
				flag = true;
				break;
			}
		}
		if (flag) {
			if (girl.getIsDefence()) {
				for (int i = 1; i < girl.getHandMaisu(); i++) {
					tmp = girl.getHand().check(i);
					if (max.getNum() < tmp.getNum()) {
						max = tmp;
						ret = i;
					}
				}
			}
		} else {
			for (int i = 0; i < girl.getHandMaisu(); i++) {
				tmp = girl.getHand().check(i);
				if (min.getNum() > tmp.getNum()) {
					min = tmp;
					ret = i;
				}
			}
		}
		if (ret == 999) {
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
	public int decideDefence() {
		int ret = 999;
		Card max = null;
		Card min = null;
		Card tmp;
		boolean flag = false;
		boolean flag2 = false;
		for (int i = 0; i < girl.getHandMaisu(); i++) {
			if (girl.getHand().check(i).getKind().equals(Card.KIND.DEFENCE)) {
				max = girl.getHand().check(i);
				min = max;
				flag = true;
				break;
			}
		}
		if (flag) {
			if (girl.getHP() > 10) {
				for (int i = 1; i < girl.getHandMaisu(); i++) {
					tmp = girl.getHand().check(i);
					if (max.getNum() < tmp.getNum() && girl.getPain() >= tmp.getNum()) {
						max = tmp;
						ret = i;
						flag2 = true;
					}
				}
				if (!flag2) {
					for (int i = 0; i < girl.getHandMaisu(); i++) {
						tmp = girl.getHand().check(i);
						if (min.getNum() > tmp.getNum() && girl.getPain() <= tmp.getNum()) {
							min = tmp;
							ret = i;
						}
					}
				}
			} else {
				for (int i = 0; i < girl.getHandMaisu(); i++) {
					tmp = girl.getHand().check(i);
					if (min.getNum() > tmp.getNum() && girl.getPain() <= tmp.getNum()) {
						min = tmp;
						ret = i;
						flag2 = true;
					}
				}
				if (!flag2) {
					for (int i = 1; i < girl.getHandMaisu(); i++) {
						tmp = girl.getHand().check(i);
						if (max.getNum() < tmp.getNum() && girl.getPain() >= tmp.getNum()) {
							max = tmp;
							ret = i;
							flag2 = true;
						}
					}
				}
			}
		}
		if (ret == 999) {
			girl.getHand().add(Deck.getInstance().draw());
		}
		return ret;
	}

	@Override
	public int decideAttack(Player player) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int decideDefence(Player player) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
}
