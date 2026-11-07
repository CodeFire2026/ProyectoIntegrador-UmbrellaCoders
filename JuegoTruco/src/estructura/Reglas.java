package estructura;

import java.util.Scanner;

public class Reglas {
    private static Scanner teclado = new Scanner(System.in);
    
    public static String mostrar_reglas(){
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
        
        int opcion2 = 0;
        do {
            System.out.println("\n 1. Ver jerarquia de cartas \n 2. Ver mas detalles \n 3. Volver\n");
            System.out.print("Elija una opcion: ");
            try {
                opcion2 = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
            opcion2 = 0;
            }
            switch (opcion2) {
                case 1:
                    System.out.println("\t- Jerarquia -");
                    System.out.println(" 1. 1 de Espada");
                    System.out.println(" 2. 1 de Basto");
                    System.out.println(" 3. 7 de Espada");
                    System.out.println(" 4. 7 de Oro");
                    System.out.println(" 5. Todos los 3");
                    System.out.println(" 6. Todos los 2");
                    System.out.println(" 7. 1 de Oro y 1 de Copa");
                    System.out.println(" 8. Todos los 12");
                    System.out.println(" 9. Todos los 11");
                    System.out.println("10. Todos los 10");
                    System.out.println("11. 7 de Basto y 7 de Copa");
                    System.out.println("12. Todos los 6");
                    System.out.println("13. Todos los 5");
                    System.out.println("14. Todos los 4");
                    break;
                case 2:
                    System.out.println("    Acerca del sistema");
                    System.out.println("Juego: Truco Argentino");
                    System.out.println("Version actual: v1.1");
                    System.out.println("Arquitectura del programa: Programacion Orientada a Objetos (POO)");
                    
                    System.out.println("Bot: Primera version.");
                    System.out.println("Elige y tira las cartas aleatoriamente.");
                    System.out.println("Decide tambien en base a probabilidades: Canta un 40% de las veces / Acepta un 50%.");
                    System.out.println("Proximas mejoras del bot: Decidir segun la jerarquia de cartas");
                    System.out.println("Cantos:");
                    System.out.println("Actualmente solo existe un solo canto: Truco");
                    System.out.println("Proximas mejoras: Retruco, vale cuatro y envido");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion2 != 3);
        return null;
    }
}
