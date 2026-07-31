package fundamentos.prueba.contenido;

import java.time.LocalDate;

public class Contenido {
    private String titulo;
    private String descripcion;
    private int duracion;
    private Genero genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;

    public Contenido(String titulo, int duracion, Genero genero, double calificacion, LocalDate fechaEstreno) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
        this.calificacion = calificacion;
        this.disponible = true;
    }

    public Contenido(String titulo, int duracion, Genero genero, double calificacion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.calificar(calificacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) { this.fechaEstreno = fechaEstreno; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void reproducir() {
        System.out.println("Estoy reproduciendo " + titulo);
    }

    public String obtenerFichaTecnica() {
        return titulo + "\n" +
                "Género: " + genero + "\n" +
                "Calificación: " + calificacion + "/10";
    }

    public void calificar(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular(){
        return calificacion >= 9;
    }
}
