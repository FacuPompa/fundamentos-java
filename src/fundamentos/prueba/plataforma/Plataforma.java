package fundamentos.prueba.plataforma;

import fundamentos.prueba.contenido.Genero;
import fundamentos.prueba.contenido.Pelicula;
import fundamentos.prueba.contenido.ResumenContenido;
import fundamentos.prueba.excepcion.PeliculaExistenteException;
import fundamentos.prueba.util.FileUtils;

import java.util.*;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Agregación
    private Map<Pelicula, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }

    public void agregar(Pelicula elemento) {
        Pelicula contenido = this.buscarPorTitulo(elemento.getTitulo());
        if (contenido != null) {
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        FileUtils.escribirContenido(elemento);
        this.contenido.add(elemento);
    }

    public void reproducir(Pelicula contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " + conteoActual + " veces.");

        this.contarVisualizacion(contenido);
        contenido.reproducir();
    }

    private void contarVisualizacion(Pelicula contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        visualizaciones.put(contenido, conteoActual + 1);
    }

    public List<String> getTitulos() {
        return contenido.stream()
                .map(Pelicula::getTitulo) //transforma la lista en otro elemento distinto
                .toList();
    }

    public List<ResumenContenido> getResumenes() {
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(), c.getGenero()))
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

    public List<Pelicula> buscarPorGenero(Genero genero) {
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
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
