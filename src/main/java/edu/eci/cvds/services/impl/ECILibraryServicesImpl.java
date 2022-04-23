package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.services.ECILibraryServices;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class ECILibraryServicesImpl implements ECILibraryServices {

    @Inject
    private RecursoDAO RecursoDAO;

    @Override
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        try{
            return RecursoDAO.consultarRecursos();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar recursos",ex);
        }
    }


    @Override
    public void registrarRecursos(Recurso recurso) throws BibliotecaException {
        try{
            RecursoDAO.agregarRecursos(recurso);
        }catch (PersistenceException ex){
            throw  new BibliotecaException("Error al registrar recursos",ex);
        }
    }

}
