package juego;

import jugadores.Jugador;

public class Canto {
    // Estados posibles del canto
    public enum EstadoCanto {
        SIN_CANTAR,
        ACEPTADO,
        RECHAZADO
    }

    private EstadoCanto estadoCanto;
    private int puntos;
    
    public Canto() {
        estadoCanto = EstadoCanto.SIN_CANTAR;
        puntos = 1;
    }

    // Este metodo controla el canto del truco
    public Jugador quiereCantar(Jugador jugadorQueCanta, Jugador jugadorQueResponde) {
        // Si ya se canto no se puede volver a cantar
        if (estadoCanto != EstadoCanto.SIN_CANTAR) {
            return null;
        }
        
        // Preguntar si quiere cantar
        if (!jugadorQueCanta.cantarTruco()) {
            return null;
        }
        
        System.out.println("\n > " + jugadorQueCanta.getNombre() + " canta truco!");
        
        // El otro jugador responde
        if (jugadorQueResponde.aceptarTruco()) {
            System.out.println("\n > " + jugadorQueResponde.getNombre()+ " acepta");
            estadoCanto = EstadoCanto.ACEPTADO;
            puntos = 2;
            
        } else {
            System.out.println("\n > " + jugadorQueResponde.getNombre()+ " no acepta");
            estadoCanto = EstadoCanto.RECHAZADO;
            puntos = 1;
            // Devuelve al jugador que gano por rechazo
            return jugadorQueCanta;
        }
        return null;
    }

    public int getPuntos() {
        return puntos;
    }

    public EstadoCanto getEstado() {
        return estadoCanto;
    }
}
