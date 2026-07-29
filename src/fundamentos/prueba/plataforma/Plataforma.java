package fundamentos.prueba.plataforma;

import fundamentos.prueba.contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Agregación

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }

    public void agregar(Pelicula elemento) {
        this.contenido.add(elemento);
    }

    public List<String> getTitulos() {
        return contenido.stream()
                .map(Pelicula::getTitulo) //transforma la lista en otro elemento distinto
                .toList();
    }

    public void eliminar(Pelicula elemento) {
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo) {
//        for (Pelicula pelicula : contenido) {
//            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
//                return pelicula;
//            }
//        }

        return contenido.stream().filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst() //busca la primer pelicula porque no pueden existir pelis con mismo nombre
                .orElse(null);
//        return null;
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equalsIgnoreCase(genero))
                .toList();

    }

    public List<Pelicula> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getMuyPopulares() {
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() >= 8.7)
                .toList();
    }

    public Pelicula getMasLarga() {
        return contenido.stream()
                .sorted(Comparator.comparingInt(Pelicula::getDuracion).reversed())
                .findFirst()
                .orElse(null);
    }

    public Pelicula getMasCorta() {
        return contenido.stream()
                .sorted(Comparator.comparingInt(Pelicula::getDuracion))
                .findFirst()
                .orElse(null);
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(pelicula -> pelicula.getDuracion())
                .sum();
    }


}
