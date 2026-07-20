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

        cargarPeliculas(plataforma);

        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones: 
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Eliminar
                    5. Salir
                    """);

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
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre del contenido a buscar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                    if(pelicula != null) {
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Nombre del contenido a eliminar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreAEliminar);

                    if(pelicula != null) {
                        plataforma.eliminar(pelicula);
                        System.out.println(nombreAEliminar + " eliminado");
                    } else {
                        System.out.println(nombreAEliminar + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case SALIR -> System.exit(0);
            }

        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.agregar(new Pelicula ("El senior de los anillos", 201, "Accion", 9));
        plataforma.agregar(new Pelicula ("El Padrino",175, "Drama", 9.2));
        plataforma.agregar(new Pelicula ("Titanic",194, "Drama", 8));
        plataforma.agregar(new Pelicula ("Interestellar",169, "Ciencia Ficcion", 8.7));
        plataforma.agregar(new Pelicula ("Joker",122, "Drama", 8.3));
        plataforma.agregar(new Pelicula ("Kill Bill",111, "Accion", 8.2));
        plataforma.agregar(new Pelicula ("El club de la pelea",139, "Drama", 8.8));
        plataforma.agregar(new Pelicula ("Los siete samurais",207, "Accion", 8.6));
        plataforma.agregar(new Pelicula ("Gladiador",155, "Accion", 8.5));

    }
}


