/**
 * CUIでのテストクラス
 * @author kitagawashoma
 */
public class CUITest {
	public void mainAction() {
		Tuyu tuyu = new Tuyu();
        tuyu.addPlayer("BOYSTRATEGY", "としや");
        tuyu.addPlayer("GIRLSTRATEGY", "くるみ");
        tuyu.makePlayerHand();
        
        tuyu.actions();
        Player player = tuyu.getWinPlayer();
        if (player!=null) {
			System.out.println("勝者: "+player.getPlayerName());
		}else {
			System.out.println("引き分け");
		}
        
	}
	public static void main(String[] args) {
		for (int i = 0; i < １; i++) {
			CUITest cuiTest = new CUITest();
			cuiTest.mainAction();
		}
		
	}

	private static void printCard(Tuyu tuyu, int playerNum, int cardNum) {
		System.out.print("名前: " + tuyu.getCardName(playerNum, cardNum) + ", 攻撃力: " + tuyu.getCardPower(playerNum, cardNum) + ", 種類: " + tuyu.getCardKind(playerNum, cardNum)+"\n");
	}
	
}
