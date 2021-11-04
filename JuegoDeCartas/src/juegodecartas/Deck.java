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

    public String shuffle() {
        Collections.shuffle(card);
        return "Se mezclo el Deck"; // se mezclan las cartas
    }

    public String head() {
        // se borra la de hasta arriba
        String respuesta = "";
        if (!getCard().isEmpty()) {
            card.get(0); // tomamos la carta de la parte superior
            numCard--; // restamos al total de cartas
            respuesta = "Tarjeta: " + " color: " + card.get(0).getColor() + " palo: " + card.get(0).getPalo() + " valor: " + card.get(0).getValor() + "\n" + "Quedan: " + numCard;
            card.remove(0);
        } else {
            respuesta = "Lo sentimos, se han agotado las cartas";
        }
        return respuesta; // devolvemos la respuesta

    }

    public String pick() {
        // se borra alguna otra
        int dato = 0;
        String respuesta = "";
        if (!getCard().isEmpty()) {
            dato = (int) (Math.random() * numCard + 1); // esta operacion devuelve valores enteros no mayores a 52
            card.get(dato); // cual sea el dato, sera la tarjeta que tomara
            numCard--;
            respuesta = "Tarjeta: " + " color: " + card.get(dato).getColor() + " palo: " + card.get(dato).getPalo() + " valor: " + card.get(dato).getValor() + "\n" + "Quedan: " + numCard;
            card.remove(dato);
        } else {
            respuesta = "Lo sentimos, se han agotado las cartas";
        }
        return respuesta; // se devuelve la respuesta
    }

    public String hand() {
        String[] mano = new String[5];
        String capturador = ""; // tenemos un arreglo de cadenas que guardará cada tarjeta como elemento de String y la otra cadena será para entregar todos los valores de una tarjeta a la posicion del arreglo
        int dato = 0; // esto es simplemente capta el numero aleatorio de la tarjeta, igual que con el metodo pick
        String respuesta = "";
        if (!getCard().isEmpty() || numCard > 5) {
            try {
                for (int i = 0; i < 5; i++) {
                    dato = (int) (Math.random() * numCard + 1);
                    card.get(dato);
                    capturador = "Tarjeta: ";
                    capturador = capturador.concat(" color: " + card.get(dato).getColor() + " "); // utilizamos el metodo concat para juntar los atributos de la tarjeta y poder prresentarlos con la cadena respuesta
                    capturador = capturador.concat(" palo: " + card.get(dato).getPalo() + " ");
                    capturador = capturador.concat(" valor: " + card.get(dato).getValor() + " \n");
                    mano[i] = capturador;
                    capturador = "";
                    card.remove(dato);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("");
            }
            numCard -= 5; // se reduce 5 veces el contador 
            respuesta = respuesta.concat(Arrays.toString(mano) + "Quedan: " + numCard);
        }else if (numCard < 5 && numCard != 0) {
            respuesta = "Lo sentimos, no tiene cartas sufieicentes";
        }else if (numCard == 0) {
            respuesta = "Lo sentimos, se han agotado las cartas";
        }
        return respuesta;
    }
}
