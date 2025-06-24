package Main;

import Libros.Libro;
import Usuarios.Usuario;

import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;

import Libros.LibroNoEncontradoException;

import static Utilidades.Utils.crearUsuario;


public class Main {
    static Map<String, Usuario> usuarios = new HashMap<>();
    static List<Libro> libros = new ArrayList<>();
    static Set<Usuario> usuariosMoroso = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n---- Bienvenido a la Biblioteca -----: ");
            System.out.println("1. Registar miembro en la biblioteca");
            System.out.println("2. Registrar usuario moroso");
            System.out.println("3. Ver datos de miembros activos");
            System.out.println("4. Búqueda de libros");
            System.out.println("5. Prestar libro");
            System.out.println("6. Agregar libro a la biblioteca");
            System.out.println("7. Mostrar libros");
            System.out.println("8. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarUsuario(sc);
                case 2 -> registrarUsuarioMoroso(sc);
                case 3 -> verDatosUsuario();
                case 4 -> buscarLibro(sc);
                case 5 -> prestarLibro(sc);
                case 6 -> agregarLibro(sc);
                case 7 -> mostrarLibrosOrdenados(libros);
                case 8 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 8);
        sc.close();
    }

    public static void  registrarUsuarioMoroso(Scanner sc) {
        Usuario nuevoUsuario = crearUsuario(sc);
        usuariosMoroso.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito.");
    }

        public static void registrarUsuario(Scanner sc){
            Usuario nuevoUsuario = crearUsuario(sc);
        if (usuariosMoroso.contains(nuevoUsuario)) {
            System.out.println("Usuario registra Mora histórica");
            }  else {
                usuarios.put(nuevoUsuario.getRut(), nuevoUsuario);
                System.out.println("Usuario registrado con éxito.");
            }
        }

        public static void verDatosUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : usuarios.values()) {
                usuario.mostrarInformacionUsuario();
                System.out.println("------------------------");
            }
        }
        }
        public static void buscarLibro(Scanner sc){
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
                System.out.println("Error: "+ e.getMessage());
            }
        }
        public static void prestarLibro(Scanner sc) {
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
        public static void agregarLibro(Scanner sc){
            System.out.println("Ingrese el titulo del libro: ");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el autor del libro: ");
            String autor = sc.nextLine();
            Libro nuevoLibro = new Libro(titulo, autor);
            libros.add(nuevoLibro);
            System.out.println("Libro agregado con éxito.");
        }

    public static void mostrarLibrosOrdenados(Collection<Libro> libros) {
        Set<Libro> librosOrdenados = new TreeSet<>(Comparator.comparing(Libro::getTitulo));
        librosOrdenados.addAll(libros);
        for (Libro libro : librosOrdenados) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor());
        }
    }
}