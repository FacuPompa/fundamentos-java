package fundamentos.prueba.plataforma;

import fundamentos.prueba.contenido.*;
import fundamentos.prueba.excepcion.PeliculaExistenteException;
import fundamentos.prueba.util.FileUtils;

import java.util.*;

public class Plataforma {
    private String nombre;
    private List<Contenido> contenido; // Agregación
    private Map<Contenido, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Contenido> getContenido() {
        return contenido;
    }

    public void agregar(Contenido elemento) {
        Contenido contenido = this.buscarPorTitulo(elemento.getTitulo());
        if (contenido != null) {
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        FileUtils.escribirContenido(elemento);
        this.contenido.add(elemento);
    }

    public void reproducir(Contenido contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " + conteoActual + " veces.");

        this.contarVisualizacion(contenido);
        contenido.reproducir();
    }

    private void contarVisualizacion(Contenido contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        visualizaciones.put(contenido, conteoActual + 1);
    }

    public List<String> getTitulos() {
        return contenido.stream()
                .map(Contenido::getTitulo) //transforma la lista en otro elemento distinto
                .toList();
    }

    public List<ResumenContenido> getResumenes() {
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(), c.getGenero()))
                .toList();
    }

    public void eliminar(Contenido elemento) {
        this.contenido.remove(elemento);
    }

    public Contenido buscarPorTitulo(String titulo) {
//        for (Contenido pelicula : contenido) {
//            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
//                return pelicula;
//            }
//        }

        return contenido.stream().filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst() //busca la primer pelicula porque no pueden existir pelis con mismo nombre
                .orElse(null);
//        return null;
    }

    public List<Contenido> buscarPorGenero(Genero genero) {
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();

    }

    public List<Contenido> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getPeliculas() {
        return contenido.stream()
                .filter(contenido -> contenido instanceof Pelicula)
                .map(contenidoFiltrado -> (Pelicula) contenidoFiltrado)
                .toList();
    }

    public List<Serie> getSeries() {
        return contenido.stream()
                .filter(contenido -> contenido instanceof Serie)
                .map(contenidoFiltrado -> (Serie) contenidoFiltrado)
                .toList();
    }

    public List<Promocionable> getContenidoPromocionable() {
        return contenido.stream()
                .filter(contenido -> contenido instanceof Promocionable)
                .map(contenidoProm -> (Promocionable) contenidoProm)
                .toList();

    }

    public List<Contenido> getMuyPopulares() {
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() >= 8.7)
                .toList();
    }

    public Contenido getMasLarga() {
        return contenido.stream()
                .sorted(Comparator.comparingInt(Contenido::getDuracion).reversed())
                .findFirst()
                .orElse(null);
    }

    public Contenido getMasCorta() {
        return contenido.stream()
                .sorted(Comparator.comparingInt(Contenido::getDuracion))
                .findFirst()
                .orElse(null);
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(pelicula -> pelicula.getDuracion())
                .sum();
    }


}
