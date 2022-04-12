package edu.eci.cvds.Exceptions;

public class BibliotecaException extends Exception{
    public BibliotecaException(String msg,Exception serviceException){
        super(msg,serviceException);
    }
    public BibliotecaException(String msg){
        super(msg);
    }
}
