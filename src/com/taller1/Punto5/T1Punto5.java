package com.taller1.Punto5;

import java.util.Scanner;

public class T1Punto5 {

    private String nombreMascota;
    private int edadMascota;
    private String tipoMascota;
    private String nombreDuenho;
    private Scanner input;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ejecutarPunto5() {

        input = new Scanner(System.in);

        solicitarNombreMascota();
        nombreMascota = capturarDatoString();

        solicitarEdadMascota();
        edadMascota = capturarDatoInt();

        solicitarTipoMascota();
        tipoMascota = capturarDatoString();

        solicitarNombreDuenho();
        nombreDuenho = capturarDatoString();

        mensaje(nombreMascota, edadMascota, tipoMascota, nombreDuenho);
    }

    private void solicitarNombreMascota() {
        System.out.println("Por favor digite el nombre de su mascota");
    }

    private void solicitarEdadMascota() {
        System.out.println("Por favor digite la edad de su mascota");
    }

    private void solicitarTipoMascota() {
        System.out.println("Por favor digite el tipo de mascota");
    }

    private void solicitarNombreDuenho() {
        System.out.println("Por favor digite su nombre completo");
    }

    private String capturarDatoString() {
        return input.nextLine();
    }

    private int capturarDatoInt() {
        return Integer.parseInt(input.nextLine()); 
    }

    private void mensaje(String nm, int em, String tm, String nd) {
        System.out.println(ANSI_GREEN + nm + " es un(a) " + tm + ", el cual, tiene " + em + " años de edad y " + nd + " es actualmente su dueño(a)." + ANSI_RESET);
    }
} 
