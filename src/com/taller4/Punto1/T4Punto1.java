package com.taller4.Punto1;

import java.util.ArrayList;
import java.util.Scanner;

public class T4Punto1 {

    private static boolean bandera = true;
    private static Scanner input;
    private static ArrayList<Integer> vector = new ArrayList<Integer>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void ejecutarPunto1() {
        do {
            try {
                llenarVector();
                limpiarPantalla();
                mostrarVector();
                bandera = repetirVector();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (bandera == true);
        
    }

    private int capturarDatoInt() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    private static char capturarLetra() {
        input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private ArrayList<Integer> llenarVector() {
        int dato;
        System.out.println(ANSI_GREEN + "Favor ingresar 5 datos tipo entero:" + ANSI_RESET);	
	    for (int i=0; i<=4; i++) {
            System.out.println("El número entero será almacenado en la posición " + i + ":"); //Indico al usuario en qué posición del vector va a quedar su  número.
            dato = capturarDatoInt();
            vector.add(dato);
        }
        return vector;
    }

    private void mostrarVector() {
        for (int i=0; i<=4; i++) {
		    System.out.println("[" + i + "] = " + vector.get(i));
        }
        System.out.println("");;
    }

    private static boolean repetirVector() {
        char opcion;
        System.out.println("Desea ingresar un nuevo vector? (S/N)");
        opcion = capturarLetra();
        System.out.println("");
        if(opcion == 's' || opcion == 'S')
            return true;
        else
            return false;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}