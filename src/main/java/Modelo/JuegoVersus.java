package Modelo;

public class JuegoVersus {
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Dado dado;
    private int rondasMaximas;
    private int rondaActual;

    public static final int MODO_PRIMER_INTENTO = 1;
    public static final int MODO_MEJOR_DE_3 = 3;
    public static final int MODO_MEJOR_DE_5 = 5;

    public JuegoVersus(String nombreJugador1, String nombreJugador2) {
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
        this.dado = new Dado();
        this.rondasMaximas = MODO_PRIMER_INTENTO;
        this.rondaActual = 0;
    }

    public void configurarModalidad(int modalidad) {
        if (modalidad == MODO_PRIMER_INTENTO || modalidad == MODO_MEJOR_DE_3 || modalidad == MODO_MEJOR_DE_5) {
            this.rondasMaximas = modalidad;
        } else {
            this.rondasMaximas = MODO_PRIMER_INTENTO;
        }
    }

    public ResultadoRonda jugarTurno(Jugador jugador) {
        int valor1 = dado.lanzar();
        int valor2 = dado.lanzar();
        int suma = valor1 + valor2;
        boolean ganoRonda = (suma == 7);

        if (ganoRonda) {
            jugador.incrementarPuntaje();
        }
        return new ResultadoRonda(jugador, valor1, valor2, suma, ganoRonda);
    }

    public void siguienteRonda() {
        this.rondaActual++;
    }

    public boolean juegoTerminado() {
        int victoriasNecesarias = (rondasMaximas / 2) + 1;

        if (jugador1.getPuntaje() >= victoriasNecesarias || jugador2.getPuntaje() >= victoriasNecesarias) {
            return true;
        }
        
        if (rondasMaximas > MODO_PRIMER_INTENTO && rondaActual >= rondasMaximas) {
            return true;
        }
        
        if (rondasMaximas == MODO_PRIMER_INTENTO && (jugador1.getPuntaje() > 0 || jugador2.getPuntaje() > 0)) {
            return true;
        }

        return false;
    }

    public Jugador getGanadorFinal() {
        if (!juegoTerminado()) {
            return null;
        }

        if (jugador1.getPuntaje() > jugador2.getPuntaje()) {
            return jugador1;
        } else if (jugador2.getPuntaje() > jugador1.getPuntaje()) {
            return jugador2;
        } else {
            return null; // Empate
        }
    }

    public void reiniciarJuego() {
        jugador1.resetPuntaje();
        jugador2.resetPuntaje();
        rondaActual = 0;
    }

    // Getters
    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public int getRondasMaximas() {
        return rondasMaximas;
    }
}