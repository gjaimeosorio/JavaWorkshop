package com.taller4.Punto2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class T4Punto2 {

    private static boolean bandera = true;
    private static Scanner input;
    private static ArrayList<Integer> vector = new ArrayList<Integer>();
    private static ArrayList<Integer> vPar = new ArrayList<Integer>();
    private static ArrayList<Integer> vImpar = new ArrayList<Integer>();
    private static Random rd = new Random();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void ejecutarPunto2() {
        do {
            try {
                vector = vectorAleatorio();
                vPar = vectorPar(vector);
                vImpar = vectorImpar(vector);
                mostarVectorPar(vPar);
                mostarVectorImpar(vImpar);
                bandera = repetirVector(vector);
                limpiarPantalla();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (bandera == true);
        
    }

    private static char capturarLetra() {
        input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    private ArrayList<Integer> vectorAleatorio() {
        int numeroAleatorio;
        ArrayList<Integer> vec = new ArrayList<Integer>();
	    for (int i=0; i<20; i++) {
            numeroAleatorio = rd.nextInt(100) + 1;
            vec.add(numeroAleatorio);
        }
        return vec;
    }

    private ArrayList<Integer> vectorPar(ArrayList<Integer> vec) {
        ArrayList<Integer> v_par = new ArrayList<Integer>();
        int i = 0;
        while (i < 20) { //Ciclo diferente para llenar un vector con los números pares
            if (vec.get(i) % 2 == 0) {
                v_par.add(vec.get(i));
            }
            i++;
        }
        return v_par;
    }

    private ArrayList<Integer> vectorImpar(ArrayList<Integer> vec) {
        ArrayList<Integer> v_impar = new ArrayList<Integer>();
        int i = 0;
        while (i < 20) { //Ciclo diferente para llenar un vector con los números impares
            if (vec.get(i) % 2 != 0) {
                v_impar.add(vec.get(i));
            }
            i++;
        }
        return v_impar;
    }

    private static void mostarVectorPar(ArrayList<Integer> vec) {
        System.out.print("Números pares: ");
        int i = 1;
        for (int par : vec) {
            System.out.print(par);
            if (i < vec.size())
                System.out.print(",");
            i++;
        }
        System.out.println("");
    }

    private static void mostarVectorImpar(ArrayList<Integer> vec) {
        System.out.print("Números impares: ");
        int i = 1;
        for (int impar : vec) {
            System.out.print(impar);
            if (i < vec.size())
                System.out.print(",");
            i++;
        }
        System.out.println("\n");
    }

    private static boolean repetirVector(ArrayList<Integer> vec) {
        char opcion;
        System.out.println(ANSI_GREEN + "Desea ingresar un nuevo vector? (S/N)" + ANSI_RESET);
        opcion = capturarLetra();
        System.out.println("");
        vec.clear();
        if(opcion == 's' || opcion == 'S')
            return true;
        else
            return false;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}