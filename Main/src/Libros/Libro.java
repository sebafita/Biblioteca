package Libros;

public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() throws LibroYaPrestadoException {
        if (!disponible) {
            throw new LibroYaPrestadoException("El libro ya ha sido prestado.");
        }
        disponible = false;
    }

}
