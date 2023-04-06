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

La clase ContactList representa una lista de contactos organizada alfabéticamente. Los contactos se almacenan en una LinkedList
que contiene un ArrayList para cada letra del alfabeto y otro para los nombres que empiezan con un caracter que no es una letra.
Cada ArrayList se encuentra ordenado alfabéticamente.
La clase ofrece los métodos para agregar, remover y buscar contactos.
@author AdrianJMendez
@version 1.0
@since 5/4/23
*/
import java.util.ArrayList;
import java.util.LinkedList;


