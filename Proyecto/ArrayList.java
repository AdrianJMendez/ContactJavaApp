package Proyecto;

import java.util.List;

public class ArrayList implements List {

    Contacto[] ListaContacto = new Contacto();


    public Contacto[] getListaContacto() {
        return ListaContacto;
    }

    public void setListaContacto(Contacto[] listaContacto) {
        ListaContacto = listaContacto;
    }
}
