package edu.eci.cvds.entities;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * clase que representa un recurso
 */
public class Horario implements Serializable {

    private int id_horario;
    private Date fecha;
    private Time horario_inicial;
    private Time horario_final;
    private boolean disponibilidad;

    public Horario(){super();}

    public Horario(int id_horario, Date fecha, Time horario_inicial, Time horario_final, boolean disponibilidad){
        this.id_horario= id_horario;
        this.fecha = fecha;
        this.horario_inicial=horario_inicial;
        this.horario_final=horario_final;
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Horario{" + " id= " + id_horario + " fecha = " + fecha + " Hora_inicial= " + horario_inicial + " Hora_final= " + horario_final + " Disponibilidad="+ disponibilidad + "}";
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

    public boolean getDisponibilidad(){
        return disponibilidad;
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

    public void setDisponibilidad(){
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id_horario;
    }

    public void setId(int id) {
        this.id_horario = id_horario;
    }
}
