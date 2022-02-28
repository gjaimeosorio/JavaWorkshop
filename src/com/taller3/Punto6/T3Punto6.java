package com.taller3.Punto6;

import java.io.IOException;
import java.util.Scanner;

public class T3Punto6 {

    private static Scanner input;
    private static boolean bandera = true;
    private static int opcion;
    private static Contacto contacto = new Contacto();
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
        System.out.println(ANSI_GREEN + "Bienvenido a la aplicación prototipo que permite almacenar contactos telefónicos" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*** Menú de usuario ***" + ANSI_RESET);
		System.out.println("1. Añadir contacto");
		System.out.println("2. Buscar contacto");
		System.out.println("3. Eliminar contacto");
        System.out.println("4. Salir de la aplicación");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine()); 
    }

    private boolean evaluarOpcion(int opcion) throws IOException {
        String nombre, telefono, organizacion;
        boolean telefonoValido;
        switch (opcion) {
            case 1:
                if (validarMaxUsuarios()) {              
                    solicitarUsuario();
                    nombre = capturarDatoString();
                    solicitarTelefono();
                    telefono = capturarDatoString();
                    do {
                        if(telefonoExiste(telefono)) {
                            System.out.println(ANSI_RED + "El teléfono ya existe en la base de datos" + ANSI_RESET);
                            telefonoValido = true;
                            solicitarTelefono();
                            telefono = capturarDatoString();
                        } else {
                            solicitarOrganizacion();
                            organizacion = capturarDatoString();
                            contacto.addUsuario(nombre, telefono, organizacion);
                            telefonoValido = false;
                        }
                    } while(telefonoValido);
                }
                return true;
            case 2:
                solicitarUsuario();
                nombre = capturarDatoString();
                buscarContacto(nombre);
                return true;
            case 3:
                solicitarUsuario();
                nombre = capturarDatoString();    
                eliminarContacto(nombre);
                return true;    
            case 4:
                contacto.limpiarContactos();
                return false;
            default:
            System.out.println(ANSI_RED + "Opción incorrecta, favor seleccione una opción del menú!" + ANSI_RESET);
            return true;
        }
    }

    private boolean validarMaxUsuarios() {
        if (contacto.getUsuarios().size() == 3) {
            System.out.println(ANSI_RED + "No puede registrar más de tres usuarios!\n" + ANSI_RESET);
            return false;
        }else
            return true;
    }

    private void solicitarUsuario() {
        System.out.println("Por favor ingrese el nombre del usuario:");
    }

    private void solicitarTelefono() {
        System.out.println("Por favor ingrese el teléfono del usuario:");
    }

    private void solicitarOrganizacion() {
        System.out.println("Por favor ingrese la organización del usuario:");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private void buscarContacto(String contact) {
        if (contacto.getUsuarios().contains(contact)) {
            System.out.println(ANSI_GREEN + "El contacto está registrado!" + ANSI_RESET);
            System.out.println("Nombre del usuario: " + contacto.getUsuarios().get(getUsuarioPos(contact)));
            System.out.println("Teléfono del usuario: " + contacto.getTelefonos().get(getUsuarioPos(contact)));
            System.out.println("Organización del usuario: " + contacto.getOrganizaciones().get(getUsuarioPos(contact)) + "\n");
        }else
            System.out.println(ANSI_RED + "El contacto no existe!\n" + ANSI_RESET);
    }

    private void eliminarContacto(String contact) {
        String tel, org;
        if (contacto.getUsuarios().contains(contact)) {
            System.out.println(ANSI_GREEN + "El contacto " + contact + " fue eliminado!\n" + ANSI_RESET);
            tel = contacto.getTelefonos().get(getUsuarioPos(contact));
            org = contacto.getOrganizaciones().get(getUsuarioPos(contact));
            contacto.delUsuario(contact, tel, org);
        }else
            System.out.println(ANSI_RED + "El contacto no existe!\n" + ANSI_RESET);
    }

    private int getUsuarioPos(String contact) {
        return contacto.getUsuarios().indexOf(contact);
    }

    private boolean telefonoExiste(String tel) {
        for(String telefono :contacto.getTelefonos()) {
            if(telefono.equals(tel))
                return true;
          }        
        return false;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}