public class DeckTest {
    Deck deck = Deck.getInstance();

    private void printDeck(){
        for(Card card: deck.getDeck()){
            System.out.println(card.getName() + "," + card.getKind() + "," +  card.getNum());
        }
    }
    public static void main(String[] args){
        DeckTest deckTest = new DeckTest();
        deckTest.printDeck();
    }
    
}
