package com.taller3.Punto3;

public class T3Punto3 {

    public void ejecutarPunto3() {
        arbolito(11); //las hojas del arbolito es repetitivo
	    System.out.println("          ***"); //Parte del tronco no es repetitivo
	    tronco(3); //parte del tronco es repetitivo
    }

    public void arbolito (int altura) {
        int filas = 1, espacios = altura - 1, asteriscos = 1;
        do {
            do {
                System.out.print(" "); //Escribo menos espacios a medida que salto de filas
                espacios--;
            }while (espacios >= 0);

            do {
                System.out.print("*"); //Escribo asteriscos en cada fila de forma impar (2*filas+1 representa un número impar siempre)
                asteriscos++;
            }while (asteriscos <= 2 * filas - 1);

            System.out.println("");
		    filas++;

            if (filas > 2)
			    espacios = altura - 2 - asteriscos + filas;
		    else
			    espacios = altura - asteriscos;

            asteriscos = 1;
        }while (filas <= altura);
        System.out.print("");
    }

    public void tronco (int altura) {
        int filas = 1, espacios = altura + 6, asteriscos = 1;
        do {
            do {
                System.out.print(" "); //Escribo menos espacios a medida que salto de filas
                espacios--;
            }while (espacios >= 0);

            do {
                System.out.print("*"); //Escribo asteriscos en cada fila de forma impar (2*filas+1 representa un número impar siempre)
                asteriscos++;
            }while (asteriscos <= 2 * filas + 1);

            System.out.println(" ");
            filas++;
            espacios = altura + 7 - asteriscos + filas;
		    asteriscos = 1;
        }while (filas <= altura);
        System.out.println("");
    }

}