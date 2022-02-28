package com.taller2.Punto3;

import java.util.Scanner;

public class T2Punto3 {

    private String nombre;
    private String apellidos;
    private int edad;
    private Scanner input;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto3() {

        input = new Scanner(System.in);
        solicitarNombre();
        nombre = capturarDatoString();
        solicitarApellidos();
        apellidos = capturarDatoString();
        solicitarEdad();
        edad = capturarDatoInt();
        mensaje(nombre, apellidos, edad);
    }

    private void solicitarNombre() {
        System.out.println("Por favor ingrese su nombre");
    }

    private void solicitarApellidos() {
        System.out.println("Por favor ingrese sus apellidos");
    }

    private void solicitarEdad() {
        System.out.println("Por favor ingrese su edad");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private int capturarDatoInt() {
        return Integer.parseInt(input.nextLine());
    }

    private void mensaje(String nom, String apell, int ed) {
        if (ed >= 18)
            System.out.println(ANSI_GREEN + nom + " " + apell + " usted es mayor de edad, por lo tanto puede entrar a la fiesta.\n" + ANSI_RESET);
        else
            System.out.println(ANSI_GREEN + nom + " " + apell + " usted es menor de edad, por lo tanto, no puede entrar a la fiesta, por favor devuélvase a su casa.\n" + ANSI_RESET);
    }

} 