package com.taller4.Punto3;

import java.util.ArrayList;
import java.util.Scanner;

public class T4Punto3 {

    private static boolean bandera = true;
    private static Scanner input;
    private static ArrayList<Integer> vectorPrimo = new ArrayList<Integer>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void ejecutarPunto3() {
        do {
            try {
                vectorPrimo = vectPrimo();
                mostarVector(vectorPrimo);
                bandera = repetirVector();
                limpiarPantalla();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (bandera == true);
        
    }

    private static char capturarLetra() {
        input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private ArrayList<Integer> vectPrimo() {
        ArrayList<Integer> vec = new ArrayList<Integer>();
        boolean valPrimo;
	    vec.add(2); //El 2 es primo
        for (int num=3; num<=1000; num++) {
            if (num % 2 != 0) {
                valPrimo = true;
                for (int j=3; j<=num-1; j++) {
                    if (num % j == 0) {
						valPrimo = false; //Si encuentro más divisores del número actual, el número NO es primo.
                        break;
                    }
                }
                if (valPrimo == true) 
                    vec.add(num); //Si no encuentro más divisores del número actual, el número es primo.
            }
        }
        return vec;
    }

    private static void mostarVector(ArrayList<Integer> vec) {
        System.out.println(ANSI_GREEN + "Números primos del 1 al 1000:" + ANSI_RESET);
	    for (int i=0; i<=vec.size()-1; i++) {
		    System.out.print(vec.get(i) + ", "); //Todos los numeros primos del 1 al 1000 fueron guardados en el vector v_primo
        }
        System.out.println("\n");
    }

    private static boolean repetirVector() {
        char opcion;
        System.out.println(ANSI_GREEN + "Desea regresar al menú del taller 4? (S/N)" + ANSI_RESET);
        opcion = capturarLetra();
        System.out.println("");
        vectorPrimo.clear();
        if(opcion == 'n' || opcion == 'N')
            return true;
        else
            return false;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}