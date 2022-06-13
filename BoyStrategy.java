public class BoyStrategy extends Strategy {

	public BoyStrategy() {
		hp = 40;
		maisuu = 3;
	}

	/**
	 * 攻撃カードの選択をする
	 * ただし選択してreturnするのはCardクラスのオブジェクトじゃなくカードが手札の何番目にあるかを返す
	 *
	 * 選択基準は自身の手札枚数
	 * 最大火力を出すか最小火力を出すの二択
	 * @return 使用カードが手札の何番目にあるか
	 */
	public int decideAttack(Player boy) {
		int ret = -1;
		Card max = null;
		Card min = null;
		Card tmp;
		boolean flag = false;
		for (int i = 0; i < boy.getHandMaisu(); i++) {
			if (boy.getHand().check(i).getKind().equals(Card.KIND.ATTACK)) {
				max = boy.getHand().check(i);
				min = max;
				flag = true;
				break;
			}
		}
		if (flag) {
			if (boy.getHandMaisu() < 4) {
				for (int i = 1; i < boy.getHandMaisu(); i++) {
					tmp = boy.getHand().check(i);
					if (max.getNum() < tmp.getNum()) {
						max = tmp;
						ret = i;
					}
				}
			} else {
				for (int i = 0; i < boy.getHandMaisu(); i++) {
					tmp = boy.getHand().check(i);
					if (min.getNum() > tmp.getNum()) {
						min = tmp;
						ret = i;
					}
				}
			}
		}

		if (ret == -1) {
			boy.getHand().add(Deck.getInstance().draw());
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
	public int decideDefence(Player boy) {
		int ret = -1;
		Card max = null;
		Card min = null;
		Card tmp;
		boolean flag = false;
		boolean flag2 = false;
		for (int i = 0; i < boy.getHandMaisu(); i++) {
			if (boy.getHand().check(i).getKind().equals(Card.KIND.DEFENCE)) {
				max = boy.getHand().check(i);
				min = max;
				flag = true;
				break;
			}
		}
		if (flag) {
			if (boy.getHP() > 10) {
				for (int i = 1; i < boy.getHandMaisu(); i++) {
					tmp = boy.getHand().check(i);
					if (max.getNum() < tmp.getNum() && boy.getPain() >= tmp.getNum()) {
						max = tmp;
						ret = i;
						flag2 = true;
					}
				}
				if (!flag2) {
					for (int i = 0; i < boy.getHandMaisu(); i++) {
						tmp = boy.getHand().check(i);
						if (min.getNum() > tmp.getNum() && boy.getPain() <= tmp.getNum()) {
							min = tmp;
							ret = i;
						}
					}
				}
			} else {
				for (int i = 0; i < boy.getHandMaisu(); i++) {
					tmp = boy.getHand().check(i);
					if (min.getNum() > tmp.getNum() && boy.getPain() <= tmp.getNum()) {
						min = tmp;
						ret = i;
						flag2 = true;
					}
				}
				if (!flag2) {
					for (int i = 1; i < boy.getHandMaisu(); i++) {
						tmp = boy.getHand().check(i);
						if (max.getNum() < tmp.getNum() && boy.getPain() >= tmp.getNum()) {
							max = tmp;
							ret = i;
							flag2 = true;
						}
					}
				}
			}
		}

		if (ret == -1) {
			boy.getHand().add(Deck.getInstance().draw());
		}
		return ret;
	}
}
