package com.taller2.Punto9;

public class Rectangulo implements Forma {
    private float largo;
    private float ancho;

    public float area() {
        return this.getLargo() * this.getAncho();
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }
}