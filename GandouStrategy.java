import java.util.Random;

public class GandouStrategy extends Strategy {
    Random random = new Random();
    public GandouStrategy() {
		hp = 80;
		maisuu = 5;
	}

    @Override
    public int decideAttack(Player gandou){
        boolean flag = false;
        for(Card card: gandou.getHand().getHands()){
            if(card.getKind() == Card.KIND.ATTACK){
                flag = true;
            }
        }
        if(flag){
            int ret = random.nextInt(gandou.getHand().getHands().size());
            while(gandou.getHand().getHands().get(ret).getKind() != Card.KIND.ATTACK){
                ret = random.nextInt(gandou.getHand().getHands().size());
            }
            return ret;
        }
        else{
            return -1;
        }
    }

    @Override
    public int decideDefence(Player gandou){
        boolean flag = false;
        for(Card card: gandou.getHand().getHands()){
            if(card.getKind() == Card.KIND.DEFENCE){
                flag = true;
            }
        }
        if(flag){
            int ret = random.nextInt(gandou.getHand().getHands().size());
            while(gandou.getHand().getHands().get(ret).getKind() != Card.KIND.DEFENCE){
                ret = random.nextInt(gandou.getHand().getHands().size());
            }
            return ret;
        }
        else{
            return -1;
        }
    }
}
