package edu.eci.cvds.entities;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * clase que representa un recurso
 */
public class Recurso implements Serializable {

    private int id;
    private String nombre;
    private String ubicacion;
    private int capacidad;
    private Date fecha;
    private Time horario_inicial;
    private Time horario_final;
    private String tiporecurso;

    public Recurso(){}

    public Recurso(int id, String nombre, String ubicacion, int capacidad, Date fecha, Time horario_inicial, Time horario_final,String tiporecurso){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.horario_inicial=horario_inicial;
        this.horario_final=horario_final;
        this.tiporecurso=tiporecurso;

    }

    @Override
    public String toString() {
        return "Recurso{" + " id= " + id + " nombre= " + nombre + " ubicacion= " + ubicacion + " capacidad= "+ capacidad +  " fecha = " + fecha + " Hora_inicial= " + horario_inicial + " Hora_final= " + horario_final + " tipo= " + tiporecurso + "}";
    }

    public String getNombre(){
        return nombre;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Date getFecha(){
        return fecha;
    }

    public Time getHorario_inicial(){
        return horario_inicial;
    }

    public Time getHorario_final(){
        return horario_final;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHorario_inicial(Time horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public void setHorario_final(Time horario_final) {
        this.horario_final = horario_final;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(String tiporecurso) {
        this.tiporecurso = tiporecurso;
    }
}