package estructura;

import java.util.Scanner;

public class Reglas {
    private static final String[] JERARQUIA = {
        "1 de Espada",
        "1 de Basto",
        "7 de Espada",
        "7 de Oro",
        "Todos los 3",
        "Todos los 2",
        "1 de Oro y 1 de Copa",
        "Todos los 12",
        "Todos los 11",
        "Todos los 10",
        "7 de Basto y 7 de Copa",
        "Todos los 6",
        "Todos los 5",
        "Todos los 4"
    };
    public static void mostrarJerarquia(){
        for (int i = 1; i < JERARQUIA.length; i++) {
                        System.out.println(i + 1+". "+JERARQUIA[i]);
                    }
    }
    private static void mostrarDetalles() {
        System.out.println("\n- Acerca del sistema -");
        System.out.println("Juego: Truco Argentino");
        System.out.println("Version: 1.2");
        System.out.println("Arquitectura: Programacion Orientada a Objetos (POO)");
        System.out.println("Bot: Primera version:");
        System.out.println("Elige las cartas aleatoriamente.");
        System.out.println("Proximas mejoras del juego:");
        System.out.println("- Decisiones del bot segun jerarquia de las cartas.");
        System.out.println("- Retruco.");
        System.out.println("- Vale Cuatro.");
        System.out.println("- Envido.");
    }
            
    public static void  mostrarReglas(Scanner teclado){
        System.out.println("\n-- Reglas del juego --");
        System.out.println("Formato: jugador humano vs bot.");
        System.out.println("Se reparten tres cartas a cada jugador y se juegan tres bazas por mano.");
        System.out.println("En cada baza gana la carta de mayor jerarquia.");
        System.out.println("Gana la mano quien gane dos bazas, o en su defecto si alguien canta truco y el rival no acepta.");
        System.out.println("Para pardas(baza empatada):");
        System.out.println("En caso de que la primer baza sea parda, gana quien gane la segunda baza, o en su defecto la tercera");
        System.out.println("En caso de que la segunda baza sea parda, gana la mano quien gano la primer baza.");
        System.out.println("Las manos sin canto de truco valen 1 punto, con canto 2");
        System.out.println("El juego termina cuando algun jugador llega a 15 puntos.");
        
        int opcion = 0;
        do {
            System.out.println("\n 1. Ver jerarquia de cartas\n 2. Ver mas detalles\n 3. Volver");
            System.out.print("Elija una opcion: ");
            try {
                opcion = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
            opcion = 0;
            }
            switch (opcion) {
                case 1:
                    mostrarJerarquia();
                    break;
                case 2:
                    mostrarDetalles();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 3);
    }
}
