package Models;

import com.example.Proyecto.Contacto;
import com.example.Proyecto.TelefonoCache;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Crea un objeto ContactList, que es una lista de contactos organizada alfabéticamente. Los contactos se almacenan en una LinkedList doble
 * que contiene un ArrayList para cada letra del alfabeto y otro para los nombres que empiezan con un caracter que no es una letra.
 * Cada ArrayList se encuentra ordenado alfabéticamente.
 */
public class ContactList {

    public LinkedList<ObservableList<Contacto>> listaContactos = new LinkedList<>();

    public ObservableList<TelefonoCache> listaTelfonos = FXCollections.observableArrayList(); // memoria cache de numeros telefonicos



    //Sublistas de la A a Z
    public void SublistaLetras() {
        for (int i = 0; i < 27; i++) {
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
     * @param listaContactos
     * @param nvoContacto    El objeto Contacto que se desea agregar.
     */
    protected void Add(LinkedList<ArrayList<Contacto>> listaContactos, Contacto nvoContacto){
        char PrimeraLetra = nvoContacto.getNombre().toLowerCase().charAt(0); //Revisa la primera letra del Nombre del contacto
        char letra = 'A';
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
    }

    /**
     * Remueve un contacto de la lista de contactos.
     *
     * @param Nombre El nombre del contacto que se desea remover.
     */
        protected void Remove(String Nombre){
            char PrimeraLetra = Nombre.charAt(0); //Revisa la primera letra del Nombre del contacto
            for(int i = 0; i < 27; i++){
                char letra = 'A';
                if(Character.toLowerCase(letra)== Character.toLowerCase(PrimeraLetra)){
                    ObservableList<Contacto> listaI =  listaContactos.get(i);
                     for(int j = 0; j < listaI.size(); j++){
                         if(listaI.get(j).getNombre().equalsIgnoreCase(Nombre)){
                             listaI.remove(j);
                             break;
                         }
                     }
                    break;
                }
                letra ++;
            }

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

}
