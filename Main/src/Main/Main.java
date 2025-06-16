package Main;

import Libros.Libro;
import Usuarios.Usuario;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Libros.LibroNoEncontradoException;



public class Main {
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n---- Bienvenido a la Biblioteca -----: ");
            System.out.println("1. Registar miembro en la biblioteca");
            System.out.println("2. Ver datos de miembro inscrito en la biblioteca");
            System.out.println("3. Búqueda de libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Agregar libro a la biblioteca");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> verDatosUsuario();
                case 3 -> buscarLibro();
                case 4 -> prestarLibro();
                case 5 -> agregarLibro();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 6);
    }

        public static void registrarUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el rut(18.955.357-9): ");
        String rut = sc.nextLine();
        System.out.println("Ingrese el direccion: ");
        String direccion = sc.nextLine();
        Usuario nuevoUsuario = new Usuario(nombre, rut, direccion);
        usuarios.add(nuevoUsuario);

            System.out.println("Usuario registrado con éxito.");
        }
        public static void verDatosUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : usuarios) {
                usuario.mostrarInformacionUsuario();
                System.out.println("------------------------");
            }
        }
        }
        public static void buscarLibro(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el título del libro que busca: ");
            String tituloBuscado = sc.nextLine();
            try {
                Libro libroEncontrado = null;
                for (Libro libro : libros) {
                    if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                        libroEncontrado = libro;
                        break;
                    }
                }

                if (libroEncontrado == null) {
                    throw new Libros.LibroNoEncontradoException("El libro no está registrado en la biblioteca");
                }
                String estado = libroEncontrado.isDisponible() ? "Disponible" : "Prestado";
                System.out.println("Libro Encontrado");
                System.out.println("Título: " + libroEncontrado.getTitulo());
                System.out.println("Autor: " +libroEncontrado.getAutor());
                System.out.println("Estado: " + estado);
            } catch (Libros.LibroNoEncontradoException e) {
                System.out.println("❌ Error: "+ e.getMessage());
            }
        }
        public static void prestarLibro(){
           Scanner sc = new Scanner(System.in);
           System.out.println("Ingrese el título del libro a prestar: ");
           String titulo = sc.nextLine();

           try {
               Libro libroEncontrado = null;
               for (Libro libro : libros) {
                   if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                       libroEncontrado = libro;
                       break;
                   }
               }

               if (libroEncontrado == null) {
                   throw new LibroNoEncontradoException("El libro no existe en la biblioteca");
               }
               libroEncontrado.prestar();
               System.out.println("Libro prestado exitosamente");
           } catch (LibroNoEncontradoException e) {
               System.out.println("Error: "+ e.getMessage());
           } catch (Libros.LibroYaPrestadoException e) {
               System.out.println("No se puede prestar"+ e.getMessage());
           }
        }
        public static void agregarLibro(){
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese el titulo del libro: ");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el autor del libro: ");
            String autor = sc.nextLine();

            Libro nuevoLibro = new Libro(titulo, autor);
            libros.add(nuevoLibro);

            System.out.println("Libro agregado con éxito.");

        }
}