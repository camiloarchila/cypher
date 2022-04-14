package edu.eci.cvds.services;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import java.sql.Date;
import java.util.List;

public interface ECILibraryServices {

    public abstract List<Recurso> consultarRecursos() throws BibliotecaException;

}
