public class Testdrive {

	public static void main(String[] args) {
		Player 男 = new Player(Strategy.STRATEGY.BOYSTRATEGY.name());
		Player 女 = new Player(Strategy.STRATEGY.GIRLSTRATEGY.name());
		System.out.println(男.getHP());
		System.out.println(女.getHP());
		
		Weather.WEATHER weather = Weather.getRandomWeather();
		System.out.println("天気: "+weather.toString()+"を生成");
		System.out.println(weather.getDescription());
		int damage = 300;
		System.out.println("攻撃力は"+damage);
		int changed = Weather.calculate(weather, damage);
		System.out.println("この天気での攻撃力は"+changed);
		

	}

}
