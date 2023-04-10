package com.example.abriendoventanas;

import java.util.Objects;

public class Persona {

    private String nombre;
    private String Apellidos;
    private int Edad;

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        Apellidos = apellidos;
        Edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return getEdad() == persona.getEdad() && getNombre().equals(persona.getNombre()) && getApellidos().equals(persona.getApellidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellidos(), getEdad());
    }
}