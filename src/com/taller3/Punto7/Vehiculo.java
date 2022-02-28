package com.taller3.Punto7;

import java.util.ArrayList;

public class Vehiculo {
    private ArrayList<String> placas;
    private ArrayList<String> marcas;
    private ArrayList<String> clientes;
    private ArrayList<String> telefonos;

    public Vehiculo() {
        setPlacas(new ArrayList<String>());
        setMarcas(new ArrayList<String>());
        setClientes(new ArrayList<String>());
        setTelefonos(new ArrayList<String>());
    }

    public void setPlacas(ArrayList<String> placas) {
        this.placas = placas;
    }

    public ArrayList<String> getPlacas() {
        return placas;
    }

    public void setMarcas(ArrayList<String> marcas) {
        this.marcas = marcas;
    }

    public ArrayList<String> getMarcas() {
        return marcas;
    }

    public void setClientes(ArrayList<String> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<String> getClientes() {
        return clientes;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void addVehiculo(String placa, String marca, String cliente, String telefono) {
        placas.add(placa);
        marcas.add(marca);
        clientes.add(cliente);
        telefonos.add(telefono);
    }

    public void delVehiculo(String placa, String marca, String cliente, String telefono) {
        placas.remove(placa);
        marcas.remove(marca);
        clientes.remove(cliente);
        telefonos.remove(telefono);
    }

    public void limpiarVehiculos() {
        placas.clear();
        marcas.clear();
        clientes.clear();
        telefonos.clear();
    }

}
