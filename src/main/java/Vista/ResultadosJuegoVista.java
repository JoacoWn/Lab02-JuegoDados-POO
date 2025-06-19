package Vista;

import Modelo.ResultadoRonda;

public class ResultadosJuegoVista {

    public void mostrarEstadoRondaVersus(ResultadoRonda resultado, int puntajeJ1, int puntajeJ2, int rondaActual, int rondasMaximas) {
        System.out.println("\nResultados de la ronda:");
        System.out.println("Dado 1: " + resultado.getValorDado1());
        System.out.println("Dado 2: " + resultado.getValorDado2());
        System.out.println("Suma: " + resultado.getSuma());

        if (resultado.isGanoRonda()) {
            System.out.println("¡" + resultado.getJugador().getNombre() + " ha ganado la ronda!");
        } else {
            System.out.println(resultado.getJugador().getNombre() + " no obtuvo un 7.");
        }

        // Mostrar puntajes actuales
        System.out.println("\nPuntajes actuales:");
        System.out.println("Ronda: " + rondaActual + " de " + rondasMaximas);
        System.out.println("Jugador 1: " + puntajeJ1 + " victorias");
        System.out.println("Jugador 2: " + puntajeJ2 + " victorias");
    }

    public void mostrarGanadorVersus(String nombreGanador) {
        System.out.println("\n=== Fin del Juego ===");
        if (nombreGanador != null) {
            System.out.println("¡" + nombreGanador + " ha ganado el juego!");
        } else {
            System.out.println("¡Ambos jugadores perdieron!");
        }
    }
}