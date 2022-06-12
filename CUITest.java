
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
		System.out.println(tuyu.getCardName(playerNum, cardNum));
	}
}
