package edu.eci.cvds.Security;

import edu.eci.cvds.Exceptions.BibliotecaException;
public interface Login {
    public void incio(String correo, String contrasena) throws BibliotecaException;
    public boolean islogged();

}
