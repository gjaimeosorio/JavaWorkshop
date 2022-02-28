package com.taller2.Punto4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2Punto4 {

    private String nombre;
    private boolean bandera = true;
    private int opcion;
    private Scanner input;
    private static Videotienda VT = new Videotienda();
    private Map<Integer, String> map = new HashMap<Integer, String>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto4() throws IOException {    
        do {
            try {
                menu();
                opcion = capturarOpcion();
                limpiarPantalla();
                bandera = evaluarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (bandera == true);

    }

    private static void menu() {
        System.out.println(ANSI_GREEN + "Bienvenido a la videotienda del barrio el Porvenir, favor seleccione una opción:" + ANSI_RESET);
        System.out.println("1. Alquilar película");
        System.out.println("2. Consultar películas disponibles");
        System.out.println("3. Recibir película");
        System.out.println("0. Salir de la videotienda");
    }

    private String capturarDato() {
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private char capturarLetra() {
        input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        boolean registro;
        int opc;
        switch (opcion) {
            case 1:
                solicitarNombre();
                nombre = capturarDato();
                registro = validarUsuario(nombre);
                if (registro) {
                    opc = capturarOpcion();
                    if (opc > 0 && opc <= VT.getPeliculas().size()) {
                        System.out.println(ANSI_GREEN + "La película " + VT.getPelicula(opc-1) + " fue alquilada por " + nombre + "\n" + ANSI_RESET);
                        map.put(getUsuarioPos(nombre), VT.getPelicula(opc-1));
                        VT.delPelicula(VT.getPelicula(opc-1));
                    }
                    else
                        System.out.println(ANSI_RED + "Opción incorrecta!\n" + ANSI_RESET);
                }
                return true;
            case 2:
                listarPeliculas();
                return true;
            case 3:
                solicitarNombre();
                nombre = capturarDato();
                registro = validarAlquiler(nombre);
                if (registro) {
                    System.out.println(ANSI_GREEN + "El usuario " + nombre + " ha devuelto la película " + map.get(getUsuarioPos(nombre)) + "\n" + ANSI_RESET);
                    VT.addPelicula(map.get(getUsuarioPos(nombre)));
                } else
                    System.out.println(ANSI_RED + "El usuario " + nombre + " no tiene películas alquiladas\n" + ANSI_RESET);
                return true;
            case 0:
                VT.limpiarUsuarios();
                VT.limpiarPeliculas();
                return false;
            default:
                System.out.println(ANSI_RED + "Opción incorrecta, favor escoja un punto del taller!" + ANSI_RESET);
        }
        return true;
    }

    private void solicitarNombre() {
        System.out.println("Por favor ingrese su nombre");
    }

    private int getUsuarioPos(String user) {
        return VT.getUsuarios().indexOf(user);
    }

    private boolean validarUsuario (String nom) {
        char opc;
        System.out.println("Usuarios registrados:");
        listarUsuarios();
        if (VT.getUsuarios().contains(nom)){
            System.out.println(ANSI_GREEN + "El usuario se encuentra registrado!" + ANSI_RESET);
            listarPeliculas();
            if (VT.getPeliculas().size() == 0) {
                return false;
            } else
                return true;
        } else {
            System.out.println(ANSI_RED + "Usuario no registrado" + ANSI_RESET);
            System.out.println("Desea registrar el usuario? (S/N)");
            opc = capturarLetra();
            if (opc == 'S' || opc == 's') {
                registrarUsuario(nom);
                System.out.println(ANSI_GREEN + "El usuario ha sido registrado!\n" + ANSI_RESET);
                listarPeliculas();
                if (VT.getPeliculas().size() == 0) {
                    return false;
                } else
                    return true;
            } else {
                System.out.println(ANSI_RED + "El usuario no puede realizar ninguna operación\n" + ANSI_RESET);
                return false;
            }
        }
    }

    private boolean validarAlquiler(String nom) {
        String alquilo = map.get(getUsuarioPos(nom));
        System.out.println("Usuarios registrados:");
        listarUsuarios();
        if (alquilo == null) 
            return false;
        else
            return true;
    }

    private void registrarUsuario(String nom) {
        VT.addUsuario(nom);
        VT.getUsuarios();
    }

    private void listarUsuarios() {
        int list = 1;
        for (String user : VT.getUsuarios()) {
            System.out.println(list + ". " + user);
            list++;
        }
    }
    
    private void listarPeliculas() {
        int list = 1;
        System.out.println(ANSI_GREEN + "Lista de películas:" + ANSI_RESET);
        for (String peli : VT.getPeliculas()) {
            System.out.println(list + ". " + peli);
            list++;
        }
        if (VT.getPeliculas().size() == 0)
            System.out.println(ANSI_RED + "No hay películas disponibles para alquilar!\n" + ANSI_RESET);
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

} 