package Modelo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoDadosTest {

    private JuegoDados juego;

    @BeforeEach
    void setUp() {
        juego = new JuegoDados();
    }

    @Test
    void testValoresDados() {
        juego.jugar();
        int dado1 = juego.getValorDado1();
        int dado2 = juego.getValorDado2();

        assertTrue(dado1 >= 1 && dado1 <= 6,
                "El valor del dado 1 debe estar entre 1 y 6");
        assertTrue(dado2 >= 1 && dado2 <= 6,
                "El valor del dado 2 debe estar entre 1 y 6");
    }

    @Test
    void testSumaDados() {
        juego.jugar();
        assertEquals(juego.getValorDado1() + juego.getValorDado2(),
                juego.getSumaCaras(),"La suma debe ser igual a la suma de los valores de los dados");
    }

}