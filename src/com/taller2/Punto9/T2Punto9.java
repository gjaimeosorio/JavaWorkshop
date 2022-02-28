package com.taller2.Punto9;

import java.io.IOException;
import java.util.Scanner;

public class T2Punto9 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static Rectangulo rectangulo = new Rectangulo();
    private static Triangulo triangulo = new Triangulo();
    private static Circulo circulo = new Circulo();
    private static CalcularArea calArea = new CalcularArea();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto9() throws IOException {
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
        System.out.println(ANSI_GREEN + "Bienvenido estudiante, este programa le permite realizar la tarea más rápida y sencilla, por favor seleccione una opción:" + ANSI_RESET);
		System.out.println("1. Calcular área de un rectángulo");
        System.out.println("2. Calcular área de un triángulo");
        System.out.println("3. Calcular área de un circulo");
        System.out.println("0. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        float largo, ancho, radio;
        switch (opcion) {
            case 1:
                solicitarLargo();
                largo = capturarDatoFloat();
                rectangulo.setLargo(largo);
                solicitarAncho();
                ancho = capturarDatoFloat();
                rectangulo.setAncho(ancho);
                mostrarResultado(calArea.calculaArea(rectangulo), rectangulo);
                return true;
            case 2:
                solicitarLargo();
                largo = capturarDatoFloat();
                triangulo.setLargo(largo);
                solicitarAncho();
                ancho = capturarDatoFloat();
                triangulo.setAncho(ancho);
                mostrarResultado(calArea.calculaArea(triangulo), triangulo);
                return true;
            case 3:
                solicitarRadio();
                radio = capturarDatoFloat();
                circulo.setRadio(radio);
                mostrarResultado(calArea.calculaArea(circulo), circulo);
                return true;   
            case 0:
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private void solicitarLargo() {
        System.out.println("Por favor ingrese el largo:");
    }

    private void solicitarAncho() {
        System.out.println("Por favor ingrese el ancho:");
    }

    private void solicitarRadio() {
        System.out.println("Por favor ingrese el radio:");
    }

    private static float capturarDatoFloat() {
        input = new Scanner(System.in);
        return Float.parseFloat(input.nextLine()); 
    }

    private void mostrarResultado(float area, Forma forma) {
        System.out.println(ANSI_GREEN + "El área del " + forma.getClass().getSimpleName() + " es " + area + " Unidades^2" + ANSI_RESET + "\n");
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}