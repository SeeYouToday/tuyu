/**
 * カードを表すクラス Enumもあるよ！！！
 */
public class Card {

	private int num;
	KIND kind;
	private String name;

	public enum KIND {
		ATTACK {
			@Override
			public String toString() {
				return "(攻)";
			}
		},
		DEFENCE {
			@Override
			public String toString() {
				return "(防)";
			}
		},
		HEAL {
			@Override
			public String toString() {

				return "(癒)";
			}
		},
		TOKEN, END {
			@Override
			public String toString() {
				return "終了";
			}
		},
		WIN {
			@Override
			public String toString() {
				return "勝利";
			}
		},
		LOSE {
			@Override
			public String toString() {
				return "敗北";
			}
		},
		PEACE {
			@Override
			public String toString() {
				return "引き分け";
			}
		};

		public static KIND[] getKind() {
			return KIND.values();
		}
	}

	public Card(int num, KIND kind, String name) {
		this.num = num;
		this.kind = kind;
		this.name = name;
	}

	/**
	 * カードの（攻撃力，防御力などの）値を表すnumを返す
	 * 
	 * @return カードの数値
	 * 
	 */
	public int getNum() {
		return num;
	}

	/**
	 * カードの種類（攻撃カードなのか防御カードなのか）
	 * 
	 * @return カードの種類
	 */
	public KIND getKind() {
		return kind;
	}

	/**
	 * カードの名前のゲッター
	 * 
	 * @return カード名
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}