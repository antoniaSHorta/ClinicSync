/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author asali
 */
import java.util.Date;

public class Planificador {
    private Date hora;
    private int disponibilidad; //Si es 0 esta libre, de lo contrario esta ocupado
    private String ficha;
    private String observacion;

    public Planificador(Date hora, int disponibilidad, String ficha, String observacion) {
        this.hora = hora;
        this.disponibilidad = disponibilidad;
        this.ficha = ficha;
        this.observacion = observacion;
    }

    public Planificador() {
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


}
