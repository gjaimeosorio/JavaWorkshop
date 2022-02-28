package com.taller1.Punto1;

import java.util.Scanner;

public class T1Punto1 {

    private String nombre;
    private String apellidos;
    private Scanner input;

    public void ejecutarPunto1() {

        solicitarNombre();
        nombre = capturarDato();

        solicitarApellido();
        apellidos = capturarDato();
        
    }

    private void solicitarNombre() {
        System.out.println("Por favor digite su nombre");
    }

    private void solicitarApellido() {
        System.out.println("Por favor digite su apellido");
    }

    private String capturarDato() {
        input = new Scanner(System.in);
        return input.nextLine();
    }
}
