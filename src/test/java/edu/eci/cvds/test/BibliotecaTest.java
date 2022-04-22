package edu.eci.cvds.test;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.ECILibraryServicesFactory;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class BibliotecaTest {
    private ECILibraryServices eciLibraryServices;


    public BibliotecaTest(){
        eciLibraryServices = ECILibraryServicesFactory.getInstance().getECILibraryServices();
    }

    @Test
    public void deberiaregistrarRecurso() throws BibliotecaException{
        Time horaInicio = Time.valueOf("11:30:0");
        Time horaFinal = Time.valueOf("12:30:0");
        LocalDate fecha = LocalDate.of(2022, Month.APRIL,16);
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        int long1 = listarecursos.size();
        eciLibraryServices.registrarRecursos(new Recurso(id,"manejo","biblioteca c",8,fecha,horaInicio,horaFinal,"Disponible","sala"));
        List<Recurso> listarecursos2 = eciLibraryServices.consultarRecursos();
        int long2 = listarecursos2.size();
        assertTrue(long2>long1);

    }
}
