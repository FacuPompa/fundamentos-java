package fundamentos.prueba;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.plataforma.*;
import fundamentos.prueba.util.ScannerUtils;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Cine Java";
    public static final String VERSION = "1.0.0";

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int ELIMINAR = 4;
    public static final int SALIR = 5;
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones: 
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Eliminar
                    5. Salir
                    """);


            System.out.println("Opcion elegida: " + opcionElegida);

            switch (opcionElegida) {
                case AGREGAR -> {
                    String titulo = ScannerUtils.capturarTexto("Nombre del contenido");
                    String genero = ScannerUtils.capturarTexto("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

                    plataforma.agregar(new Pelicula(titulo, duracion, genero, calificacion));
                }
                case MOSTRAR_TODO -> plataforma.mostrarTitulos();
                case BUSCAR_POR_TITULO -> {

                }
                case ELIMINAR -> {

                }
                case SALIR -> System.exit(0);
            }

        }
    }
}
