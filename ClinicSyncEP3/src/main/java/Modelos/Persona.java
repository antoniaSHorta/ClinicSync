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

public class Persona {
    private String rut;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String correo;

    public Persona(String rut, String nombre, String apellido, Date fecha_nacimiento, String direccion, String telefono, String correo) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    //GETTERS
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    //SETTERS
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    // SOBREESCRITURA DE METODO (FUNCION ORIGINAL, PADRE)
    public void describir() {
    System.out.printf("Rut: %s\n", this.getRut());
    System.out.printf("Nombre: %s\n", this.getNombre());
    System.out.printf("Apellido: %s\n", this.getApellido());
    System.out.printf("Fecha de Nacimiento: %s\n", this.getFecha_nacimiento().toString());
    System.out.printf("Dirección: %s\n", this.getDireccion());
    System.out.printf("Teléfono: %s\n", this.getTelefono());
    System.out.printf("Correo: %s\n", this.getCorreo());
}
}
