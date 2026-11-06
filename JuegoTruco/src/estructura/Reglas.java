package estructura;

import java.util.Scanner;

public class Reglas {
    private static Scanner teclado = new Scanner(System.in);
    
    public static String mostrar_reglas(){
        System.out.println("\n-- Reglas del juego --");
        System.out.println("Formato: jugador humano vs bot.");
        System.out.println("Se reparten tres cartas a cada jugador y se juegan tres bazas por mano.");
        System.out.println("En cada baza gana la carta con mayor jerarquia.");
        System.out.println("Gana la mano quien gane dos bazas.");
        System.out.println("Para pardas(baza empatada):");
        System.out.println("En caso de que la primer baza sea parda, gana quien gane la segunda baza, o en su defecto la tercera");
        System.out.println("En caso de que la segunda baza sea parda, gana la mano quien gano la primer baza.");
        System.out.println("Cada mano vale 3 puntos. No hay cantos.");
        System.out.println("El juego termina cuando algun jugador lleggue a 15 puntos.");
        
        int opcion2 = 0;
        do {
            System.out.println("\n 1. Ver jerarquia de cartas\n 2. Volver\n");
            System.out.print("Elija una opcion: ");
            try {
                opcion2 = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
            opcion2 = 0;
            }
            switch (opcion2) {
                case 1:
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
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion2 != 2);
        return null;
    }
}
