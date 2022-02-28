package com.taller3.Punto4;

import java.io.IOException;
import java.util.Scanner;

public class T3Punto4 {

    private static Scanner input;
    private static boolean repetir;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto4() throws IOException {
        do {    
            try {
                input = new Scanner(System.in);
                int opcion = menu();
                tabla(opcion);
                repetir = evaluarOpcion();
                limpiarPantalla();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (repetir);    
    }

    public int menu () {
        System.out.println(ANSI_GREEN + "Hola, ¿qué tabla de multiplicar desea crear?" + ANSI_RESET);
	    System.out.println("Seleccione una opción:");
        for (int i=1; i<=10; i++) {
            System.out.println(i + ". Tabla del " + i);
        }
        return capturarDatoInt();
    }

    private int capturarDatoInt() {
        return Integer.parseInt(input.nextLine()); 
    }

    private static char capturarLetra() {
        return input.next().charAt(0);
    }

    private static boolean evaluarOpcion() throws IOException {
        System.out.println(ANSI_GREEN + "Desea ver otra tabla de multiplicar? (S/N)" + ANSI_RESET);
        char opc = capturarLetra();
        if (opc == 's' || opc == 'S')
            return true;
        else
            return false;
    }

    public void tabla (int num) {
        if (num > 0 && num <= 10) {
            for (int i=1; i<=10; i++) {
                System.out.println(i + " x " + num + " = " + i * num);
            }
        } else 
            System.out.println(ANSI_RED + "Sólo puede ver las tablas de multiplicar del 1 al 10!" + ANSI_RESET);
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}