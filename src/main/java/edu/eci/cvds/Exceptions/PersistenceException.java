package edu.eci.cvds.Exceptions;

public class PersistenceException extends Exception{
        public PersistenceException(String msg,Exception serviceException){
            super(msg,serviceException);
        }
        public PersistenceException(String msg){
            super(msg);
        }
}

