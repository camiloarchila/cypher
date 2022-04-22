package edu.eci.cvds.services;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ECILibraryServices {

    public List<Recurso> consultarRecursos() throws BibliotecaException;

    public void registrarRecursos(Recurso recurso) throws BibliotecaException;

}
