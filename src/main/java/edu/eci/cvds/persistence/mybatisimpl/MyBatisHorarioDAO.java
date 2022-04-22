package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.mappers.HorarioMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisHorarioDAO implements HorarioDAO{

    @Inject
    private HorarioMapper horarioMapper;
}
