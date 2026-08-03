package fundamentos.prueba.contenido;

import java.time.LocalDate;

public class Pelicula extends Contenido{

    public Pelicula(String titulo, int duracion, Genero genero, double calificacion, LocalDate fechaEstreno) {
        super(titulo, duracion, genero, calificacion, fechaEstreno);
    }

    public Pelicula(String titulo, int duracion, Genero genero, double calificacion) {
        super(titulo, duracion, genero, calificacion);
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo la pelicula " + this.getTitulo());
    }

    public String obtenerFichaTecnica() {
        return this.getTitulo() + "\n" + this.getDuracion() + "\n" + this.getGenero() + "\n" + this.getCalificacion() + "/10 \n";
    }
}
