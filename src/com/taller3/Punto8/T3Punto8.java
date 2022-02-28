package com.taller3.Punto8;

import java.io.IOException;
import java.util.Scanner;

public class T3Punto8 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static Curso curso = new Curso();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto8() throws IOException {
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

    public void menu () {
        System.out.println(ANSI_GREEN + "Bienvenido a la escuela automovilística 'El Maestro', es un placer atenderlo el día de hoy!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*** Menú de usuario ***" + ANSI_RESET);
		System.out.println("1. Registrar su ingreso al curso");
		System.out.println("2. Consultar usuarios que hayan presentado el curso");
        System.out.println("3. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String usuario, prueba;
        switch (opcion) {
            case 1:
                if (validarMaxUsuarios()) {              
                    solicitarusuario();
                    usuario = capturarDatoString();
                    solicitarPrueba();
                    prueba = capturarDatoString();
                    curso.addUsuario(usuario, prueba);
                }
                return true;
            case 2:
                solicitarusuario();
                usuario = capturarDatoString();
                buscarUsuario(usuario);
                return true;    
            case 3:
                curso.limpiarUsuarios();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private boolean validarMaxUsuarios() {
        if (curso.getusuarios().size() == 8) {
            System.out.println(ANSI_RED + "No puede registrar más de ocho usuarios en el curso de enseñanza automovilística!\n" + ANSI_RESET);
            return false;
        }else
            return true;
    }

    private void solicitarusuario() {
        System.out.println("Por favor ingrese el nombre del usuario que desea tomar el curso de enseñanza automovilística:");
    }

    private void solicitarPrueba() {
        System.out.println("Por favor ingrese el resultado de la prueba de enseñanza automovilística:");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private int getUsuarioPos(String usuario) {
        return curso.getusuarios().indexOf(usuario);
    }

    private void buscarUsuario(String usuario) {
        if (curso.getusuarios().contains(usuario)) {
            System.out.println(ANSI_GREEN + "El usuario " + usuario + " se encuentra registrado en el curso de enseñanza automovilística!" + ANSI_RESET);
            System.out.println("Resultado de la prueba: " + curso.getPruebas().get(getUsuarioPos(usuario)) + "\n");
        }else {
            System.out.println(ANSI_RED + "El usuario " + usuario + " no se encuentra registrado en el curso de enseñanza automovilística!" + ANSI_RESET);
            if (curso.getusuarios().size() > 0) {
                System.out.println(ANSI_GREEN + "Usuarios registrados:" + ANSI_RESET);
                System.out.println(curso.getusuarios() + "\n");
            }else
                System.out.println(ANSI_RED + "No hay usuarios registrados en el curso de enseñanza automovilística" + ANSI_RESET);
        }
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}