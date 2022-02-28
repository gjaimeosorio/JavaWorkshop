package com.taller3.Punto5;

import java.io.IOException;
import java.util.Scanner;

public class T3Punto5 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto5() throws IOException {
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
	    System.out.println("Seleccione una opción:");
        System.out.println(ANSI_GREEN + "Menú de usuario" + ANSI_RESET);
		System.out.println("1. Captura nombre");
		System.out.println("2. Saludar persona");
		System.out.println("3. Salir del sistema");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private static boolean evaluarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                System.out.println(ANSI_GREEN + "Se captura un nombre\n" + ANSI_RESET);
                return true;
            case 2:
                System.out.println(ANSI_GREEN + "Se saluda la persona\n" + ANSI_RESET);
                return true;
            case 3:
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}