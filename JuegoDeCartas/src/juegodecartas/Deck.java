package juegodecartas;

import java.util.*;

/**
 *
 * @author Eber MD
 */
public class Deck {
    // clase baraja
        private List<Card> card;
        private Integer numCard = 52;
        

        public List<Card> getCard() {
            return card;
        }

        public void setCard(List<Card> card) {
            this.card = card;
        }
        
        public Integer nCards(){
            return numCard;
        }
        
        public String shuffle(){
            Collections.shuffle(card);
            return "Se mezcló el Deck";
        }
        
        public String head(Integer numcard){
            // se borra la de hasta arriba
            card.get(0);
            numCard--;
            String respuesta = "Tarjeta: " + " color: " + card.get(0).getColor() + " palo: "+card.get(0).getPalo() + " valor: " + card.get(0).getValor() + "\n" + "Quedan: " + numcard;
            return respuesta;
            
        }
        
        public String pick(Integer numcard){
            // se borra alguna otra
            int dato = (int)(Math.random()*52);
            card.get(dato);
            numCard--;
            String respuesta = "Tarjeta: " + " color: " + card.get(dato).getColor() + " palo: " + card.get(dato).getPalo() + " valor: " + card.get(dato).getValor() + "\n" + "Quedan: " + numcard;
            return respuesta;
        }
        
        public String hand(Integer numcard){
            String[] mano = new String[5]; String capturador = "";
            int dato = 0;
            for(int i = 0; i < 5; i++){
                dato = (int) (Math.random()*52);
                card.get(dato);
                capturador = "Tarjeta: ";
                capturador = capturador.concat(" color: "+card.get(dato).getColor()+" ");
                capturador = capturador.concat(" palo: "+card.get(dato).getPalo()+" ");
                capturador = capturador.concat(" valor: "+card.get(dato).getValor()+" \n");
                mano[i] = capturador;
                capturador = "";
            }
            String respuesta = ""; respuesta = respuesta.concat(Arrays.toString(mano)+"Quednan: " + numcard);
            return respuesta;
        }
}
