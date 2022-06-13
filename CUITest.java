/**
 * CUIでのテストクラス
 * @author kitagawashoma
 */
public class CUITest {
	public static void main(String[] args) {
		Tuyu tuyu = new Tuyu();
        tuyu.addPlayer("BOYSTRATEGY");
        tuyu.addPlayer("GIRLSTRATEGY");
        tuyu.makePlayerHand();

        printCard(tuyu, 0, 0);
        printCard(tuyu, 0, 1);
        printCard(tuyu, 0, 2);
        printCard(tuyu, 1, 0);
        printCard(tuyu, 1, 1);
	}

	private static void printCard(Tuyu tuyu, int playerNum, int cardNum) {
		System.out.print("名前: " + tuyu.getCardName(playerNum, cardNum) + ", 攻撃力: " + tuyu.getCardPower(playerNum, cardNum) + ", 種類: " + tuyu.getCardKind(playerNum, cardNum)+"\n");
	}
}
