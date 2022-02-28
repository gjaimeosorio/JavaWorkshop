package com.taller3.Punto1;

public class T3Punto1 {

    private int filas, asteriscos;

    public void ejecutarPunto1() {
        for (filas = 0; filas < 10; filas++) {
            for (asteriscos = 0; asteriscos <= filas; asteriscos++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}