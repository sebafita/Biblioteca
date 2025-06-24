package Utilidades;

import Usuarios.Usuario;

import java.util.Scanner;

public class Utils {


    public static Usuario  crearUsuario (Scanner sc) {
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el rut(18.955.357-9): ");
        String rut = sc.nextLine();
        System.out.println("Ingrese el direccion: ");
        String direccion = sc.nextLine();
        Usuario nuevoUsuario = new Usuario(nombre, rut, direccion);
        System.out.println("Usuario registrado con éxito.");
        return nuevoUsuario;
    }
}
