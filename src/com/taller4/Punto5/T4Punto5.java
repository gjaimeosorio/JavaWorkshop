package com.taller4.Punto5;

import java.util.Scanner;

public class T4Punto5 {

    private static boolean bandera = true;
    private static Scanner input;
    private static int [][] matrizR = new int[10][10];
    private static int fila, columna;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void ejecutarPunto5() {
        do {
            try {
                matrizR = matrizResultado();
                mostarTabla();
                solicitarFila();
                fila = capturarDatoInt();
                solicitarColumna();
                columna = capturarDatoInt();
                calcularResultado(matrizR, fila, columna);
                bandera = repetirMultiplicacion();
                limpiarPantalla();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(ANSI_RED + "El valor de la fila o columna debe estar entre 0 y 9!" + ANSI_RESET);
            }
        } while (bandera == true);
        
    }

    private static char capturarLetra() {
        input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private int [][] matrizResultado() {
        int [][] result = new int[10][10];
        for (int fila=0; fila<=9; fila++) {
            for (int columna=0; columna<=9; columna++) {
                result[fila][columna] = (fila + 1) * (columna + 1);
            }
        }
        return result;
    }

    private static void mostarTabla() {
        //*************************+IMPRESIÓN DEL CUADRO DE MULTIPLICACIÓN********************************
		String texto_filas = "FILAS";
		System.out.println("                                 Columnas");
		System.out.print("           ");
		for (int columna=0; columna<=9; columna++) 
			System.out.print(columna + "     ");
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------");
		for (int fila=0; fila<=9; fila++) {
			if (fila > 1 && fila < 7)
				System.out.print(texto_filas.charAt(fila-2)); 
			else
				System.out.print(" ");
			
			System.out.print("  " + fila + "  |");
			
			for (int columna=0; columna<=9; columna++) {
				if (fila < 9) 
					System.out.print("   " + (columna + 1) + "x" + (fila + 1));
				else
					System.out.print("  " + (columna + 1) + "x" + (fila + 1));
            }
			System.out.println("");
		}
		System.out.println("");

    }

    private static boolean repetirMultiplicacion() {
        char opcion;
        System.out.println(ANSI_GREEN + "¿Desea realizar otra multiplicación? (S/N)" + ANSI_RESET);
        opcion = capturarLetra();
        System.out.println("");
        if(opcion == 's' || opcion == 'S')
            return true;
        else
            return false;
    }

    private void calcularResultado(int [][] mat, int fil, int col) {
        System.out.println(ANSI_RED + "El resultado de la multiplicación es: " + mat[fil][col] + ANSI_RESET + "\n" );
    }

    private int capturarDatoInt() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    private void solicitarFila() {
        System.out.println(ANSI_GREEN + "Ingrese la fila de la cual desea ver el resultado:" + ANSI_RESET);
    }

    private void solicitarColumna() {
        System.out.println(ANSI_GREEN + "Ingrese la columna de la cual desea ver el resultado:" + ANSI_RESET);
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}