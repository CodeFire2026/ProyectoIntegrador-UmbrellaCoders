package juego;

import estructura.Carta;

public class Baza {
    /*
    La baza es una jugada dentro de una mano: cada jugador tira una carta
    y gana el que tiro la de mayor jerarquia.
    Esta clase solo guarda las dos cartas y dice cual gano.
  */
    private Carta carta1; // Carta de jugador 1
    private Carta carta2; // Carta de jugador 2
    
    public Baza(Carta carta1, Carta carta2){ // Crea una baza con las dos cartas jugadas
        this.carta1 = carta1;
        this.carta2 = carta2;
    }
    
    // Metodo para el ganador de cada baza
    public int getGanador(){ 
        // Compara la jerarquia de las dos cartas jugadas
        if (carta1.getJerarquia() > carta2.getJerarquia()){
            return 1; // Si gana la carta del jugador 1
        }else if (carta2.getJerarquia() > carta1.getJerarquia()){
            return 2; // Si gana la carta del jugador 2
        }else {
            return 0; // Si es parda
        }
    }
}
