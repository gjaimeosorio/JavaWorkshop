package com.taller3.Punto7;

import java.io.IOException;
import java.util.Scanner;

public class T3Punto7 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static Vehiculo vehiculo = new Vehiculo();
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
        System.out.println(ANSI_GREEN + "Bienvenido al parqueadoero 'El guardián', es un placer atenderlo esta noche!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*** Menú de usuario ***" + ANSI_RESET);
		System.out.println("1. Ingresar vehículo al parqueadero");
		System.out.println("2. Consultar si el vehículo se encuentra en el parqueadero");
		System.out.println("3. Retirar vehículo del parqueadero");
        System.out.println("4. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String cliente, telefono, placa, marca;
        switch (opcion) {
            case 1:
                if (validarMaxVehiculos()) {              
                    solicitarCliente();
                    cliente = capturarDatoString();
                    solicitarTelefono();
                    telefono = capturarDatoString();
                    solicitarPlaca();
                    placa = capturarDatoString();
                    solicitarMarca();
                    marca = capturarDatoString();
                    vehiculo.addVehiculo(placa, marca, cliente, telefono);
                }
                return true;
            case 2:
                solicitarPlaca();
                placa = capturarDatoString();
                buscarPlaca(placa);
                return true;
            case 3:
                solicitarPlaca();
                placa = capturarDatoString();    
                eliminarVehiculo(placa);
                return true;    
            case 4:
                vehiculo.limpiarVehiculos();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private boolean validarMaxVehiculos() {
        if (vehiculo.getPlacas().size() == 5) {
            System.out.println(ANSI_RED + "No puede registrar más de cinco vehículos en el parqueadero!\n" + ANSI_RESET);
            return false;
        }else
            return true;
    }

    private void solicitarCliente() {
        System.out.println("Por favor ingrese el nombre del cliente:");
    }

    private void solicitarTelefono() {
        System.out.println("Por favor ingrese el teléfono del cliente:");
    }

    private void solicitarPlaca() {
        System.out.println("Por favor ingrese la placa del vehículo (XXX###):");
    }

    private void solicitarMarca() {
        System.out.println("Por favor ingrese la marca del vehículo:");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private int getPlacaPos(String placa) {
        return vehiculo.getPlacas().indexOf(placa);
    }

    private void buscarPlaca(String placa) {
        if (vehiculo.getPlacas().contains(placa)) {
            System.out.println(ANSI_GREEN + "El vehículo con placa " + placa + " se encuentra en el parqueadero!" + ANSI_RESET);
            System.out.println("Nombre del cliente: " + vehiculo.getClientes().get(getPlacaPos(placa)));
            System.out.println("Teléfono del cliente: " + vehiculo.getTelefonos().get(getPlacaPos(placa)));
            System.out.println("Marca del vehículo: " + vehiculo.getMarcas().get(getPlacaPos(placa)) + "\n");
        }else {
            System.out.println(ANSI_RED + "El vehículo no se encuentra en el parqueadero!" + ANSI_RESET);
            if (vehiculo.getPlacas().size() > 0) {
                System.out.println(ANSI_GREEN + "Vehículos en el parqueadero:" + ANSI_RESET);
                System.out.println(vehiculo.getPlacas() + "\n");
            }else
                System.out.println(ANSI_RED + "No hay vehículos en el parqueadero!" + ANSI_RESET);
        }
    }

    private void eliminarVehiculo(String placa) {
        String mar, cli, tel;
        if (vehiculo.getPlacas().contains(placa)) {
            System.out.println(ANSI_GREEN + "El vehiculo con placa " + placa + " fue retirado del parqueadero!\n" + ANSI_RESET);
            mar = vehiculo.getMarcas().get(getPlacaPos(placa));
            cli = vehiculo.getClientes().get(getPlacaPos(placa));
            tel = vehiculo.getTelefonos().get(getPlacaPos(placa));
            vehiculo.delVehiculo(placa, mar, cli, tel);
        }else
            System.out.println(ANSI_RED + "El vehículo no se encuentra en el parqueadero!" + ANSI_RESET);
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}