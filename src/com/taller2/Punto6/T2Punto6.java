package com.taller2.Punto6;

import java.io.IOException;
import java.util.Scanner;

public class T2Punto6 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static TallerMotos tallerMoto = new TallerMotos();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto6() throws IOException {
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
        System.out.println(ANSI_GREEN + "Bienvenido al taller de motos 'El Maquinista', favor seleccione una opción:" + ANSI_RESET);
		System.out.println("1. Registrar nuevo servicio de cliente");
		System.out.println("2. Ver registros de clientes");
        System.out.println("3. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String cliente, observacion, fechaIn, fechaOut;
        switch (opcion) {
            case 1:
                solicitarCliente();
                cliente = capturarDatoString();
                solicitarObservacion();
                observacion = capturarDatoString();
                solicitarFechaIngreso();
                fechaIn = capturarDatoString();
                solicitarFechaSalida();
                fechaOut = capturarDatoString();
                tallerMoto.addClientes(cliente, observacion, fechaIn, fechaOut);
                inventarioRepuesto(cliente);
                return true;
            case 2:
                mostrarClientes();
                return true;    
            case 3:
                tallerMoto.limpiarClientes();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private void solicitarCliente() {
        System.out.println("Por favor ingrese el nombre del cliente:");
    }

    private void solicitarObservacion() {
        System.out.println("Por favor ingrese la observación de la moto del cliente:");
    }

    private void solicitarFechaIngreso() {
        System.out.println("Por favor ingrese la Fecha de ingreso: (dd-mm-aaaa)");
    }

    private void solicitarFechaSalida() {
        System.out.println("Por favor ingrese la Fecha de salida: (dd-mm-aaaa)");
    }

    private String capturarDatoString() {
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private static char capturarLetra() {
        input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private void inventarioRepuesto(String cliente) {
        String repuesto;
        char opc;
        System.out.println("Requiere inventariar repuestos? (S/N)");
        opc = capturarLetra();
        if (opc == 's' ||  opc == 'S') {
            System.out.println("Ingrese el repuesto:");
            repuesto = capturarDatoString();
            tallerMoto.addRepuestos(cliente, repuesto);
        }
    }

    private int getClientePos(String contact) {
        return tallerMoto.getClientes().indexOf(contact);
    }

    private void mostrarClientes () {
        int i = 1;
        System.out.println(ANSI_GREEN + "Registros de servicios:" + ANSI_RESET);
        for (String clie:tallerMoto.getClientes()) {
            int index = getClientePos(clie);
            System.out.println(i + ". Cliente: " + clie + ", observación: " + tallerMoto.getObservacionesClientes().get(index) + ", fecha de Ingreso: " + tallerMoto.getFechasIngresos().get(index) + ", fecha de Salida: " + tallerMoto.getFechasSalidas().get(index));
            i++;
        }
        System.out.println("");
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}