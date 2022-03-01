package com.taller2.Punto8;

import java.io.IOException;
import java.util.Scanner;

public class T2Punto8 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int ventas = 0;
    private static int opcion;
    private static Torta torta = new Torta();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto8() throws IOException {
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
        System.out.println(ANSI_GREEN + "Bienvenido a la pastelería de don Carlos, favor seleccione una opción:" + ANSI_RESET);
		System.out.println("1. Registrar pedido");
		System.out.println("2. Ver tortas disponibles");
        System.out.println("3. Mostrar las ventas del día");
        System.out.println("0. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String sabor, decoracion;
        int porcion;
        switch (opcion) {
            case 1:
                solicitarSabor();
                sabor = capturarDatoString();
                solicitarPorciones();
                porcion = capturarOpcion();
                solicitarDecoraciones();
                decoracion = capturarDatoString();
                torta.addTorta(sabor);
                torta.delSabor(sabor);
                ventas += torta.getPrecios().get(sabor);
                mensajeTorta(sabor, porcion, decoracion);
                return true;
            case 2:
                System.out.println(ANSI_GREEN + "Sabores disponibles: " + torta.getSabores() + ANSI_RESET);
            return true;  
            case 3:
                System.out.println(ANSI_GREEN + "Ventas totales: $" + ventas + ANSI_RESET);
                return true;  
            case 0:
                torta.limpiarTortas();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private void solicitarSabor() {
        System.out.println(ANSI_GREEN + "Sabores disponibles: " + torta.getSabores() + ANSI_RESET);
        System.out.println("Por favor ingrese el sabor de su torta:");
    }

    private void solicitarPorciones() {
        System.out.println(ANSI_GREEN + "Porciones disponibles: " + torta.getPorciones() + ANSI_RESET);
        System.out.println("Por favor ingrese la cantidad de porciones para su torta:");
    }

    private void solicitarDecoraciones() {
        System.out.println(ANSI_GREEN + "Decoraciones disponibles: " + torta.getDecoraciones() + ANSI_RESET);
        System.out.println("Por favor ingrese la decoración de su torta");
    }

    private String capturarDatoString() {
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private void mensajeTorta(String sabor, int porcion, String decoracion) {
        System.out.println(ANSI_GREEN + "La torta adquirida fue de sabor " + sabor + ", número de porciones " + porcion + " y decoración " + decoracion + ANSI_RESET);
        System.out.println(ANSI_RED + "La torta tiene un costo de " + torta.getPrecios().get(sabor) + ANSI_RED);
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}