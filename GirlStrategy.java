public class GirlStrategy {
    private Player girl;
    public GirlStrategy(){
        girl = new Player(30, 4);
    }

    public int decideAttack(){
        int ret = 999;
        Card max = null;
        Card min = null;
        Card tmp;
        boolean flag = false;
        for(int i = 0; i < girl.getHandMaisu(); i++){
            if(girl.getHand().check(i).getKind().equals(Card.KIND.ATTACK)){
                max = girl.getHand().check(i);
                min = max;
                flag = true;
                break;
            }
        }
        if(flag){
            if(girl.getIsDefence()){
                for(int i = 1; i < girl.getHandMaisu(); i++){
                    tmp = girl.getHand().check(i);
                    if(max.getNum() < tmp.getNum()){
                        max = tmp;
                        ret = i;
                    }
                }
            }
        }
        else{
            for(int i = 0; i < girl.getHandMaisu(); i++){
                tmp = girl.getHand().check(i);
                if(min.getNum() > tmp.getNum()){
                    min = tmp;
                    ret = i;
                }
            }
        }
        if(ret == 999){
            girl.getHand().add(girl.getDeck().draw());
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
        for(int i = 0; i < girl.getHandMaisu(); i++){
            if(girl.getHand().check(i).getKind().equals(Card.KIND.DEFENCE)){
                max = girl.getHand().check(i);
                min = max;
                flag = true;
                break;
            }
        }
        if(flag){
            if(girl.getHP() > 10){
                for(int i = 1; i < girl.getHandMaisu(); i++){
                    tmp = girl.getHand().check(i);
                    if(max.getNum() < tmp.getNum() && girl.getPain() >= tmp.getNum()){
                        max = tmp;
                        ret = i;
                        flag2 = true;
                    }
                }
                if(!flag2){
                    for(int i = 0; i < girl.getHandMaisu(); i++){
                        tmp = girl.getHand().check(i);
                        if(min.getNum() > tmp.getNum() && girl.getPain() <= tmp.getNum()){
                            min = tmp;
                            ret = i;
                        }
                    }
                }
            }
            else{
                for(int i = 0; i < girl.getHandMaisu(); i++){
                    tmp = girl.getHand().check(i);
                    if(min.getNum() > tmp.getNum() && girl.getPain() <= tmp.getNum()){
                        min = tmp;
                        ret = i;
                        flag2 = true;
                    }
                }
                if(!flag2){
                    for(int i = 1; i < girl.getHandMaisu(); i++){
                        tmp = girl.getHand().check(i);
                        if(max.getNum() < tmp.getNum() && girl.getPain() >= tmp.getNum()){
                            max = tmp;
                            ret = i;
                            flag2 = true;
                        }
                    }
                }
            }
        }
        if(ret == 999){
            girl.getHand().add(girl.getDeck().draw());
        }
        return ret;
    }
}
