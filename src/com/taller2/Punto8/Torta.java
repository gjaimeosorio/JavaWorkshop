package com.taller2.Punto8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Torta {
    private ArrayList<String> sabores;
    private ArrayList<Integer> porciones;
    private ArrayList<String> decoraciones;
    private ArrayList<String> tortas;
    private Map<String, Integer> precios;

    public Torta() {
        setSabores(new ArrayList<String>());
        getSabores().add("fresa");
        getSabores().add("chocolate");
        getSabores().add("maracuyá");
        getSabores().add("mora");
        setPorciones(new ArrayList<Integer>());
        getPorciones().add(20);
        getPorciones().add(40);
        getPorciones().add(60);
        setDecoraciones(new ArrayList<String>());
        getDecoraciones().add("merengue suizo");
        getDecoraciones().add("merengue francés");
        getDecoraciones().add("merengue italiano");
        setPrecios(new HashMap<String, Integer>());
        getPrecios().put("fresa", 34500);
        getPrecios().put("chocolate", 28900);
        getPrecios().put("maracuyá", 45600);
        getPrecios().put("mora", 37800);
        setTortas(new ArrayList<String>());
    }

    public Map<String, Integer> getPrecios() {
        return precios;
    }

    public void setPrecios(Map<String, Integer> precios) {
        this.precios = precios;
    }

    public ArrayList<String> getTortas() {
        return tortas;
    }

    public void setTortas(ArrayList<String> tortas) {
        this.tortas = tortas;
    }

    public ArrayList<String> getDecoraciones() {
        return decoraciones;
    }

    public void setDecoraciones(ArrayList<String> decoraciones) {
        this.decoraciones = decoraciones;
    }

    public ArrayList<Integer> getPorciones() {
        return porciones;
    }

    public void setPorciones(ArrayList<Integer> porciones) {
        this.porciones = porciones;
    }

    public ArrayList<String> getSabores() {
        return sabores;
    }

    public void setSabores(ArrayList<String> sabores) {
        this.sabores = sabores;
    }

    public void delSabor(String sabor) {
        sabores.remove(sabor);
    }

    public void addTorta(String torta) {
        tortas.add(torta);
    }

    public void AddPrecio(String precio) {
        precios.remove(precio);
    }

    public void limpiarTortas() {
        tortas.clear();
        precios.clear();
        sabores.clear();
        porciones.clear();
        decoraciones.clear();
    }
}
