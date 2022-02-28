package com.taller1.Punto4;

import java.util.Scanner;

public class T1Punto4 {

    private String ciudadCapital;
    private String pais;
    private Scanner input;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto4() {

        input = new Scanner(System.in);

        solicitarCiudadCapital();
        ciudadCapital = capturarDatoString();

        solicitarPais();
        pais = capturarDatoString();

        mensaje(ciudadCapital, pais);
    }

    private void solicitarCiudadCapital() {
        System.out.println("Por favor digite el nombre de una ciudad capital");
    }

    private void solicitarPais() {
        System.out.println("Por favor digite el país de la ciudad capital ingresada");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private void mensaje(String ciu, String pai) {
        System.out.println(ANSI_GREEN + "La ciudad " + ciu + ", es la capital del país " + pai + ANSI_RESET);
    }
} 
