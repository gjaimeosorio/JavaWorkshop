package com.taller2.Punto1;

import java.util.Scanner;

public class T2Punto1 {

    private int edad;
    private Scanner input;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto1() {

        input = new Scanner(System.in);

        solicitarEdad();
        edad = capturarDatoInt();

        evaluarEdad(edad);
    }

    private void solicitarEdad() {
        System.out.println("Por favor ingrese su edad");
    }

    private int capturarDatoInt() {
        return Integer.parseInt(input.nextLine());
    }

    private void evaluarEdad(int ed) {
        if (ed >= 18)
            System.out.println(ANSI_GREEN +"Usted es mayor de edad.\n" + ANSI_RESET);
    }

} 