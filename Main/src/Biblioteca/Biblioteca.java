package Biblioteca;

import Libros.Libro;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.HashMap;


public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;


    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }




    }

