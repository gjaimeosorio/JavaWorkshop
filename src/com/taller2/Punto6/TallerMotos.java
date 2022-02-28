package com.taller2.Punto6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TallerMotos {
    private ArrayList<String> clientes;
    private ArrayList<String> observacionesClientes;
    private ArrayList<String> fechasIngresos;
    private ArrayList<String> fechasSalidas;
    private Map<String, String> repuestos;


    public TallerMotos() {
        setClientes(new ArrayList<String>());
        setObservacionesClientes(new ArrayList<String>());
        setFechasIngresos(new ArrayList<String>());
        setFechasSalidas(new ArrayList<String>());
        setRepuestos(new HashMap<String, String>());
    }

    public void setClientes(ArrayList<String> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<String> getClientes() {
        return clientes;
    }

    public void setObservacionesClientes(ArrayList<String> observacionesClientes) {
        this.observacionesClientes = observacionesClientes;
    }

    public ArrayList<String> getObservacionesClientes() {
        return observacionesClientes;
    }

    public void setFechasIngresos(ArrayList<String> fechasIngresos) {
        this.fechasIngresos = fechasIngresos;
    }

    public ArrayList<String> getFechasIngresos() {
        return fechasIngresos;
    }

    public void setFechasSalidas(ArrayList<String> fechasSalidas) {
        this.fechasSalidas = fechasSalidas;
    }

    public ArrayList<String> getFechasSalidas() {
        return fechasSalidas;
    }

    public void setRepuestos(Map<String, String> repuestos) {
        this.repuestos = repuestos;
    }

    public Map<String, String> getRepuestos() {
        return repuestos;
    }

    public void addClientes(String cliente, String observacion, String fechaIn, String fechaOut) {
        clientes.add(cliente);
        observacionesClientes.add(observacion);
        fechasIngresos.add(fechaIn);
        fechasSalidas.add(fechaOut);
    }

    public void addRepuestos(String cliente, String repuesto) {
        repuestos.put(cliente, repuesto);
    }

    public void limpiarClientes() {
        clientes.clear();
        observacionesClientes.clear();
        fechasIngresos.clear();
        fechasSalidas.clear();
        repuestos.clear();
    }

}
