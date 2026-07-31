package fundamentos.prueba.contenido;

import java.time.LocalDate;

public class Serie extends Contenido{
    private int temporadas;

    public Serie(String titulo, int duracion, Genero genero, double calificacion) {
        super(titulo, duracion, genero, calificacion);
    }

    public Serie(String titulo, int duracion, Genero genero, double calificacion, LocalDate fechaEstreno, int  temporadas) {
        super(titulo, duracion, genero, calificacion, fechaEstreno);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }
}
