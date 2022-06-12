import java.util.ArrayList;

/**
 * このゲームのメインとなるクラス
 */
public class Tuyu {
	private ArrayList<Player> player;

    public Tuyu(){
        player = new ArrayList<>();
    }

    public void addPlayer(String strategy){
        player.add(new Player(strategy));
    }


}
