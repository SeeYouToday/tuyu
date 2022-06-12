import java.util.ArrayList;

/**
 * このゲームのメインとなるクラス
 */
public class Tuyu {
	private ArrayList<Player> player;

    public Tuyu(){
        player = new ArrayList<>();
    }

    public void AddPlayer(Strategy strategy){
        player.add(new Player(strategy));
    }

    public static void main(String[] args) {
        
    }
    
}
