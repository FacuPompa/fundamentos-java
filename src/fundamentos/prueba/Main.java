package fundamentos.prueba;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.excepcion.PeliculaExistenteException;
import fundamentos.prueba.plataforma.Plataforma;
import fundamentos.prueba.util.FileUtils;
import fundamentos.prueba.util.ScannerUtils;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Cine Java";
    public static final String VERSION = "1.0.0";

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int VER_POPULARES = 5;
    public static final int REPRODUCIR = 6;
    public static final int BUSCAR_POR_TIPO = 7;
    public static final int ELIMINAR = 8;
    public static final int SALIR = 9;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);

        System.out.println("Mas de " + plataforma.getDuracionTotal() + " minutos de contenido! \n");

        plataforma.getContenidoPromocionable().forEach(promocionable -> System.out.println(promocionable.promocionar()));

        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Buscar por genero
                    5. Ver populares
                    6. Reproducir
                    7. Buscar por tipo de contenido
                    8. Eliminar
                    9. Salir
                    """);
            /// las comillas triples abren bloque de texto

            switch (opcionElegida) {
                case AGREGAR -> {
                    int tipoContenido = ScannerUtils.capturarNumero("Que tipo de contenido queres agregar?\n1. Película\n2. Serie");
                    String titulo = ScannerUtils.capturarTexto("Nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");
                    LocalDate fechaEstreno = LocalDate.parse(ScannerUtils.capturarTexto("Fecha de estreno (AAAA-MM-DD)" ));

                    try {
                        if(tipoContenido == 1) {
                        plataforma.agregar(new Pelicula(titulo, duracion, genero, calificacion, fechaEstreno));

                        } else {
                            int temporadas = ScannerUtils.capturarNumero("Temporadas de la serie");
                            plataforma.agregar(new Serie(titulo, duracion, genero, calificacion, fechaEstreno, temporadas));
                        }
                    } catch (PeliculaExistenteException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case MOSTRAR_TODO -> {
                    List<ResumenContenido> contenidosResumidos = plataforma.getResumenes();
                    contenidosResumidos.forEach(resumen -> System.out.println(resumen.toString()));
                }
                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre del contenido a buscar");
                    Contenido contenido = plataforma.buscarPorTitulo(nombreBuscado);

                    if (contenido != null) {
                        System.out.println(contenido.obtenerFichaTecnica());
                    } else {
                        System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    Genero generoBuscado = ScannerUtils.capturarGenero("Opciones:");

                    List<Contenido> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(contenidoPorGenero.size() + " encontrados para el genero " + generoBuscado);
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarNumero("Cantidad de resultados a mostrar");

                    List<Contenido> contenidosPopulares = plataforma.getPopulares(cantidad);
                    contenidosPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case REPRODUCIR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido a reproducir");
                    Contenido contenido = plataforma.buscarPorTitulo(nombre);
                    if (contenido != null) {
                        plataforma.reproducir(contenido);
                    } else {
                        System.out.println(nombre + " no existe");
                    }
                }

                case BUSCAR_POR_TIPO -> {
                    int tipoContenido = ScannerUtils.capturarNumero("Tipo del contenido a buscar \n 1. Pelicula \n 2. Serie");
                    if (tipoContenido == 1) {
                        List<Pelicula> peliculas = plataforma.getPeliculas();
                        peliculas.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica() + "\n"));
                    } else {
                        List<Serie> series = plataforma.getSeries();
                        series.forEach(serie -> System.out.println(serie.obtenerFichaTecnica() + "\n"));
                    }
                }

                case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Nombre del contenido a eliminar");
                    Contenido contenido = plataforma.buscarPorTitulo(nombreAEliminar);

                    if (contenido != null) {
                        plataforma.eliminar(contenido);
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
        plataforma.getContenido().addAll(FileUtils.leerContenido());
    }
}


