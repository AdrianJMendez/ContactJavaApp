package Models;

import com.example.abriendoventanas.Contacto;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Crea un objeto ContactList, que es una lista de contactos organizada alfabéticamente. Los contactos se almacenan en una LinkedList doble
 * que contiene un ArrayList para cada letra del alfabeto y otro para los nombres que empiezan con un caracter que no es una letra.
 * Cada ArrayList se encuentra ordenado alfabéticamente.
 */
public class ContactList {

    LinkedList<ArrayList<Contacto>> listaContactos = new LinkedList<ArrayList<Contacto>>();


    //Sublistas de la A a Z
    public void SublistaLetras() {
        for (int i = 0; i < 27; i++) {
            this.listaContactos.add(new ArrayList<Contacto>());
        }
    }
    //Sublista de nombres con caracteres
    public void Sublista() {
        this.listaContactos.add(new ArrayList<Contacto>());
    }

    /**
     * Agrega un contacto a la lista de contactos.
     *
     * @param listaContactos
     * @param nvoContacto    El objeto Contacto que se desea agregar.
     */
    protected void Add(LinkedList<ArrayList<Contacto>> listaContactos, Contacto nvoContacto){
         char PrimeraLetra = nvoContacto.getNombre().charAt(0); //Revisa la primera letra del Nombre del contacto
            for(int i = 0; i < 27; i++){
                char letra = 'A';
                    if(Character.toLowerCase(letra)== Character.toLowerCase(PrimeraLetra)){
                            this.listaContactos.get(i).add(nvoContacto);

                        break;
                    }
                letra ++;
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
                    ArrayList<Contacto> listaI =  listaContactos.get(i);
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

}
