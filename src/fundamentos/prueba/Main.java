package fundamentos.prueba;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.plataforma.*;
import fundamentos.prueba.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Cine");

        String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
        String genero = ScannerUtils.capturarTexto("Genero del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = nombre;
        pelicula.fechaEstreno = LocalDate.of(2018, 10, 15);
        pelicula.genero = genero;
        pelicula.calificar(calificacion);
        pelicula.duracion = duracion;

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario usuario = new Usuario();
        usuario.nombre = "Juan";
        usuario.fechaRegistro = LocalDateTime.now();
        //usuario.fechaRegistro = localDateTime.of(2026, 06, 14, 16, 11, 0) año, mes, día, horas, minutos, segundos
        System.out.println(usuario.fechaRegistro);

        usuario.ver(pelicula);
    }
}
