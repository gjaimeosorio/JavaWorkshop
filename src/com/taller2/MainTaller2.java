package com.taller2;

import java.io.IOException;
import java.util.Scanner;
import com.taller2.Punto1.T2Punto1;
import com.taller2.Punto2.T2Punto2;
import com.taller2.Punto3.T2Punto3;
import com.taller2.Punto4.T2Punto4;
import com.taller2.Punto5.T2Punto5;
import com.taller2.Punto6.T2Punto6;
import com.taller2.Punto7.T2Punto7;
import com.taller2.Punto8.T2Punto8;
import com.taller2.Punto9.T2Punto9;

public class MainTaller2 {

    private static boolean bandera = true;
    private static int opcion;
    private static Scanner input;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws IOException {
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
        System.out.println(ANSI_GREEN + "Bienvenido al taller de condicionales, escoja un punto del taller" + ANSI_RESET);
        System.out.println("1. Punto #1");
        System.out.println("2. Punto #2");
        System.out.println("3. Punto #3");
        System.out.println("4. Punto #4");
        System.out.println("5. Punto #5");
        System.out.println("6. Punto #6");
        System.out.println("7. Punto #7");
        System.out.println("8. Punto #8");
        System.out.println("9. Punto #9");
        System.out.println("10. Punto #10");
        System.out.println("0. Salir del taller 2");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private static boolean evaluarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                T2Punto1 p1 = new T2Punto1();
                p1.ejecutarPunto1();
                return true;
            case 2:
                T2Punto2 p2 = new T2Punto2();
                p2.ejecutarPunto2();
                return true;
            case 3:
                T2Punto3 p3 = new T2Punto3();
                p3.ejecutarPunto3();
                return true;
            case 4:
                T2Punto4 p4 = new T2Punto4();
                p4.ejecutarPunto4();
                return true;
            case 5:
                T2Punto5 p5 = new T2Punto5();
                p5.ejecutarPunto5();
                return true;
            case 6:
                T2Punto6 p6 = new T2Punto6();
                p6.ejecutarPunto6();
                return true;
            case 7:
                T2Punto7 p7 = new T2Punto7();
                p7.ejecutarPunto7();
                return true;
            case 8:
                T2Punto8 p8 = new T2Punto8();
                p8.ejecutarPunto8();
                return true;
            case 9:
                T2Punto9 p9 = new T2Punto9();
                p9.ejecutarPunto9();
                return true;
            case 0:
                return false;
            default:
                System.out.println(ANSI_RED + "Opción incorrecta, favor escoja un punto del taller!" + ANSI_RESET);
        }
        return true;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}