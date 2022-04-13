package edu.eci.cvds.services;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;

import java.util.List;

public interface ECILibraryServices {

    public List<Recurso> consultarRecursos() throws BibliotecaException;
    
}
