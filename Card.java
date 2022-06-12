public class Card{

    private int num;
    KIND kind;

    public enum KIND{
        ATTACK, DEFENCE, HEAL;
        public static KIND[] getKind(){
            return KIND.values();
        } 
    }

    public Card(int num, KIND kind){
        this.num = num;
        this.kind = kind;
    }
    
    public int getNum(){
        return num;
    }

    public KIND getKind(){
        return kind;
    }
}