package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mappers.RecursoMapper;
import org.apache.ibatis.exceptions.PersistenceException;

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
}
