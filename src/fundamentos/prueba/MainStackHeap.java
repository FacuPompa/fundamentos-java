package fundamentos.prueba;

import fundamentos.prueba.contenido.Pelicula;

public class MainStackHeap {
    public static void main(String[] args) {
        Pelicula reyLeon = new Pelicula("El rey León", 135, "Animada");
        Pelicula harryPotter = new Pelicula("Harry Potter", 200, "Fantasia");

        reyLeon = harryPotter;

        System.out.println(reyLeon.titulo);
        System.out.println(harryPotter.titulo);

    }
}
