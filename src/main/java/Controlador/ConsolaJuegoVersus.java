package Controlador;

import Modelo.JuegoVersus;
import Modelo.Jugador;
import Modelo.ResultadoRonda;
import Vista.ResultadosJuegoVista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolaJuegoVersus {
    private final Scanner scanner;
    private final JuegoVersus juegoVersus;
    private final ResultadosJuegoVista resultadosVista;

    public ConsolaJuegoVersus(Scanner scanner, String nombreJugador1, String nombreJugador2) {
        this.scanner = scanner;
        this.juegoVersus = new JuegoVersus(nombreJugador1, nombreJugador2);
        this.resultadosVista = new ResultadosJuegoVista();
    }

    public void iniciarJuegoVersus() {
        int opcionModalidad = solicitarModalidadJuego();
        juegoVersus.configurarModalidad(opcionModalidad);

        boolean continuarJugando = true;
        do {
            juegoVersus.reiniciarJuego();
            System.out.println("\n--- ¡Comienza el Juego Versus! ---");
            System.out.println("Modalidad: " + obtenerNombreModalidad(juegoVersus.getRondasMaximas()));

            while (!juegoVersus.juegoTerminado()) {
                juegoVersus.siguienteRonda();

                // Turno del Jugador 1
                System.out.println("\n--- Turno de " + juegoVersus.getJugador1().getNombre() + 
                                 " (Ronda " + juegoVersus.getRondaActual() + ") ---");
                System.out.print("Presiona ENTER para lanzar los dados...");
                scanner.nextLine();
                ResultadoRonda resJugador1 = juegoVersus.jugarTurno(juegoVersus.getJugador1());
                resultadosVista.mostrarEstadoRondaVersus(resJugador1, 
                    juegoVersus.getJugador1().getPuntaje(), 
                    juegoVersus.getJugador2().getPuntaje(), 
                    juegoVersus.getRondaActual(), 
                    juegoVersus.getRondasMaximas());

                if (juegoVersus.juegoTerminado()) {
                    break;
                }

                // Turno del Jugador 2
                System.out.println("\n--- Turno de " + juegoVersus.getJugador2().getNombre() + 
                                 " (Ronda " + juegoVersus.getRondaActual() + ") ---");
                System.out.print("Presiona ENTER para lanzar los dados...");
                scanner.nextLine();
                ResultadoRonda resJugador2 = juegoVersus.jugarTurno(juegoVersus.getJugador2());
                resultadosVista.mostrarEstadoRondaVersus(resJugador2, 
                    juegoVersus.getJugador1().getPuntaje(), 
                    juegoVersus.getJugador2().getPuntaje(), 
                    juegoVersus.getRondaActual(), 
                    juegoVersus.getRondasMaximas());
            }

            Jugador ganador = juegoVersus.getGanadorFinal();
            if (ganador != null) {
                resultadosVista.mostrarGanadorVersus(ganador.getNombre());
            } else {
                resultadosVista.mostrarGanadorVersus(null);
            }

            continuarJugando = preguntarContinuarJuego();
            if (continuarJugando) {
                System.out.println("\n--- Iniciando una nueva partida Versus ---");
                opcionModalidad = solicitarModalidadJuego();
                juegoVersus.configurarModalidad(opcionModalidad);
            }

        } while (continuarJugando);

        System.out.println("Saliendo del juego Versus...");
    }

    private int solicitarModalidadJuego() {
        int opcion;
        do {
            System.out.println("\n--- Seleccione la modalidad de juego ---");
            System.out.println("[1] Al primer intento");
            System.out.println("[3] Al mejor de 3 intentos");
            System.out.println("[5] Al mejor de 5 intentos");
            System.out.print("Opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion != JuegoVersus.MODO_PRIMER_INTENTO &&
                    opcion != JuegoVersus.MODO_MEJOR_DE_3 &&
                    opcion != JuegoVersus.MODO_MEJOR_DE_5) {
                    System.out.println("Opción de modalidad inválida. Intente de nuevo.");
                    opcion = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número (1, 3 o 5).");
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion == -1);
        return opcion;
    }

    private boolean preguntarContinuarJuego() {
        System.out.print("\n¿Desean jugar otra partida Versus? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S");
    }
    
    private String obtenerNombreModalidad(int modalidad) {
        return switch (modalidad) {
            case JuegoVersus.MODO_PRIMER_INTENTO -> "Al primer intento";
            case JuegoVersus.MODO_MEJOR_DE_3 -> "Al mejor de 3 intentos";
            case JuegoVersus.MODO_MEJOR_DE_5 -> "Al mejor de 5 intentos";
            default -> "Desconocida";
        };
    }
}