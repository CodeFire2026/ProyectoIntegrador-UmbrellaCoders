package juego;
/*
Partida: Se juegan las manos hasta que algun jugador llega a 15 puntos
*/
public class Partida {
    private String jugador1; //Sera de tipo Jugador cuando mi comp suba su parte
    private String jugador2;
    private int puntosParaGanar; //Puntos necesarios para ganar y finalizar la partida
    
    public Partida(String jugador1,String jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.puntosParaGanar = 15;
    }
    public void iniciar(){

    }
}
