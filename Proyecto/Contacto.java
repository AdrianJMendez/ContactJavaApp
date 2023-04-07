package Proyecto;

public class Contacto {

    private String Nombre;
    private String Email;
    private String Direccion;
    private String Tipo;
    private int Telefono;
    private boolean Favorito;

    /* true si esta en la lista de favoritos, false si no lo esta */


    public Contacto(String nombre, String email, String direccion, String tipo, int telefono, boolean favorito) {
        Nombre = nombre;
        Email = email;
        Direccion = direccion;
        Tipo = tipo;
        Telefono = telefono;
        Favorito = favorito;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public double getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public boolean isFavorito() {
        return Favorito;
    }

    public void setFavorito(boolean favorito) {
        Favorito = favorito;
    }
}

