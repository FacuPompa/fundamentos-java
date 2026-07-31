package fundamentos.prueba.contenido;

import java.time.LocalDate;

public class Pelicula extends Contenido{

    public Pelicula(String titulo, int duracion, Genero genero, double calificacion, LocalDate fechaEstreno) {
        super(titulo, duracion, genero, calificacion, fechaEstreno);
    }

    public Pelicula(String titulo, int duracion, Genero genero, double calificacion) {
        super(titulo, duracion, genero, calificacion);
    }
}
