package edu.eci.cvds.entities;


import java.sql.Time;
import java.util.Date;

/**
 * clase que representa un recurso
 */
public class Recurso  {

    private int id;
    private String nombre;
    private String ubicacion;
    private int capacidad;
    private Date fecha;
    private int horario_inicial;
    private int horario_final;
    private String tiporecurso;

    public Recurso(){super();}

    public Recurso(int id, String nombre, String ubicacion, int capacidad, Date fecha, int horario_inicial, int horario_final,String tiporecurso){
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
        return "Horario{" + " id= " + id + " nombre= " + nombre + " ubicacion= " + ubicacion + " capacidad= "+ capacidad +  " fecha = " + fecha + " Hora_inicial= " + horario_inicial + " Hora_final= " + horario_final + " tipo= " + tiporecurso + "}";
    }

    public String getNombre(){
        return nombre;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public int getCapaciddad(){
        return capacidad;
    }

    public Date getFecha(){
        return fecha;
    }

    public int getHorario_inicial(){
        return horario_inicial;
    }

    public int getHorario_final(){
        return horario_final;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCapaciddad(int capaciddad) {
        this.capacidad = capacidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHorario_inicial(int horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public void setHorario_final(int horario_final) {
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