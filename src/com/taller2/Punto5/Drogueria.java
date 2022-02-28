package com.taller2.Punto5;

import java.util.HashMap;

public class Drogueria {
    private HashMap<String, Integer> productos;

    public Drogueria() {
        setProductos(new HashMap<String, Integer>());
        getProductos().put("Acetaminofén", 900);
        getProductos().put("Aspirina", 1200);
        getProductos().put("Suero", 5600);
        getProductos().put("Alcohol", 3200);
        // setProductos(new ArrayList<String>());
        // getProductos().add("Acetaminofén");
        // getProductos().add("Aspirina");
        // getProductos().add("Suero");
        // getProductos().add("Alcohol")

        // setPrecios(new ArrayList<Integer>());
        // getPrecios().add(900);
        // getPrecios().add(1200);
        // getPrecios().add(5600);
        // getPrecios().add();
    }

    public void setProductos(HashMap<String, Integer> productos) {
        this.productos = productos;
    }

    public HashMap<String, Integer> getProductos() {
        return productos;
    }

    public void limpiarProductos() {
        productos.clear();
    }

}