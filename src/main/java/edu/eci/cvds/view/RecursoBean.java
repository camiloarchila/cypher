package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ECILibraryServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "RecursoBean")
@RequestScoped
public class RecursoBean extends BasePageBean {

    @Inject
    private ECILibraryServices eciLibraryServices;

    //recursos disponibles
    private String[] typeRecurso = {"Equipo de computo","Sala de estudio","Equipos de multimedia",};
    //disponibilidad de recursos
    private String[] dispoRecursos = {"Disponible","No disponble","Daño"};
    //ubicacion
    private String[] ubicaciones = {"Bibilioteca Jorge Alvarez","Biblioteca bloque g","salas  bloque b"};
    private String typeRecursore;
    private String dispoRecursosre;
    private String ubicacion;
    private int id;

    /**
     * consultar los recursos de la biblioteca
     *
     * @return lista de recursos
     * @throws BibliotecaException
     */
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        List<Recurso> recursos = new ArrayList<>();
        try {
            recursos = eciLibraryServices.consultarRecursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }


    public void registrarRecurso(String nombre,int capacidad, String fecha, String horario_inicial, String horario_final) {
        try {
            java.sql.Time horainical = java.sql.Time.valueOf(horario_inicial);
            java.sql.Time horafinal = java.sql.Time.valueOf(horario_final);
            LocalDate fechas = LocalDate.parse(horario_final);
            int id = (int) Math.floor(Math.random()*(90-11+1)+90);
            eciLibraryServices.registrarRecursos(new Recurso(id,nombre,ubicacion,capacidad,fechas,horainical,horafinal,dispoRecursosre,typeRecursore));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO , "registro exitoso", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] getTypeRecurso() {
        return typeRecurso;
    }

    public void setTypeRecurso(String[] typeRecurso) {
        this.typeRecurso = typeRecurso;
    }

    public String[] getDispoRecursos() {
        return dispoRecursos;
    }

    public void setDispoRecursos(String[] dispoRecursos) {
        this.dispoRecursos = dispoRecursos;
    }

    public String[] getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(String[] ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public String getTypeRecursore() {
        return typeRecursore;
    }

    public void setTypeRecursore(String typeRecursore) {
        this.typeRecursore = typeRecursore;
    }

    public String getDispoRecursosre() {
        return dispoRecursosre;
    }

    public void setDispoRecursosre(String dispoRecursosre) {
        this.dispoRecursosre = dispoRecursosre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
