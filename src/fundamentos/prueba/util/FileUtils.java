package fundamentos.prueba.util;

import fundamentos.prueba.contenido.Contenido;
import fundamentos.prueba.contenido.Genero;
import fundamentos.prueba.contenido.Pelicula;
import fundamentos.prueba.contenido.Serie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "contenido.txt";
    public static final String SEPARADOR = "|";

    public static void escribirContenido(Contenido contenido) {
        String linea = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                String.valueOf(contenido.getCalificacion()),
                contenido.getFechaEstreno().toString()
        );

        String lineaFinal;

        if (contenido instanceof Serie serie) {
            lineaFinal = "SERIE" + SEPARADOR + linea + SEPARADOR + serie.getTemporadas();
        } else {
            lineaFinal = "PELICULA" + SEPARADOR + linea;
        }

        try {
            Files.writeString(Paths.get(NOMBRE_ARCHIVO),
                    lineaFinal + System.lineSeparator(), //hace un salto de linea (\n)
                    StandardOpenOption.CREATE, //crea el archivo si no existe
                    StandardOpenOption.APPEND); //concatena la linea al final del archivo
        } catch (IOException e) {
            System.out.println("Error imprimiendo el archivo" + e.getMessage()); ;
        }
    }

    public static List<Contenido> leerContenido() {
        List<Contenido> contenidoDesdeArchivo = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));

            lineas.forEach(linea -> {
                String[] datos = linea.split("\\" + SEPARADOR);

                String tipoContenido = datos[0];

                if (("PELICULA".equals(tipoContenido) && datos.length == 6) ||  ("SERIE".equals(tipoContenido) && datos.length == 7)) {
                    String titulo = datos[1];
                    int duracion = Integer.parseInt(datos[2]);
                    Genero genero = Genero.valueOf(datos[3].toUpperCase());
                    double calificacion = datos[4].isBlank() ? 0 : Double.parseDouble(datos[4]); //valida si no tiene calificacion cargada
                    LocalDate fechaEstreno = LocalDate.parse(datos[5]);

                    Contenido contenido;

                    if ("PELICULA".equals(tipoContenido)) {
                        contenido = new Pelicula(titulo, duracion, genero, calificacion, fechaEstreno);
                    } else {
                        int temporadas = Integer.parseInt(datos[6]);
                        contenido = new Serie(titulo, duracion, genero, calificacion, fechaEstreno, temporadas);
                    }

                    contenido.setFechaEstreno(fechaEstreno);
                    contenidoDesdeArchivo.add(contenido);
                }

            });
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo. " + e.getMessage());
        }
        return contenidoDesdeArchivo;
    }
}
