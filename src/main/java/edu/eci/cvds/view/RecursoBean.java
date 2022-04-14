package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ECILibraryServices;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "RecursoBean", eager = true)
@RequestScoped
public class RecursoBean extends BasePageBean{

    @Inject
    private ECILibraryServices eciLibraryServices;

    /**
     * consultar los recursos de la biblioteca
     * @return lista de recursos
     * @throws BibliotecaException
     */
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        List<Recurso> recursos = new ArrayList<>();
        try{
            recursos = eciLibraryServices.consultarRecursos();
        }catch (Exception e){
            e.printStackTrace();
        }
        return recursos;
    }

}
