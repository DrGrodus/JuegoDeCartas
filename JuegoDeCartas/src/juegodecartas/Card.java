package juegodecartas;
/**
 *
 * @author Eber MD
 */
public class Card {// clase carta
    private String palo; // tréboles, corazones, pica o diamantes.
    private String color; // rojo o negro.
    private String valor; // del 2 al 10, A, J, Q o K.

    public Card(String palo, String color, String valor){
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }
    
    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
