package edu.eci.cvds.entities;


import java.io.Serializable;

/**
 * clase que representa un usuario
 */
public class User implements Serializable {

    private long documento;
    private String nombre;
    private String contrasena;
    private String correo;
    private String telefono;
    private String userType;

    public User(){ super();}

    public User(long documento, String nombre, String contrasena, String correo, String telefono,String userType) {
        this.documento = documento;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.userType = userType;
    }


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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", documento=" + documento + '}';
    }
}
