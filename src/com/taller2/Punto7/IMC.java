package com.taller2.Punto7;

public class IMC {
    private float peso;
    private float estatura;

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPeso() {
        return peso;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getEstatura() {
        return estatura;
    }

    public float calculoIMC(float p, float e) {
        return p / (e * e);
    }

}
