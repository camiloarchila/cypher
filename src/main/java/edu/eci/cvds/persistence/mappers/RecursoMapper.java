package edu.eci.cvds.persistence.mappers;

import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface RecursoMapper {
    public List<Recurso> consultarRecursos();

    public void agregarRecursos(@Param("Recurso") Recurso recurso);

   }
