package com.taller1.Punto3;

import java.util.Scanner;

public class T1Punto3 {

    private String nombre;
    private String apellidos;
    private String nombrePadre;
    private String nombreMadre;
    private Scanner input;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto3() {

        input = new Scanner(System.in);

        solicitarNombre();
        nombre = capturarDatoString();

        solicitarApellido();
        apellidos = capturarDatoString();

        solicitarPadre();
        nombrePadre = capturarDatoString();

        solicitarMadre();
        nombreMadre = capturarDatoString();

        mensaje(nombre, apellidos, nombrePadre, nombreMadre);
    }

    private void solicitarNombre() {
        System.out.println("Por favor digite su nombre");
    }

    private void solicitarApellido() {
        System.out.println("Por favor digite su apellido");
    }

    private void solicitarPadre() {
        System.out.println("Por favor digite el nombre de su padre");
    }

    private void solicitarMadre() {
        System.out.println("Por favor digite el nombre de su madre");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private void mensaje(String nom, String apell, String padre, String madre) {
        System.out.println(ANSI_GREEN +"Yo " + nom + " " + apell + ", soy hijo de " + madre + " y " + padre + ANSI_RESET);
    }

} 