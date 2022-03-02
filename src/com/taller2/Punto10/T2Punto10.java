package com.taller2.Punto10;

import java.io.IOException;
import java.util.Scanner;

public class T2Punto10 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static Cuenta cuenta = new Cuenta();
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto10() throws IOException {
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
		System.out.println("1. Realizar ingreso a la cuenta");
        System.out.println("2. Realizar consulta de saldo");
        System.out.println("3. Realizar retiro de la cuenta");
        System.out.println("0. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String cliente;
        int saldo;
        switch (opcion) {
            case 1:
                do {
                    solicitarCliente();
                    cliente = new Scanner(System.in).nextLine();
                    if (validarCliente(cliente))
                        break;
                    else {
                        System.out.println(ANSI_RED + "El cliente no se encuentra registrado!!!" + ANSI_RESET );
                        System.out.println(ANSI_GREEN + "Usuarios registrados: " + cuenta.getClientes() + ANSI_RESET);
                    }
                } while (!validarCliente(cliente));
                do {
                    solicitarCantidad();
                    saldo = capturarDatoInt();
                } while (saldo < 0);
                ingreso(cliente, saldo);
                System.out.println(ANSI_GREEN + "El nuevo saldo es de $" + (cuenta.getSaldos().get(getClientePos(cliente)) + saldo) + ANSI_RESET + "\n");
                return true;
            case 2:
                do {
                    solicitarCliente();
                    cliente = new Scanner(System.in).nextLine();
                    if (validarCliente(cliente))
                        break;
                    else {
                        System.out.println(ANSI_RED + "El cliente no se encuentra registrado!!!" + ANSI_RESET );
                        System.out.println(ANSI_GREEN + "Usuarios registrados: " + cuenta.getClientes() + ANSI_RESET);
                    }
                } while (!validarCliente(cliente));
                System.out.println(ANSI_GREEN + "Su saldo es de $" + cuenta.getSaldos().get(getClientePos(cliente)) + ANSI_RESET + "\n");
                return true;
            case 3:
                do {
                    solicitarCliente();
                    cliente = new Scanner(System.in).nextLine();
                    if (validarCliente(cliente))
                        break;
                    else {
                        System.out.println(ANSI_RED + "El cliente no se encuentra registrado!!!" + ANSI_RESET );
                        System.out.println(ANSI_GREEN + "Usuarios registrados: " + cuenta.getClientes() + ANSI_RESET);
                    }
                } while (!validarCliente(cliente));
                do {
                    solicitarCantidad();
                    saldo = capturarDatoInt();
                    if (saldo < 0 || saldo > cuenta.getSaldos().get(getClientePos(cliente)))
                        System.out.println(ANSI_RED + "El valor ingresado es negativo o supera el monto actual de $" + cuenta.getSaldos().get(getClientePos(cliente)) + ANSI_RESET); 
                } while (saldo < 0 || saldo > cuenta.getSaldos().get(getClientePos(cliente)));
                System.out.println(ANSI_GREEN + "El nuevo saldo es de $" + (cuenta.getSaldos().get(getClientePos(cliente)) - saldo) + ANSI_RESET + "\n");
                return true;     
            case 0:
                cuenta.limpiarClientes();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private void solicitarCliente() {
        System.out.println("Por favor ingrese el nombre de usuario del cliente:");
    }

    private void solicitarCantidad() {
        System.out.println("Por favor ingrese la cantidad:");
    }

    private int getClientePos(String contact) {
        return cuenta.getClientes().indexOf(contact);
    }

    private static Integer capturarDatoInt() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean validarCliente(String cliente) {
        if (cuenta.getClientes().contains(cliente)) 
            return true;
        else
            return false;
    }

    private void ingreso(String cliente, int abono) {
        cuenta.getSaldos().set(getClientePos(cliente), cuenta.getSaldos().get(getClientePos(cliente)) + abono);
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}