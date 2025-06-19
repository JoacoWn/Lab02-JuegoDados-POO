package Modelo;

public class Jugador {
    private final String nombre;
    private int puntaje;

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    // Métodos
    public void incrementarPuntaje() {
        this.puntaje++;
    }

    public void resetPuntaje() {
        this.puntaje = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
}