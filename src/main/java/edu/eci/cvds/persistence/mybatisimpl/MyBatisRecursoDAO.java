package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mappers.RecursoMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class MyBatisRecursoDAO implements RecursoDAO {

    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public List<Recurso> consultarRecursos() throws PersistenceException {
        List<Recurso> lisrecursos = null;
        try{
            lisrecursos = recursoMapper.consultarRecursos();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar recursos mb",e);
        }
        return lisrecursos;
    }

    @Override
    public void agregarRecursos(Recurso recurso) throws PersistenceException {
        try{
            recursoMapper.agregarRecursos(recurso);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar recurso",e);
        }
    }

}
