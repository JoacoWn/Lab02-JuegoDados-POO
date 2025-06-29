package Vista;

import Modelo.JuegoDados;
import Controlador.ConsolaJuegoVersus;


public class MenuPrincipalVista {
    private static final java.util.Scanner sc = new java.util.Scanner(System.in);

    public MenuPrincipalVista() {
        menu();
    }

    public static void menu() {
        int opcion;
        boolean salir = false;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion(0);
            if (opcion != -1) {
                if (opcion == 3) {
                    salir = confirmarSalida();
                    if (!salir) {
                        opcion = 0; // Para continuar el bucle
                    }
                } else {
                    ejecutarOpcion(opcion);
                }
            }
        } while (opcion != 3 || !salir);
    }

    // Métodos nuevos necesarios para JuegoDadosConsola
    public void mostrarMenuPrincipal() {
        mostrarOpciones();
    }

    public int obtenerOpcionMenu() {
        return obtenerOpcion(0);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public boolean preguntarConfirmacionSalida() {
        return confirmarSalida();
    }

    // Métodos originales
    private static boolean confirmarSalida() {
        System.out.println("\n¿Está seguro que desea salir del juego? (S/N): ");
        String respuesta = sc.nextLine().trim().toUpperCase();

        if (respuesta.equals("S")) {
            System.out.println("\n¡Gracias por jugar! Hasta luego...");
            return true;
        } else {
            System.out.println("\nContinuando con el juego...");
            return false;
        }
    }

    public static void mostrarOpciones() {
        System.out.println("\n=============================");
        System.out.println("            Taller            ");
        System.out.println("      Opciones      ");
        System.out.println("============================= ");
        System.out.println("    [1] Jugar Dado Individual   ");
        System.out.println("    [2] Jugar Dado Versus   ");
        System.out.println("    [3] Salir       ");
        System.out.println("============================= ");
        System.out.print("      Opcion: ");
    }

    public static int obtenerOpcion(int opcion) {
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1;
        }
        return opcion;
    }


    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> JugarIndividual();
            case 2 -> JugarVersus();
            case 3 -> System.out.println("Hasta luego...");
            default -> System.out.println("Opción inválida...");
        }
    }

    public static void JugarVersus() {
        System.out.println("\n=== Juego Versus de Dados ===");
        System.out.println("Ingrese el nombre del Jugador 1:");
        String nombreJugador1 = sc.nextLine();
        System.out.println("Ingrese el nombre del Jugador 2:");
        String nombreJugador2 = sc.nextLine();

        ConsolaJuegoVersus juegoVersus = new ConsolaJuegoVersus(sc, nombreJugador1, nombreJugador2);
        juegoVersus.iniciarJuegoVersus();
    }

    public static void JugarIndividual() {
        System.out.println("\n=== Juego Individual de Dados ===");
        System.out.println("Objetivo: Obtener una suma de 7 para ganar");

        JuegoDados juegoDados = new JuegoDados();
        juegoDados.jugar();

        System.out.println("\nResultados:");
        System.out.println("Dado 1: " + juegoDados.getValorDado1());
        System.out.println("Dado 2: " + juegoDados.getValorDado2());
        System.out.println("Suma total: " + juegoDados.getSumaCaras());

        if (juegoDados.isGanoJugador()) {
            System.out.println("\n¡Felicitaciones! ¡Has ganado!");
        } else {
            System.out.println("\nLo siento, has perdido. Inténtalo de nuevo.");
        }

        System.out.println("\nPresiona ENTER para continuar...");
        sc.nextLine();
    }
}