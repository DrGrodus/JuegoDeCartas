package juegodecartas;
import java.util.*;
/**
 *
 * @author Eber MD
 */ 

public class JuegoDeCartas {
    public static void main(String[] args) {
        String[] color = {"rojo", "negro"};
        String[] palo = {"Trebol", "Diamante", "Pica", "Corazon"};
        String[] valor = {"2", "3", "4", "5", "6", "7", "8", "9", "10","A", "J", "Q", "K"};
        Integer cont = 1;
        Deck deck = new Deck();
        deck.setCard(new ArrayList<Card>());
        for(int i = 0; i < palo.length; i++){
            for(int j = 0; j < valor.length; j++){
                Card card = new Card(palo[i], getColor(palo[i]), valor[j]); 
                deck.getCard().add(card);
                //System.out.println(cont+"-Palo: "+palo[i]+" "+ "valor: "+ valor[j]+" color: "+getColor(palo[i]));
                cont++;
            }
        }
        System.out.println("el tamanho del deck es: " + deck.getCard().size()+"\n");
        System.out.println("Mezclar Deck\n" + deck.shuffle() +"\n");
        System.out.println(deck.head(deck.nCards())+"\n");
        System.out.println(deck.pick(deck.nCards())+"\n");
        System.out.println(deck.hand(deck.nCards()));
    }
    public static String getColor(String palo){
        if(palo.toLowerCase().equals("pica") || palo.toLowerCase().equals("trebol")){
            return "negro";
        }
        if(palo.toLowerCase().equals("corazon") || palo.toLowerCase().equals("diamante") ){
            return "rojo"; 
        }
        return null;
    }
}
