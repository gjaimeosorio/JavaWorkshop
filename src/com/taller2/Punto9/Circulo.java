package com.taller2.Punto9;

public class Circulo implements Forma {
    private float radio;

    public float area() {
        return (float) Math.PI * this.getRadio() * this.getRadio();
    }

    public float getRadio() {
        return radio;
    }

    public float setRadio(float radio) {
        this.radio = radio;
        return radio;
    }
}