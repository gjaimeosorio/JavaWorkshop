package com.taller2.Punto5;

import java.io.IOException;
import java.util.Scanner;

public class T2Punto5 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static Drogueria drogueria = new Drogueria();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto5() throws IOException {
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
        System.out.println(ANSI_GREEN + "Bienvenido a la 'Droguería Mi Salud', favor seleccione una opción:" + ANSI_RESET);
		System.out.println("1. Comprar producto");
		System.out.println("2. Consulta de precios por producto");
		System.out.println("3. Devolver producto");
        System.out.println("4. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                comprarProducto();
                return true;
            case 2:
                
                return true;
            case 3:
                
                return true;    
            case 4:
                drogueria.limpiarProductos();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private void mensajeDisponibilidad() {
        System.out.println(ANSI_GREEN + "Produtos disponibles:" + ANSI_RESET);
    }

    private void comprarProducto() {
        String prod;
        mensajeDisponibilidad();
        System.out.println(ANSI_GREEN + drogueria.getProductos() + ANSI_RESET + "\n");
        
        System.out.println(ANSI_GREEN + "Ingrese el producto que desea adquirir" + ANSI_RESET);
        prod = capturarDatoString();
        if (drogueria.getProductos().containsKey(prod)) 
            System.out.println("El producto existe");
    }

    private void buscarContacto(String contact) {
        
    }

    private void getUsuarioPos(String contact) {
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}