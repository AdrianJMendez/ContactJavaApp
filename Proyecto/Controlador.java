package Proyecto;
import java.util.Scanner;
import java.util.scanner;
public class Controlador
{


        public void Add(int index, Contactos nvoContacto){



        }


}
//metodo agregar contacto
    public static void agregarContacto(ArrayList<Contacto> lista, Contacto nuevoContacto) {

        if(lista==null){

                 System.out.println("la Lista esta vacia ");

        }else{
                lista.add(nuevoContacto);

        }

        }
//metodo remover contacto
public void removeContacto(int index) {

     char [] sublistas={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','#'};
for(int i=0;i<sublistas.length,i++){
    if(i==index){
        char temp= sublistas[index];
        }
    }
if(contacto.sublista.temp==null){
    System.out.println("no hay lista");

    }else{
    Scanner entrada=new Scanner(System.in);
    System.out.println("por favor digite el contacto que desea eliminar");
    int subindex;
    subindex= entrada.nextInt();
    if (index >= 0 && index < contacto.sublista.temp.size()) {
        contacto.sublista.temp.remove(index);
        System.out.println("Contacto eliminado exitosamente.");
    } else {
        System.out.println("Índice inválido, no se puede eliminar el contacto.");




}


}
