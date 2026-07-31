package fundamentos.prueba.plataforma;

import fundamentos.prueba.contenido.Contenido;

import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public LocalDateTime fechaRegistro;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = LocalDateTime.now();
    }

    public void ver(Contenido contenido) {
        System.out.println(nombre + " Está viendo: ");
        contenido.reproducir();
    }
}
