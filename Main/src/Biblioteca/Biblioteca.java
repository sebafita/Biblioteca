package Biblioteca;

import Libros.Libro;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;
    private HashSet<String> librosDisponible;
    private TreeSet<String> usuariosSet;


    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.librosDisponible = new HashSet<>();
        this.usuariosSet = new TreeSet<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }




    }

