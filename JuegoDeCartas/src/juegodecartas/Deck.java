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
        
        public Integer nCards(){ // Metodo para conocer la cantidad de cartas que hay en la mesa, especialmente util en llamados de otros metodos
            return numCard;
        }
        
        public String shuffle(){
            Collections.shuffle(card);
            return "Se mezclo el Deck"; // se mezclan las cartas
        }
        
        public String head(Integer numcard){
            // se borra la de hasta arriba
            card.get(0); // tomamos la carta de la parte superior
            numCard--; // inmediatamente restamos al total de cartas
            String respuesta = "Tarjeta: " + " color: " + card.get(0).getColor() + " palo: "+card.get(0).getPalo() + " valor: " + card.get(0).getValor() + "\n" + "Quedan: " + numcard;
            card.remove(0);
            return respuesta; // devolvemos la respuesta
            
        }
        
        public String pick(Integer numcard){
            // se borra alguna otra
            int dato = (int)(Math.random()*52); // esta operacion devuelve valores enteros no mayores a 52
            card.get(dato); // cual sea el dato, sera la tarjeta que tomara
            numCard--;
            String respuesta = "Tarjeta: " + " color: " + card.get(dato).getColor() + " palo: " + card.get(dato).getPalo() + " valor: " + card.get(dato).getValor() + "\n" + "Quedan: " + numcard;
            card.remove(dato);
            return respuesta; // se devuelve la respuesta
        }
        
        public String hand(Integer numcard){
            String[] mano = new String[5]; String capturador = ""; // tenemos un arreglo de cadenas que guardará cada tarjeta como elemento de String y la otra cadena será para entregar todos los valores de una tarjeta a la posicion del arreglo
            int dato = 0; // esto es simplemente capta el numero aleatorio de la tarjeta, igual que con el metodo pick
            for(int i = 0; i < 5; i++){
                dato = (int) (Math.random()*52);
                card.get(dato);
                capturador = "Tarjeta: ";
                capturador = capturador.concat(" color: "+card.get(dato).getColor()+" "); // utilizamos el metodo concat para juntar los atributos de la tarjeta y poder prresentarlos con la cadena respuesta
                capturador = capturador.concat(" palo: "+card.get(dato).getPalo()+" ");
                capturador = capturador.concat(" valor: "+card.get(dato).getValor()+" \n");
                mano[i] = capturador;
                capturador = "";
                card.remove(dato);
            }
            String respuesta = ""; respuesta = respuesta.concat(Arrays.toString(mano)+"Quedan: " + numcard);
            return respuesta;
        }
}
