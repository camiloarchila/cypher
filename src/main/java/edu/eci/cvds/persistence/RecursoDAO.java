package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface RecursoDAO {
    public List<Recurso> consultarRecursos() throws PersistenceException;
}
