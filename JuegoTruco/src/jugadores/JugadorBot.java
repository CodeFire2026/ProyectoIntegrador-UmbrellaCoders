package jugadores;

import jugadores.Jugador;
import estructura.Carta;
import java.util.Random;

/*
Jugador controlado por la computadora. Primera version: elige una carta
al azar de las que le quedan. No imprime nada: de anunciar la jugada se
encarga la clase Mano.
*/
public class JugadorBot extends Jugador {

    private final Random azar;

    public JugadorBot(String nombre) {
        super(nombre);
        this.azar = new Random();
    }

    @Override
    public Carta elegirCarta() {
        if (!tieneCartas()) {
            throw new IllegalStateException(getNombre() + " no tiene cartas para jugar");
        }
        int indice = azar.nextInt(getMano().size());
        return sacarCarta(indice);
    }
    
    // Metodos cantar y aceptar Truco
    @Override
    public boolean cantarTruco(){
        // Math.random genera un numero aleatorio entre 0 y uno
        // Si genera uno menor al establecido, devuelve true y canta, sino false y juega callado
        return Math.random() < 0.4; // Le damos un 40% de probabilidades al bot de cantar truco
    }
    @Override
    public boolean aceptarTruco(){
        return Math.random() >= 0.5; // Lo mismo que el canto, pero con mas posibilidades de aceptar
    }
}
