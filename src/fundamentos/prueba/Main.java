package fundamentos.prueba;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.plataforma.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Cine");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = "El señor de los anillos ";
        pelicula.fechaEstreno = LocalDate.of(2018, 10, 15);
        pelicula.genero = "Fantasia";
        pelicula.calificar(4.7);


        Usuario usuario = new Usuario();
        usuario.nombre = "Juan";
        usuario.fechaRegistro = LocalDateTime.now();
        //usuario.fechaRegistro = localDateTime.of(2026, 06, 14, 16, 11, 0) año, mes, día, horas, minutos, segundos
        System.out.println(usuario.fechaRegistro);

        usuario.ver(pelicula);

        
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("¿Cuál es tu nombre?");
//        String nombre = scanner.nextLine();
//
//        System.out.println("Hola " + nombre + ", bienvenido.");
//
//        System.out.println(nombre + ", ¿cuantos años tenés?");
//        int edad = scanner.nextInt();
//
//        System.out.println(nombre + " podes ver contenido +" + edad);
    }
}
