package com.taller4.Punto4;

import java.util.Scanner;

public class T4Punto4 {

    private static boolean bandera = true;
    private static Scanner input;
    private static String [][] matriz = new String[4][5];
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void ejecutarPunto4() {
        do {
            try {
                matriz = llenarMatriz();
                mostarMatrizZigZag(matriz);
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

    private String [][] llenarMatriz() {
        String [][] mat = new String[4][5];
        Integer i = 1;
        for (int fila=0; fila<=3; fila++) {
            for (int columna=0; columna<=4; columna++) {
                if (i <= 9)
                    mat[fila][columna] = "0" + i.toString(); //Se quema en el código los valores de 1 a 9 precedidos del 0.
                else
                    mat[fila][columna] = i.toString(); //Se quema en el código los valores de 10 al 25
                i++;
            }
        }
        return mat;
    }

    
    private static void mostarMatrizZigZag(String [][] mat) {
        for (int fila=0; fila<=3; fila++) { 
            if(fila % 2 == 0) {
                for (int columna=0; columna<=4; columna++) {
                    System.out.print(mat[fila][columna] + " ");
                }
            }else {
                for (int columna=4; columna>=0; columna--) {
                    System.out.print(mat[fila][columna] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static boolean repetirVector() {
        char opcion;
        System.out.println(ANSI_GREEN + "Desea regresar al menú del taller 4? (S/N)" + ANSI_RESET);
        opcion = capturarLetra();
        System.out.println("");
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