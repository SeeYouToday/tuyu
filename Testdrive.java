public class Testdrive {

	public static void main(String[] args) {
		Player 男 = new Player(Strategy.STRATEGY.BOYSTRATEGY.name());
		Player 女 = new Player(Strategy.STRATEGY.GIRLSTRATEGY.name());
		System.out.println(男.getHP());
		System.out.println(女.getHP());

	}

}
