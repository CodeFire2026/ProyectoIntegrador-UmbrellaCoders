package juego;

import estructura.*;
import java.util.List;
import jugadores.Jugador;

public class Mano {
    /*
    Mano: Consiste en tres bazas; se reparten 3 cartas a cada jugador y gana 
    la mano quien gane primero dos bazas. Se aplican regla para pardas
  */
    private Jugador j1;
    private Jugador j2;
    private int esMano;
    private Canto canto;
    
    // Constructor para los jugadores y quien es mano
    public Mano(Jugador j1, Jugador j2, int esMano){
        this.j1 = j1;
        this.j2 = j2;
        this.esMano = esMano;
    }
    
  
    public int getPuntosMano(){
        return canto.getPuntos();
    }
    
    // Metodo jugar: Juega una mano completa y devuelve el ganador
    public Jugador jugar(){
        // Crear y mezclar el mazo
        Mazo mazo = new Mazo();
        mazo.mezclar();
        
        // Reparte tres cartas a cada jugador, recibirCartas descarta las cartas
        // de la mano anterior para empezar limpio
        j1.recibirCartas(mazo.repartir(3));
        j2.recibirCartas(mazo.repartir(3));
        
        canto = new Canto();
        
        int ganador1 = 0; // Bazas ganadas por el jugador 1
        int ganador2 = 0; // Bazas ganadas por el jugador 2
        int turno = esMano; // Quien tira primero en la baza actual
        int primera = -1;//Esto es para el resultado de la primer baza (1,2 o 0) es -1 porque aun no se jugo
        
        for (int j = 1; j <= 3; j++){
            Carta c1; // Carta del j1
            Carta c2; // Carta del j2
            
            
            // Bloque para cantar o aceptar truco
            Jugador jugadorQueCanta = (turno == 1) ? j1 : j2;
            Jugador jugadorQueResponde = (turno == 1) ? j2 : j1;

            // Intentar cantar Truco
            Jugador ganadorPorRechazo = canto.quiereCantar(jugadorQueCanta,jugadorQueResponde);

            // Si el rival no acepta, termina la mano
            if (ganadorPorRechazo != null) {
                return ganadorPorRechazo;
            }
            
            
            // Esto es para mejorar el formato de salida
            System.out.println("\n  Baza " + j + "  Turno de " + (turno == 1 ? j1.getNombre() : j2.getNombre())); 
            System.out.println("  " + "-".repeat(35));

            
            if (turno == 1){
                c1 = j1.elegirCarta();
                System.out.println(" > " + j1.getNombre()+" juega: "+c1);
                c2 = j2.elegirCarta();
                System.out.println(" > " + j2.getNombre()+" juega: "+c2);
            }else {
                c2 = j2.elegirCarta();
                System.out.println(" > " + j2.getNombre()+" juega: "+c2);
                c1 = j1.elegirCarta();
                System.out.println(" > " + j1.getNombre()+" juega: "+c1);
            }
            
            Baza baza = new Baza(c1, c2);
            int resultado = baza.getGanador();
            
            if (j == 1) {
                primera = resultado; // Guardamos el valor de la primer baza para desempatar si es parda
            }
            
            if (resultado == 1){ // Esto suma la baza, muestra el nombre del que gano la baza y hace que empiece la siguiente
                System.out.println("\nGana la baza: " + j1.getNombre());
                ganador1++;
                turno = 1;
            }else if (resultado == 2){
                System.out.println("\nGana la baza: " + j2.getNombre());
                ganador2++;
                turno = 2;
            }else {
                turno = esMano; // Si es parda empieza el que es mano
                System.out.println("\n ! La baza es parda");
            }
            
            // Evalua si alguno ya gano dos bazas
            if (ganador1 == 2 || ganador2 == 2){
            break;
            }
            // Ganó la primera y empato la segunda
            if (j == 2 && primera != 0 && resultado == 0) {
                break;
            }
            // Empato la primera y perdio la segunda
            if (j == 2 && primera == 0 && resultado != 0) {
                break;
            }
        }
        // Decide y devuelve el ganador
        if (ganador1 > ganador2){
            return j1;
        }else if (ganador2 > ganador1){
            return j2;
        }else{ // Esto para las bazas igualadas: se desempata con la primer baza
            System.out.println("\n + La mano se define por pardas");
            if (primera == 1) {
                return j1;
            }
            else if (primera == 2){
                return j2;
            } else {
                if (esMano == 1){
                    return j1;
                }else {
                    return j2;
                }
            }
        }  
    }
}
