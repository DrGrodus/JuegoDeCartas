package juegodecartas;

import java.util.*;

/**
 *
 * @author Eber MD
 */

public class JuegoDeCartas {

    public static Deck deck = new Deck();

    public static void main(String[] args) {
        String[] color = {"rojo", "negro"};
        String[] palo = {"Trebol", "Diamante", "Pica", "Corazon"};
        String[] valor = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
        Integer cont = 1;
        String accion = "";

        deck.setCard(new ArrayList<Card>());
        for (int i = 0; i < palo.length; i++) {
            for (int j = 0; j < valor.length; j++) {
                Card card = new Card(palo[i], getColor(palo[i]), valor[j]);
                deck.getCard().add(card);
                cont++;
            }
        }
        ShowMenu();
    }

    public static String getColor(String palo) {
        if (palo.toLowerCase().equals("pica") || palo.toLowerCase().equals("trebol")) {
            return "negro";
        }
        if (palo.toLowerCase().equals("corazon") || palo.toLowerCase().equals("diamante")) {
            return "rojo";
        }
        return null;
    }

    public static void ShowMenu() {
        Scanner lector = new Scanner(System.in);
        int resp = 1; // variable de control para el switch.
        while (resp != 0) { // primero verifica sí se cumple la condición y después continua.
            System.out.println("Bienvenido a Póker!"
                    + "\n" + "el tamanho del deck es: " + deck.tamanho()
                    + "\n" + "Selecciona una opción: "
                    + "\n" + "1 - Mezclar Deck"
                    + "\n" + "2 - Sacar una carta"
                    + "\n" + "3 - Sacar carta al azar"
                    + "\n" + "4 - Generar una mano de 5 cartas"
                    + "\n" + "0 - Salir");
            try {
                resp = lector.nextInt();
                switch (resp) {
                    case 1:
                        System.out.println(deck.shuffle() + "\n");
                        break;
                    case 2:
                        System.out.println(deck.head() + "\n");
                        break;
                    case 3:
                        System.out.println(deck.pick() + "\n");
                        break;
                    case 4:
                        System.out.println(deck.hand() + "\n");
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("La opción indicada no es válida, por favor selecciona una de las siguientes: " + "\n");
                        break;
                }
            } catch (InputMismatchException e) { // este tipo de error logra atrapar cuando se introduce un caracter no numérico.
                System.out.println("Por favor solo introduce numeros" + "\n");
                lector.nextLine(); // limpia el buffer, borrando el contenido, lo que permite ser llenado nuevamente.
            }
        }
        System.out.println("Gracias por jugar!");
    }
}
