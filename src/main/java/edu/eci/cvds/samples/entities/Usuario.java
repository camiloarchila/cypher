package edu.eci.cvds.samples.entities;

public class Usuario {

    private long documento;
    private String nombre;
    private String contrasena;
    private String correo;
    private String telefono;

    public Usuario(){}

    public Usuario(long documento, String nombre, String contrasena, String correo, String telefono){}

    public long getDocumento(){
        return documento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getContrasena(){
        return contrasena;
    }

    public String getCorreo(){
        return correo;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", documento=" + documento + '}';
    }
}
