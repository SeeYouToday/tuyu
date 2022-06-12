public class BoyStrategy implements Strategy{
    private Player boy;
    public BoyStrategy(){
        boy = new Player(40, 3);
    }
    public int decideAttack(){
        int ret = 999;
        Card max = null;
        Card min = null;
        Card tmp;
        boolean flag = false;
        for(int i = 0; i < boy.getHandMaisu(); i++){
            if(boy.getHand().check(i).getKind().equals(Card.KIND.ATTACK)){
                max = boy.getHand().check(i);
                min = max;
                flag = true;
                break;
            }
        }
        if(flag){
            if(boy.getHandMaisu() < 3){
                for(int i = 1; i < boy.getHandMaisu(); i++){
                    tmp = boy.getHand().check(i);
                    if(max.getNum() < tmp.getNum()){
                        max = tmp;
                        ret = i;
                    }
                }
            }
            else{
                for(int i = 0; i < boy.getHandMaisu(); i++){
                    tmp = boy.getHand().check(i);
                    if(min.getNum() > tmp.getNum()){
                        min = tmp;
                        ret = i;
                    }
                }
            }
        }

        if(ret == 999){
            boy.getHand().add(boy.getDeck().draw());
        }
        return ret;
    }
    public int decideDefence(){
        int ret = 999;
        Card max = null;
        Card min = null;
        Card tmp;
        boolean flag = false;
        boolean flag2 = false;
        for(int i = 0; i < boy.getHandMaisu(); i++){
            if(boy.getHand().check(i).getKind().equals(Card.KIND.DEFENCE)){
                max = boy.getHand().check(i);
                min = max;
                flag = true;
                break;
            }
        }
        if(flag){
            if(boy.getHP() > 10){
                for(int i = 1; i < boy.getHandMaisu(); i++){
                    tmp = boy.getHand().check(i);
                    if(max.getNum() < tmp.getNum() && boy.getPain() >= tmp.getNum()){
                        max = tmp;
                        ret = i;
                        flag2 = true;
                    }
                }
                if(!flag2){
                    for(int i = 0; i < boy.getHandMaisu(); i++){
                        tmp = boy.getHand().check(i);
                        if(min.getNum() > tmp.getNum() && boy.getPain() <= tmp.getNum()){
                            min = tmp;
                            ret = i;
                        }
                    }
                }
            }
            else{
                for(int i = 0; i < boy.getHandMaisu(); i++){
                    tmp = boy.getHand().check(i);
                    if(min.getNum() > tmp.getNum() && boy.getPain() <= tmp.getNum()){
                        min = tmp;
                        ret = i;
                        flag2 = true;
                    }
                }
                if(!flag2){
                    for(int i = 1; i < boy.getHandMaisu(); i++){
                        tmp = boy.getHand().check(i);
                        if(max.getNum() < tmp.getNum() && boy.getPain() >= tmp.getNum()){
                            max = tmp;
                            ret = i;
                            flag2 = true;
                        }
                    }
                }
            }
        }

        if(ret == 999){
            boy.getHand().add(boy.getDeck().draw());
        }
        return ret;
    }
}
