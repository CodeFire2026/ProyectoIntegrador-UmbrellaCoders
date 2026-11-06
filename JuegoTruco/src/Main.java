
import estructura.Reglas;
import java.util.Scanner;
import juego.Partida;
import jugadores.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String nombre;
        
        do {
            System.out.println("=== TRUCO ===");
            System.out.println("1. Jugar");
            System.out.println("2. Ver reglas");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");

            String entrada = teclado.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = 0;   // entrada no valida
            }

            switch (opcion) {
                case 1:
                    // Completá: pedir el nombre, crear JugadorHumano(nombre, teclado)
                    // y JugadorBot("CPU"), crear la Partida y llamar a jugar()
                    System.out.println("Escriba su nombre: ");
                    nombre = teclado.nextLine().trim();
                    
                    Jugador a = new JugadorHumano(nombre, teclado);
                    Jugador b = new JugadorBot("Bot");
                    
                    Partida partida = new Partida(a, b);
                    partida.jugar();
                    break;
                case 2:
                        Reglas.mostrar_reglas();
                        break;
                case 3:
                    System.out.println("\nCerrando programa..");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 3);
        System.out.println("Programa finalizado.");
        teclado.close();
    }
}
