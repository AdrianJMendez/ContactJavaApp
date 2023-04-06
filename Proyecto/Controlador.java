package Proyecto;

public class Controlador
{
}
//metodo agregar contacto
    public static void agregarContacto(ArrayList<Contacto> lista, Contacto nuevoContacto) {

        if(lista==null){

                 System.out.println("la Lista esta vacia ");

        }else{
                lista.add(nuevoContacto);

        }

        }