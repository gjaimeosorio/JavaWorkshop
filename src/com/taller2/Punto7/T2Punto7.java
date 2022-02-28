package com.taller2.Punto7;

import java.io.IOException;
import java.util.Scanner;

public class T2Punto7 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static IMC imc = new IMC();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto7() throws IOException {
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

    public void menu () {
        System.out.println(ANSI_GREEN + "Bienvenido a la Secretaría de Salud Municipal, favor seleccione una opción:" + ANSI_RESET);
		System.out.println("1. Calcular Indice de Masa Corporal");
        System.out.println("2. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String nombre;
        float peso, estatura, valImc;
        switch (opcion) {
            case 1:
                solicitarNombre();
                nombre = capturarDatoString();
                solicitarPeso();
                peso = capturarDatoFloat();
                solicitarEstatura();
                estatura = capturarDatoFloat();
                valImc = imc.calculoIMC(peso, estatura);
                mensajeSalud(nombre, valImc);
                return true;   
            case 2:
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private void solicitarNombre() {
        System.out.println("Por favor ingrese su nombre:");
    }

    private void solicitarPeso() {
        System.out.println("Por favor ingrese su peso en kilos (si usa decimal use .):");
    }

    private void solicitarEstatura() {
        System.out.println("Por favor ingrese su estatura en metros (si usa decimal use .):");
    }

    private String capturarDatoString() {
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private static float capturarDatoFloat() {
        input = new Scanner(System.in);
        return Float.parseFloat(input.nextLine()); 
    }

    private static void mensajeSalud(String nom, float imc) {
        if (imc < 18.5)
		    System.out.println(ANSI_RED + "Estimado(a) " + nom + " usted tiene bajo peso" + ANSI_RESET + "\n");
	    else if (imc < 24.9)
            System.out.println(ANSI_GREEN + "Estimado(a) " + nom + " usted tiene un peso normal" + ANSI_RESET + "\n");
		else if (imc < 29.9)
            System.out.println(ANSI_RED + "Estimado(a) " + nom + " usted tiene sobrepeso" + ANSI_RESET + "\n");
		else
            System.out.println(ANSI_RED + "Estimado(a) " + nom + " usted está obeso" + ANSI_RESET + "\n");
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}