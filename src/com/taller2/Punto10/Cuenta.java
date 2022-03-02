package com.taller2.Punto10;

import java.util.ArrayList;

public class Cuenta {
    private ArrayList<String> clientes;
    private ArrayList<Integer> saldos;

    public Cuenta() {
        setClientes(new ArrayList<String>());
        getClientes().add("paolagarcia");
        getClientes().add("julianmesa");
        getClientes().add("mariagutierrez");
        setSaldos(new ArrayList<Integer>());
        getSaldos().add(1000000);
        getSaldos().add(2000000);
        getSaldos().add(3000000);
    }

    public ArrayList<Integer> getSaldos() {
        return saldos;
    }

    public void setSaldos(ArrayList<Integer> saldos) {
        this.saldos = saldos;
    }

    public void setClientes(ArrayList<String> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<String> getClientes() {
        return clientes;
    }

    public void limpiarClientes() {
        clientes.clear();
        saldos.clear();
    }

}
