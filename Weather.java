

public abstract class Weather {

	public enum WEATHER{
		//晴れ：パラメータ1.0倍
		SUNNY(1.0){
			public String toString() {
				return "晴れ";
			}
			
			@Override
			public String getDescription() {
				return "わりと普通の天気";
			}
		},
		//曇り：パラメータ0.5倍
		CLOUDY(0.5){
			public String toString() {
				return "曇り";
			}
			
			@Override
			public String getDescription() {
				return "ちょっと調子わるいかも...";
			}
		},
		//梅雨：パラメータ1/2で0.5倍,1/2で2倍(表示上0)
		TUYU(0){
			public String toString() {
				return "梅雨";
			}
			
			@Override
			public String getDescription() {
				return "なにがおこるかわかんねぇ...";
			}
		},
		//快晴：パラメータ2倍
		CLEAR(2.0){
			public String toString() {
				return "快晴";
			}
			
			@Override
			public String getDescription() {
				return "絶好調！！ナイスですね〜！";
			}
		};
		
		//倍パラメータ
		private double parameter;
		/**
		 * 天気コンストラクタ
		 * @param 何倍
		 */
		private  WEATHER(double parameter) {
			this.parameter = parameter;
		}
		
		/**
		 * パラメータゲッター
		 * @return 何倍パラメータ
		 */
		public double getParameter () {
			return this.parameter;
		}
		
		/**
		 * 説明文
		 * @return 説明文
		 */
		public abstract String getDescription();
		
		/**
		 * 天気一覧を返す
		 * @return 天気配列リスト
		 */
		public static WEATHER[] getStrategy() {
			return WEATHER.values();
		}
	}
	
	/**
	 * 天気をランダムで返す
	 * @return 天気
	 */
	public static WEATHER getRandomWeather() {
		int i = (int)Math.floor(Math.random() * WEATHER.getStrategy().length);
		return WEATHER.getStrategy()[i];
	}
	

	/**
	 * パラーメータ計算
	 * 与えられた値を天気によって買える
	 * @param parameter
	 * @return 適用されたパラメータ
	 */
	public static int calculate(WEATHER weather,int parameter) {
		double effecter = weather.getParameter();
		//梅雨のときは倍になったり半分になったり
		if(weather== WEATHER.TUYU) {
			effecter = Math.random()>=0.5 ? 2.0 :0.5;
		}
		return (int) Math.floor(effecter * parameter);

	}

}
