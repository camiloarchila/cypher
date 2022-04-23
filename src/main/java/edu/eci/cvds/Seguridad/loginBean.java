package edu.eci.cvds.Seguridad;

import edu.eci.cvds.Exceptions.BibliotecaException;

public interface loginBean {
    public void inicia(String correo,String password, boolean remmemberme) throws BibliotecaException;

    public boolean logged();

    public void logOut();
}
