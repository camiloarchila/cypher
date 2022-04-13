package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.services.ECILibraryServices;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class ECILibraryServicesImpl implements ECILibraryServices {

    @Inject
    RecursoDAO RecursoDAO;

    @Override
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        try{
            return RecursoDAO.consultarRecursos();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar recursos",ex);
        }
    }
}
