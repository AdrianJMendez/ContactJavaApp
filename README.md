# Proyecto_1
Proyecto de la clase de Algoritmos y Estructuras de datos

La clase "Contacto" es la encargada de modelar cada uno de los contactos que se agregarán a la lista de contactos del proyecto. Esta clase cuenta con los siguientes atributos:

Nombre: nombre del contacto, tipo String
Email: dirección de correo electrónico del contacto, tipo String
Direccion: dirección física del contacto, tipo String
Tipo: tipo de contacto, puede ser "familiar", "colega" o "cliente", tipo String
Telefono: número telefónico del contacto, tipo double
Favorito: indica si el contacto está en la lista de favoritos, tipo boolean
La clase cuenta con un constructor que recibe como parámetros todos los atributos mencionados anteriormente, y se encarga de asignarlos a sus respectivas variables.

Además, la clase "Contacto" cuenta con los siguientes métodos:

getNombre(): método que devuelve el nombre del contacto.
setNombre(String nombre): método que establece el nombre del contacto.
getEmail(): método que devuelve el correo electrónico del contacto.
setEmail(String email): método que establece el correo electrónico del contacto.
getDireccion(): método que devuelve la dirección física del contacto.
setDireccion(String direccion): método que establece la dirección física del contacto.
getTipo(): método que devuelve el tipo de contacto.
setTipo(String tipo): método que establece el tipo de contacto.
getTelefono(): método que devuelve el número telefónico del contacto.
setTelefono(double telefono): método que establece el número telefónico del contacto.
isFavorito(): método que devuelve si el contacto está en la lista de favoritos.
setFavorito(boolean favorito): método que establece si el contacto está en la lista de favoritos.
Cada uno de estos métodos permite acceder y modificar los atributos de la clase, lo que permite manipular y acceder a la información de cada contacto de manera eficiente y organizada.

La clase ContactList es una clase Java que modela una lista de contactos organizada alfabéticamente. La lista se almacena en una LinkedList que contiene un ObservableList para cada letra del alfabeto y otro para los nombres que empiezan con un caracter que no es una letra. Cada ObservableList se encuentra ordenado alfabéticamente.

Esta clase fue actualizada recientemente para cambiar la estructura de los ArrayLists por ObservableArrayLists. Esto permite que los cambios en la lista sean notificados automáticamente a los elementos que la están observando, por ejemplo, una interfaz gráfica de usuario construida con JavaFX.

La clase cuenta con los siguientes métodos:

SublistaLetras(): Crea los ObservableLists que representan a cada letra del alfabeto.
Sublista(): Crea el ObservableList que representa a los nombres que empiezan con un caracter que no es una letra.
Add(LinkedList<ArrayList<Contacto>> listaContactos, Contacto nvoContacto): Agrega un contacto a la lista de contactos.
Remove(String Nombre): Remueve un contacto de la lista de contactos.
Search(String Nombre): Busca un contacto en la lista de contactos.
Para utilizar esta clase, es necesario importar las siguientes librerías:

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.LinkedList;


@version 1.1
@since 15/4/23


HashMap<Integer, Contacto> CacheTelefono = new HashMap<>()
Variable que almacena un objeto HashMap que sirve como caché para almacenar contactos con sus números de teléfono. Este HashMap tiene como clave un número entero y como valor un objeto de la clase Contacto.

Contacto SearchNumber(Integer number)
Método que recibe como parámetro un número de teléfono de tipo entero y devuelve un objeto de la clase Contacto que corresponde a ese número en el caché de teléfonos.

Parámetros
number: número de teléfono a buscar en el caché.
Retorno
Objeto de la clase Contacto que corresponde al número de teléfono proporcionado. Si no se encuentra ningún contacto con ese número en el caché, se devuelve null.

@since 24/4/23

Adrián de Jesús Méndez Pérez - 20221002626
Jeyson Fernando Espinal Guevara - 20201001015
Viktor Andre Hernandez Velasquez - 20221004546
Oscar Daniel Estrada Euceda - 20211023336

Ruta de las clases: C:\Users\Usuario\IdeaProjects\Proyecto\src\main\java

