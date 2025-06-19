package Controlador;

import Vista.MenuPrincipalVista;
// Importa otras vistas y modelos cuando los tengas
// import Modelo.JuegoDados;
// import Vista.ResultadosJuegoVista;

public class JuegoDadosConsola {
    private final MenuPrincipalVista menuPrincipalVista;
    // ... otras dependencias (ej: JuegoDados, ResultadosJuegoVista, ConsolaJuegoVersus)

    public JuegoDadosConsola(MenuPrincipalVista menuPrincipalVista) {
        this.menuPrincipalVista = menuPrincipalVista;
        // Inicializa aquí las otras dependencias
        // this.juegoDados = new JuegoDados();
        // this.resultadosJuegoVista = new ResultadosJuegoVista();
    }

    /**
     * Inicia el ciclo principal del juego, mostrando el menú y procesando las opciones.
     * Esta es la responsabilidad de control principal.
     */
    public void iniciarJuegoPrincipal() { // Renombrado de 'menuSesion' para ser más claro
        int opcion;
        do {
            menuPrincipalVista.mostrarMenuPrincipal(); // La Vista solo MUESTRA
            opcion = menuPrincipalVista.obtenerOpcionMenu(); // La Vista solo OBTIENE LA ENTRADA

            // AQUI está la lógica de control del menú
            switch (opcion) {
                case 1:
                    jugarJuegoIndividual(); // Método que llama a la lógica del Modelo y a las Vistas de resultados
                    break;
                case 2:
                    // Esto llamaría a un método para iniciar el juego versus
                    // iniciarJuegoVersus();
                    menuPrincipalVista.mostrarMensaje("Opción 'Jugar Versus' aún no implementada.");
                    break;
                case 3:
                    if (!menuPrincipalVista.preguntarConfirmacionSalida()) {
                        opcion = 0; // Si el usuario dice NO, volvemos al menú
                    } else {
                        menuPrincipalVista.mostrarMensaje("¡Gracias por jugar! Saliendo del programa.");
                    }
                    break;
                case -1: // Opción inválida (ya manejada y con mensaje en la Vista)
                    // No hacemos nada aquí, el mensaje ya se mostró por la Vista.
                    break;
                default:
                    menuPrincipalVista.mostrarMensaje("Opción inválida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    private void jugarJuegoIndividual() {
        menuPrincipalVista.mostrarMensaje("\n--- Iniciando Juego Individual ---");
        // Aquí es donde el Controlador usaría el Modelo JuegoDados y la Vista ResultadosJuegoVista
        // Ejemplo:
        // juegoDados.lanzarDados();
        // resultadosJuegoVista.mostrarResultadoLanzamiento(juegoDados.getValorDado1(), juegoDados.getValorDado2(), juegoDados.calcularSuma(), juegoDados.esGanador());
        menuPrincipalVista.mostrarMensaje("Presione Enter para continuar...");
        menuPrincipalVista.obtenerOpcionMenu(); // Pausa para que el usuario vea el resultado
    }

    // Este método se implementaría cuando tengas el Controlador ConsolaJuegoVersus
    // private void iniciarJuegoVersus() {
    //     ConsolaJuegoVersus consolaJuegoVersus = new ConsolaJuegoVersus(menuPrincipalVista, ...);
    //     consolaJuegoVersus.iniciarJuegoVersus();
    // }
}