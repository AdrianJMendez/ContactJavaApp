package com.example.Proyecto;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;


/**
 * Crea un objeto ContactList, que es una lista de contactos organizada alfabéticamente. Los contactos se almacenan en una LinkedList doble
 * que contiene un ArrayList para cada letra del alfabeto y otro para los nombres que empiezan con un caracter que no es una letra.
 * Cada ArrayList se encuentra ordenado alfabéticamente.
 */
public class ContactList {

    public LinkedList<ArrayList<Contacto>> listaContactos = new LinkedList<>();
    public HashMap<Integer, Contacto> CacheTelefono = new HashMap<>();




    //Sublistas de la A a Z
    public ContactList() {
        for (int i = 0; i < 28; i++) {
            ArrayList<Contacto> nuevaLista = new ArrayList<>();
            this.listaContactos.add(nuevaLista);
        }
    }


    /**
     * Agrega un contacto a la lista de contactos.
     *
     * @param nvoContacto    El objeto Contacto que se desea agregar.
     */
    protected void Add(Contacto nvoContacto){
        char PrimeraLetra = nvoContacto.getNombre().toLowerCase().charAt(0); //Revisa la primera letra del Nombre del contacto
        char letra = 'a';
        if (PrimeraLetra <= 'z'&& PrimeraLetra >= 'a') {

            for (int i = 0; i < 26; i++) {

                if (PrimeraLetra == letra) {
                    this.listaContactos.get(i).add(nvoContacto);
                    Collections.sort(listaContactos.get(i)); // ordena la lista cada vez que se agrega un nuevo contacto
                    this.CacheTelefono.put(nvoContacto.getTelefono(),nvoContacto);

                    break;
                }
                letra++;
            }

        }else{

            this.listaContactos.get(26).add(nvoContacto);
            this.CacheTelefono.put(nvoContacto.getTelefono(),nvoContacto);


        }


        if(nvoContacto.isFavorito()){
            this.listaContactos.get(27).add(nvoContacto); //Se agrega el contacto a la ultima lista si es favorito
            Collections.sort(listaContactos.get(27));
        }
    }





    protected Contacto Remove(Contacto contacto){

        char PrimeraLetra = contacto.getNombre().toLowerCase().charAt(0); //Revisa la primera letra del Nombre del contacto
        int index=PrimeraLetra-97;

        if(PrimeraLetra<='z'&& PrimeraLetra>='a'){
            this.listaContactos.get(index).remove(contacto);
            this.CacheTelefono.remove(contacto.getTelefono());

        }else{
            this.listaContactos.get(26).remove(contacto);
            this.CacheTelefono.remove(contacto.getTelefono());
        }

        if(contacto.isFavorito()){
            this.listaContactos.get(27).remove(contacto);
        }


        return contacto;

    }

    /**
     * Busca un contacto en la lista de contactos.
     *
     * @param Nombre El nombre del contacto que se desea buscar.
     * @return El objeto Contacto que se corresponde con el nombre buscado. Si el contacto no existe en la lista, el método devuelve null.
     */
    protected Contacto Search(String Nombre){
        Contacto nvoContacto = null;
        char PrimeraLetra = Nombre.charAt(0); //Revisa la primera letra del Nombre del contacto
        char letra = 'A';
        for(int i = 0; i < 27; i++){

            if(Character.toLowerCase(letra)== Character.toLowerCase(PrimeraLetra)){// compara las letras para saber a que sublista pertenece
                ArrayList<Contacto> listaI =  listaContactos.get(i);
                for(int j = 0; j < listaI.size(); j++){
                    if(listaI.get(j).getNombre().equalsIgnoreCase(Nombre)){
                        nvoContacto = listaI.get(j);
                        break;
                    }
                }
                break;
            }
            letra ++;
        }

        return nvoContacto;
    }

    protected ObservableList<Contacto> GetSubList(char PrimeraLetra){

        ObservableList<Contacto> SubLista= FXCollections.observableArrayList();

        //Se revisa si el contacto inicia con una letra del abacedario u otro caracter
        if(PrimeraLetra<='z' && PrimeraLetra>='a'){
            char letra = 'a';

            for(int i = 0; i < 26; i++){

                if(letra==PrimeraLetra){

                    ObservableList<Contacto> nuevaLista = FXCollections.observableArrayList(this.listaContactos.get(i));

                    SubLista= nuevaLista;

                    break;
                }
                letra ++;
            }

        }else{
            // De ser otra caracter se agrega directamente en la ultima sublista

            ObservableList<Contacto> nuevaLista = FXCollections.observableArrayList(this.listaContactos.get(26));

            SubLista = nuevaLista;

        }

        return SubLista;
    }

    public ObservableList<Contacto> GetSubList(int index){

        ObservableList<Contacto> nuevaLista = FXCollections.observableArrayList(this.listaContactos.get(index));

        return nuevaLista;

    }

    public boolean contains(Contacto contacto){
        char letra=contacto.getNombre().toLowerCase().charAt(0);
        int index=letra-97;
        boolean bandera=false;
        for(Contacto p:this.listaContactos.get(index)){
            if((p.getNombre().equalsIgnoreCase(contacto.getNombre())) && (p.getTelefono() == contacto.getTelefono())
                    && (p.getDireccion().equalsIgnoreCase(contacto.getDireccion())) && p.isFavorito() && contacto.isFavorito() && (p.getTipo().equalsIgnoreCase(contacto.getTipo())))
            {
                bandera=true;
            }
        }

        // el siguiente codigo deberia funcionar en teoria pero no lo hace;
        /**
         if(letra<='z' && letra>='a'){
         return this.listaContactos.get(index).contains(contacto);
         }else{
         return this.listaContactos.get(26).contains(contacto);
         }
         **/
        return bandera;
    }

    public Contacto SearchNumber (Integer number){

        Contacto nvoContacto = CacheTelefono.get(number);


        return nvoContacto;
    }

    public ObservableList ChangeOl(ArrayList<Contacto> lista){
        ObservableList<Contacto> nuevaLista = FXCollections.observableArrayList(lista);

        return nuevaLista;
    }



}