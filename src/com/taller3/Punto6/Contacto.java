package com.taller3.Punto6;

import java.util.ArrayList;

public class Contacto {
    private ArrayList<String> usuarios;
    private ArrayList<String> telefonos;
    private ArrayList<String> organizaciones;

    public Contacto() {
        setUsuarios(new ArrayList<String>());
        setTelefonos(new ArrayList<String>());
        setOrganizaciones(new ArrayList<String>());
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setOrganizaciones(ArrayList<String> organizaciones) {
        this.organizaciones = organizaciones;
    }

    public ArrayList<String> getOrganizaciones() {
        return organizaciones;
    }

    public void addUsuario(String usuario, String telefono, String organizacion) {
        usuarios.add(usuario);
        telefonos.add(telefono);
        organizaciones.add(organizacion);
    }

    public void delUsuario(String usuario, String telefono, String organizacion) {
        usuarios.remove(usuario);
        telefonos.remove(telefono);
        organizaciones.remove(organizacion);
    }

    public void limpiarContactos() {
        usuarios.clear();
        telefonos.clear();
        organizaciones.clear();
    }

}
