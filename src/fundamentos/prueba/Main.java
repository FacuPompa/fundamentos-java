package fundamentos.prueba;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.plataforma.*;
import fundamentos.prueba.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Cine Java";
    public static final String VERSION = "1.0.0";
    public static void main(String[] args) {
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        String titulo = ScannerUtils.capturarTexto("Nombre del contenido");
        String genero = ScannerUtils.capturarTexto("Genero del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

        Pelicula pelicula = new Pelicula(titulo, duracion, genero, calificacion);

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario usuario = new Usuario("Juan", "juan@gmail.com");
        System.out.println(usuario.fechaRegistro);

        usuario.ver(pelicula);
    }
}
