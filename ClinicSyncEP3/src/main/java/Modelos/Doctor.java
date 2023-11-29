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

public class Doctor extends Persona{

    private String Especialidad;
    private String formacion;
    private String consulta;
    
    public Doctor(String Especialidad, String formacion, String consulta, String rut, String nombre, String apellido, Date fecha_nacimiento, String direccion, String telefono, String correo) {
        super(rut, nombre, apellido, fecha_nacimiento, direccion, telefono, correo);
        this.Especialidad = Especialidad;
        this.formacion = formacion;
        this.consulta = consulta;
    }
    //SOBRECARGA DE CONSTRUCTOR
    public Doctor() {
        super("00000000-0", "", "", new Date(), "", "", "");
        this.Especialidad = "";
        this.formacion = "";
        this.consulta = "";
    }
    //GETTERS
    public String getEspecialidad() {
        return Especialidad;
    }

    public String getFormacion() {
        return formacion;
    }

    public String getConsulta() {
        return consulta;
    }
    
    //SETTERS
    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
    
    /**
     * SOBREESCRITURA DE METODO, FUNCION DE CLASE HEREDADA DE PERSONA
     */
    @Override
    public void describir() {
        super.describir();
        System.out.printf("Especialidad: %s\n", this.getEspecialidad());
        System.out.printf("Formación: %s\n", this.getFormacion());
        System.out.printf("Consulta: %s\n", this.getConsulta());
        System.out.println("");
    }
        
}
