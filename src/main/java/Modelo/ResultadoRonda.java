package Modelo;

public class ResultadoRonda {
    private final Jugador jugador;
    private final int valorDado1;
    private final int valorDado2;
    private final int suma;
    private final boolean ganoRonda;

    public ResultadoRonda(Jugador jugador, int valorDado1, int valorDado2, int suma, boolean ganoRonda) {
        this.jugador = jugador;
        this.valorDado1 = valorDado1;
        this.valorDado2 = valorDado2;
        this.suma = suma;
        this.ganoRonda = ganoRonda;
    }

    // Getters
    public Jugador getJugador() {
        return jugador;
    }

    public int getValorDado1() {
        return valorDado1;
    }

    public int getValorDado2() {
        return valorDado2;
    }

    public int getSuma() {
        return suma;
    }

    public boolean isGanoRonda() {
        return ganoRonda;
    }
}