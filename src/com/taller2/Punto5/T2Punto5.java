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
        String keyProducto;
        switch (opcion) {
            case 1:
                listarProductos();
                keyProducto = comprarProd();
                mensajeProductoAd(keyProducto);
                return true;
            case 2:
                listarProductos();
                return true;
            case 3:
                keyProducto = productoDevolver();    
                productoExiste(keyProducto);
                return true;    
            case 4:
                drogueria.limpiarProductos();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private void mensajeDisponibilidad() {
        System.out.println(ANSI_GREEN + "Produtos disponibles:" + ANSI_RESET);
    }

    private void listarProductos() {
        int i = 1;
        mensajeDisponibilidad();
        for (String prod:drogueria.getProductos().keySet()) {
            int valor = drogueria.getProductos().get(prod);
            System.out.println(i + ". " + prod + ", costo: " + valor);
            i++;
        }
        System.out.println("");
    }

    private String comprarProd() {
        String nomProd = "";
        System.out.println(ANSI_GREEN + "Ingrese el producto que desea adquirir (1-4)" + ANSI_RESET);
        int product = capturarOpcion();
        switch (product) {
            case 1:
                nomProd = "Aspirina";
            case 2:
                nomProd = "Suero";
            case 3:
                nomProd = "Alcohol";
            case 4:
                nomProd = "Acetaminofén";
        }
        return nomProd;
    }

    private void mensajeProductoAd(String keyProd) {
        System.out.println(ANSI_GREEN + "Usted ha adquirido un " + keyProd + " por " + drogueria.getProductos().get(keyProd) + "\n"+ ANSI_RESET);
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private String productoDevolver() {
        System.out.println("Ingrese el nombre del producto que desea devolver:");
        return capturarDatoString();
    }

    private void productoExiste(String keyProd) {
        if (drogueria.getProductos().containsKey(keyProd))
            System.out.println(ANSI_GREEN + "El producto " + keyProd + " ha sido devuelto!" + ANSI_RESET + "\n");
        else
            System.out.println(ANSI_RED + "El producto " + keyProd + " no existe!" + ANSI_RESET + "\n");
    }
    
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}