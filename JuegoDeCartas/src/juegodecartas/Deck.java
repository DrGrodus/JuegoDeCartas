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
        
        public String shuffle(){
            Collections.shuffle(card);
            return "Se mezclo el Deck"; // se mezclan las cartas
        }
        
        public String head(){
            // se borra la de hasta arriba
            card.get(0); // tomamos la carta de la parte superior
            numCard--; // restamos al total de cartas
            String respuesta = "Tarjeta: " + " color: " + card.get(0).getColor() + " palo: "+card.get(0).getPalo() + " valor: " + card.get(0).getValor() + "\n" + "Quedan: " + numCard;
            card.remove(0);
            
            return respuesta; // devolvemos la respuesta
            
        }
        
        public String pick(){
            // se borra alguna otra
            int dato = (int)(Math.random()*numCard); // esta operacion devuelve valores enteros no mayores a 52
            card.get(dato); // cual sea el dato, sera la tarjeta que tomara
            numCard--;
            String respuesta = "Tarjeta: " + " color: " + card.get(dato).getColor() + " palo: " + card.get(dato).getPalo() + " valor: " + card.get(dato).getValor() + "\n" + "Quedan: " + numCard;
            card.remove(dato);
            
            return respuesta; // se devuelve la respuesta
        }
        
        public String hand(){
            String[] mano = new String[5]; String capturador = ""; // tenemos un arreglo de cadenas que guardará cada tarjeta como elemento de String y la otra cadena será para entregar todos los valores de una tarjeta a la posicion del arreglo
            int dato = 0; // esto es simplemente capta el numero aleatorio de la tarjeta, igual que con el metodo pick
            try{
                for(int i = 0; i < 5; i++){
                    dato = (int) (Math.random()*numCard);
                    card.get(dato);
                    capturador = "Tarjeta: ";
                    capturador = capturador.concat(" color: "+card.get(dato).getColor()+" "); // utilizamos el metodo concat para juntar los atributos de la tarjeta y poder prresentarlos con la cadena respuesta
                    capturador = capturador.concat(" palo: "+card.get(dato).getPalo()+" ");
                    capturador = capturador.concat(" valor: "+card.get(dato).getValor()+" \n");
                    mano[i] = capturador;
                    capturador = "";
                    card.remove(dato);
                }
            } catch(IndexOutOfBoundsException e){
                System.out.println(e);
            }
            numCard = numCard-5; // se reduce 5 veces el contador 
            numCard = (numCard < 5) ? numCard = 0 : Math.abs(numCard); // se determina si el valor puede ser negativo o no
            String respuesta = ""; respuesta = respuesta.concat(Arrays.toString(mano)+"Quedan: " + numCard);
            return respuesta;
        }
}
