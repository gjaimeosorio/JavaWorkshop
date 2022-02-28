package com.taller3.Punto2;

public class T3Punto2 {

    private int filas, espacios, asteriscos;

    public void ejecutarPunto2() {
        filas = 1; espacios = 10; asteriscos = 1;    
        while (filas <= 10) {
            while (espacios > asteriscos) { //Escribo espacios a medida que los asteriscos van aumentando
                System.out.print(" ");
                espacios--;
            }
            while (asteriscos <= filas) { //Escribo * a medida que las filas van aumentando
                System.out.print("*");
                asteriscos++;
            }
            espacios = 11 - asteriscos;
		    asteriscos = 1;
		    filas++;
		    System.out.println("");
        }
        System.out.println("");
    }
}