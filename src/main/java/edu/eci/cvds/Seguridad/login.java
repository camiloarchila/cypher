package edu.eci.cvds.Seguridad;

import edu.eci.cvds.Exceptions.BibliotecaException;

public interface login {
    public void inicia(String correo,String password) throws BibliotecaException;
    public boolean logged();
}
