import java.util.ArrayList;
import java.util.Random;

/**
 * デッキを表すクラス
 */
public class Deck {

	private static Deck deck = new Deck();
	protected ArrayList<Card> decks = new ArrayList<>();
	Random rand = new Random();

	private Deck() {
		for (int i = 0; i < 15; i++) {
			decks.add(new Card(1, Card.KIND.DEFENCE, "がんどう"));
			decks.add(new Card(6, Card.KIND.ATTACK, "たこ"));
			decks.add(new Card(2, Card.KIND.ATTACK, "ちくりんてぉ"));
			decks.add(new Card(8, Card.KIND.ATTACK, "カエルくん"));
			decks.add(new Card(9, Card.KIND.DEFENCE, "かたつんむり"));
			decks.add(new Card(7, Card.KIND.DEFENCE, "めんつゆ"));
			decks.add(new Card(3, Card.KIND.ATTACK, "かめくん"));
			decks.add(new Card(4, Card.KIND.ATTACK, "ぼくにんじん"));
			decks.add(new Card(10, Card.KIND.ATTACK, "梅雨前線ソード"));
			decks.add(new Card(5, Card.KIND.ATTACK, "おおあばれちゃん"));
		}
		shuffle();
	}

	public static Deck getInstance() {
		return deck;
	}

	/**
	 * デッキの内容をシャッフルするよ
	 * よーくシャッフルするよ
	 */
	public void shuffle() {
		for (int i = 0; i < decks.size(); i++) {
			int shu = rand.nextInt(decks.size());
			decks.add(decks.remove(shu));
		}
		for (int i = 0; i < decks.size(); i++) {
			int shu = rand.nextInt(decks.size());
			decks.add(decks.remove(shu));
		}
	}

	/**
	 * デッキのトップから一枚ひくyo
	 * もしデッキが0になったら終わりを表すエンドカードを返す
	 * @return デッキトップのカード
	 */
	public Card draw() {
		if (zeroCheck()) {

			return new Card(0, Card.KIND.END, "end");
		}
		return decks.remove(0);
	}

	/**
	 * デッキのゲッター
	 * @return デッキ
	 */
	public ArrayList<Card> getDeck() {
		return decks;
	}

	/**
	 * デッキがまだあるかチェック
	 * @return デッキがまだあるかの真偽値
	 */
	private boolean zeroCheck() {
		boolean result = false;
		if (getInstance().decks.size() <= 0) {
			result = true;
		}
		return result;
	}
}
