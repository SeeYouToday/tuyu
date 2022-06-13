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
        
        tuyu.actions();
        switch (tuyu.getPlayer(0).getHand().use(0).getKind()) {
		case WIN:
			System.out.println("player0の勝利");
			break;
		case LOSE:
			System.out.println("player1の勝利");
			break;
		case PEACE:
			System.out.println("引き分け！！平和！");
			break;
		}
	}

	private static void printCard(Tuyu tuyu, int playerNum, int cardNum) {
		System.out.print("名前: " + tuyu.getCardName(playerNum, cardNum) + ", 攻撃力: " + tuyu.getCardPower(playerNum, cardNum) + ", 種類: " + tuyu.getCardKind(playerNum, cardNum)+"\n");
	}
	
}
