package com.taller2.Punto4;

import java.util.ArrayList;

public class Videotienda {
    private ArrayList<String> usuarios;
    private ArrayList<String> peliculas;
    
    public Videotienda() {
        setUsuarios(new ArrayList<String>());
        getUsuarios().add("Carlos");
        getUsuarios().add("Susana");
        getUsuarios().add("Manuel");
        
        setPeliculas(new ArrayList<String>());
        getPeliculas().add("Forrest Gump");
        getPeliculas().add("Spider-Man");
        getPeliculas().add("The Fast and the Furious");
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public void setPeliculas(ArrayList<String> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<String> getPeliculas() {
        return peliculas;
    }

    public String getPelicula(int peli) {
        return peliculas.get(peli);
    }

    public void addUsuario(String nombre) {
        usuarios.add(nombre);
    }

    public void addPelicula(String nombre) {
        peliculas.add(nombre);
    }

    public void delPelicula(String peli) {
        peliculas.remove(peli);
    }

    public void limpiarUsuarios() {
        usuarios.clear();
    }

    public void limpiarPeliculas() {
        peliculas.clear();
    }

}
