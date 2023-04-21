package com.example.Proyecto;

import com.example.Proyecto.Contacto;
import com.example.Proyecto.TelefonoCache;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;


/**
 * Crea un objeto ContactList, que es una lista de contactos organizada alfabéticamente. Los contactos se almacenan en una LinkedList doble
 * que contiene un ArrayList para cada letra del alfabeto y otro para los nombres que empiezan con un caracter que no es una letra.
 * Cada ArrayList se encuentra ordenado alfabéticamente.
 */
public class ContactList {

    public LinkedList<ObservableList<Contacto>> listaContactos = new LinkedList<>();

    public ObservableList<TelefonoCache> listaTelfonos = FXCollections.observableArrayList(); // memoria cache de numeros telefonicos



    //Sublistas de la A a Z
    public ContactList() {
        for (int i = 0; i < 28; i++) {
            ObservableList<Contacto> nuevaLista = FXCollections.observableArrayList();
            this.listaContactos.add(nuevaLista);
        }
    }
    //Sublista de nombres con caracteres
    public void Sublista() {
        ObservableList<Contacto> nuevaLista = FXCollections.observableArrayList();
        this.listaContactos.add(nuevaLista);
    }


    public char SearchCache(int numero){
        char existe = 0;
        for(int i = 0; i<listaTelfonos.size(); i++) {
                TelefonoCache nvoTelefono = listaTelfonos.get(i);
                if(numero == nvoTelefono.getTelefono()){
                    existe = nvoTelefono.getLetra();
                break;
                }

        }

      return existe;

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
                        TelefonoCache nvoNumero = new TelefonoCache(PrimeraLetra, nvoContacto.getTelefono());
                        this.listaTelfonos.add(nvoNumero);
                        break;
                    }
                    letra++;
                }

            }else{

                this.listaContactos.get(26).add(nvoContacto);
                TelefonoCache nvoNumero = new TelefonoCache(PrimeraLetra, nvoContacto.getTelefono());
                this.listaTelfonos.add(nvoNumero);

            }


        if(nvoContacto.isFavorito()){
            this.listaContactos.get(27).add(nvoContacto); //Se agrega el contacto a la ultima lista si es favorito
        }
    }

    /**
     * Remueve un contacto de la lista de contactos.
     *
     * @param Nombre El nombre del contacto que se desea remover.
     */
        protected void Remove(String Nombre){

            char PrimeraLetra = Nombre.charAt(0); //Revisa la primera letra del Nombre del contacto
            char letra = 'A';
            for(int i = 0; i < 27; i++){
                if(Character.toLowerCase(letra)== Character.toLowerCase(PrimeraLetra)){
                    ObservableList<Contacto> listaI =  listaContactos.get(i);
                     for(int j = 0; j < listaI.size(); j++){
                         if(listaI.get(j).getNombre().equalsIgnoreCase(Nombre)){

                             if(listaI.get(j).isFavorito()){
                                 Contacto contactoRemover=listaI.get(j);
                                 this.listaContactos.get(27).remove(contactoRemover); // se elimina el contacto de la ultima lista si es favorito
                             }

                             listaI.remove(j);


                             break;

                         }
                     }
                    break;
                }
                letra ++;
            }

        }


    protected Contacto Remove(Contacto contacto){

        char PrimeraLetra = contacto.getNombre().charAt(0); //Revisa la primera letra del Nombre del contacto
        int index=PrimeraLetra-97;

        if(PrimeraLetra<='z'&& PrimeraLetra>='a'){
            this.listaContactos.get(index).remove(contacto);

        }else{
            this.listaContactos.get(26).remove(contacto);
        }

        if(contacto.isFavorito()){
            this.listaContactos.get(27).remove(contacto);
        }

        char letra = 'A';

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
            for(int i = 0; i < 27; i++){
                char letra = 'A';
                if(Character.toLowerCase(letra)== Character.toLowerCase(PrimeraLetra)){// compara las letras para saber a que sublista pertenece
                    ObservableList<Contacto> listaI =  listaContactos.get(i);
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

                    SubLista= this.listaContactos.get(i);

                    break;
                }
                letra ++;
            }

        }else{
            // De ser otra caracter se agrega directamente en la ultima sublista
            SubLista= this.listaContactos.get(26);

        }

        return SubLista;
    }

    public ObservableList<Contacto> GetSubList(int index){

        return this.listaContactos.get(index);

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



}
