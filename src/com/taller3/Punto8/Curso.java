package com.taller3.Punto8;

import java.util.ArrayList;

public class Curso {
    private ArrayList<String> usuarios;
    private ArrayList<String> pruebas;

    public Curso() {
        setUsuarios(new ArrayList<String>());
        setPruebas(new ArrayList<String>());
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<String> getusuarios() {
        return usuarios;
    }

    public void setPruebas(ArrayList<String> pruebas) {
        this.pruebas = pruebas;
    }

    public ArrayList<String> getPruebas() {
        return pruebas;
    }

    public void addUsuario(String usuario, String prueba) {
        usuarios.add(usuario);
        pruebas.add(prueba);
    }

    public void delUsuario(String usuario, String prueba) {
        usuarios.remove(usuario);
        pruebas.remove(prueba);
    }

    public void limpiarUsuarios() {
        usuarios.clear();
        pruebas.clear();
    }

}
