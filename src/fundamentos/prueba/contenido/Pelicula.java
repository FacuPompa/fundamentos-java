package fundamentos.prueba.contenido;

import java.time.LocalDate;

public class Pelicula {
    private String titulo;
    private String descripcion;
    private int duracion;
    private String genero;
    private double calificacion;
    private boolean disponible;

    public Pelicula(String titulo, int duracion, String genero, double calificacion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.disponible = true;
    }

    public Pelicula(String titulo, int duracion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
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


    public double getCalificacion() {
        return calificacion;
    }

    public String getGenero() {
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
