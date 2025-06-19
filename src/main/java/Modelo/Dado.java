package Modelo;

import java.util.Random;

public class Dado {
    private int valorActual;
    private final Random random; // Necesario para generar números aleatorios

    // Constructor
    public Dado() {
        this.random = new Random(); // Inicializa el generador de números aleatorios
    }

    // Métodos
    public int lanzar() {
        this.valorActual = random.nextInt(6) + 1; // Genera un número entre 1 y 6
        return this.valorActual;
    }

    // Getters
    public int getValorActual() {
        return valorActual;
    }
}