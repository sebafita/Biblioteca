package Usuarios;

import Interface.InfoUsuario;

public class Usuario implements InfoUsuario {
    private String nombre;
    private String rut;
    private String direccion;

    public Usuario(String nombre, String rut, String direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRut() {
        return rut;
    }
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Rut: " + rut);
        System.out.println("Direccion: " + direccion);
    }

}
