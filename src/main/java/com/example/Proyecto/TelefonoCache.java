package com.example.Proyecto;

import java.util.ArrayList;

public class TelefonoCache {

    private char letra;

    private int telefono;



    public TelefonoCache(char letra, int telefono) {
        this.letra = letra;
        this.telefono = telefono;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
