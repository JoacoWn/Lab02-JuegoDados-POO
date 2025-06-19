package Modelo;

public class JuegoDados {
    private final Dado dado1;
    private final Dado dado2;
    private int sumaCaras;
    private boolean ganoJugador;

    // Constructor
    public JuegoDados() {
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.sumaCaras = 0;
        this.ganoJugador = false;
    }

    // Métodos (se omite la implementación para este listado, solo nos enfocamos en getters/constructores)
    public void jugar() {
        // Lógica para lanzar dados, calcular suma y determinar si ganó
        int valor1 = dado1.lanzar();
        int valor2 = dado2.lanzar();
        this.sumaCaras = valor1 + valor2;
        this.ganoJugador = (this.sumaCaras == 7);
    }

    // Getters
    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    }

    public int getSumaCaras() {
        return sumaCaras;
    }

    public boolean isGanoJugador() {
        return ganoJugador;
    }


    public int getValorDado1() {
        return dado1.getValorActual();
    }

    public int getValorDado2() {
        return dado2.getValorActual();
    }
}