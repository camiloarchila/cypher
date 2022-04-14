package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ECILibraryServices;
import org.jetbrains.annotations.NotNull;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "RecursoBean")
@SessionScoped
public class RecursoBean extends BasePageBean{

    @Inject
    private ECILibraryServices eciLibraryServices;
    private Recurso recurso;
    private List<Recurso> listrecursos;

    private @NotNull List<Recurso> consultarRecursos() throws BibliotecaException {
        try{
            List<Recurso> recursos = new ArrayList<Recurso>(listrecursos);
            recursos.addAll(eciLibraryServices.consultarRecursos());
            return recursos;
        }catch (Exception e){
            throw new BibliotecaException("Error al consultar item");
        }
    }

}
