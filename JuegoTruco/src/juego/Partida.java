package juego;

import jugadores.Jugador;

public class Partida {
    /*
    Partida: Se juegan las manos hasta que algun jugador llegue a los puntos necesarios para ganar
  */
    private Jugador j1;
    private Jugador j2;
    private int puntosParaGanar;
    
    public Partida(Jugador j1, Jugador j2){
        this.j1 = j1;
        this.j2 = j2;
        this.puntosParaGanar = 15; // Por ahora 15
    }
    
    // Juega las manos y anuncia el ganador
    public void jugar(){
        int esMano = 1; // Empieza siendo mano el jugador 1
        do{
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Marcador:"+"  " + j1.getNombre() + " " + j1.getPuntos() + "  -  "+ j2.getNombre() + " " + j2.getPuntos());
            System.out.println((esMano == 1 ? j1.getNombre() : j2.getNombre()) + " es mano");
            System.out.println("=".repeat(40));
            
            Mano mano = new Mano(j1, j2, esMano);
            Jugador ganaMano = mano.jugar();
            ganaMano.sumarPuntos(3); //Suma tres puntos por mano ganada
            
            System.out.println("\n Gana la mano: " + ganaMano.getNombre());
            
            // Decide quien es mano en cada ronda
            if (esMano == 1){
                esMano = 2;
            }
            else {
                esMano = 1;
            }
            
        }while(j1.getPuntos() < puntosParaGanar && j2.getPuntos() < puntosParaGanar);
        
        
        String ganador;
        String mensaje;
        if (j1.getPuntos() >= puntosParaGanar){
            ganador = j1.getNombre();
            mensaje = "\tFELICIDADES, HAS GANADO!";
        }
        else {
            ganador = j2.getNombre();
            mensaje = "  Estuviste cerca, suerte para la proxima";
        }
        mostrarGanador(mensaje, ganador);
        
    }
    public static void mostrarGanador(String mensaje, String ganador){
        System.out.println("");
        System.out.println("=".repeat(45));
        System.out.println("\t  FIN DE LA PARTIDA");
        System.out.println("=".repeat(45));
        System.out.println(mensaje);
        System.out.println("\n\t    GANADOR: " + ganador);
        System.out.println("");
        System.out.println("=".repeat(45));
        System.out.println("");
    }
}
