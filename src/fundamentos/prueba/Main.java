package fundamentos.prueba;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.plataforma.*;
import fundamentos.prueba.util.ScannerUtils;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Cine Java";
    public static final String VERSION = "1.0.0";
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        String titulo = ScannerUtils.capturarTexto("Nombre del contenido");
        String genero = ScannerUtils.capturarTexto("Genero del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

        Pelicula pelicula = new Pelicula(titulo, duracion, genero, calificacion);
        Pelicula pelicula2 = new Pelicula("El padrino", 220, "drama", 4.8);

        plataforma.agregar(pelicula);
        plataforma.agregar(pelicula2);

        System.out.println("Numero de elementos en la plataforma: " + plataforma.getContenido().size());

        plataforma.eliminar(pelicula2);

        plataforma.mostrarTitulos();

        Usuario usuario = new Usuario("Juan", "juan@gmail.com");
        System.out.println(usuario.fechaRegistro);

        usuario.ver(pelicula);
    }
}
