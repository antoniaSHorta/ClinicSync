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


public class Paciente extends Persona{
    private String altura;
    private String peso;
    private String grupo_sanguineo;
    private String alergias;
    private String genero;
    private String pre_existencias;
    private String observaciones;

    public Paciente(String altura, String peso, String grupo_sanguineo, String alergias, String genero, String pre_existencias, String observaciones, String rut, String nombre, String apellido, Date fecha_nacimiento, String direccion, String telefono, String correo) {
        super(rut, nombre, apellido, fecha_nacimiento, direccion, telefono, correo);
        this.altura = altura;
        this.peso = peso;
        this.grupo_sanguineo = grupo_sanguineo;
        this.alergias = alergias;
        this.genero = genero;
        this.pre_existencias = pre_existencias;
        this.observaciones = observaciones;
    }
    
    //SOBRECARGA DE CONSTRUCTOR
    public Paciente() {
        super("00000000-0", "", "", new Date(), "", "", "");
        this.altura = "";
        this.peso = "";
        this.grupo_sanguineo = "";
        this.alergias = "";
        this.genero = "";
        this.pre_existencias = "";
        this.observaciones = "";
    }

    //GETTERS
    public String getAltura() {
        return altura;
    }

    public String getPeso() {
        return peso;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getGenero() {
        return genero;
    }

    public String getPre_existencias() {
        return pre_existencias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    //SETTERS
    public void setAltura(String altura) {
        this.altura = altura;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPre_existencias(String pre_existencias) {
        this.pre_existencias = pre_existencias;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }    
    
    // SOBREESCRITURA DE METODO, (FUNCION HEREDARA DE PERSONA)
    @Override
    public void describir() {
        super.describir();
        System.out.printf("Altura: %s\n", this.getAltura());
        System.out.printf("Peso: %s\n", this.getPeso());
        System.out.printf("Grupo Sanguíneo: %s\n", this.getGrupo_sanguineo());
        System.out.printf("Alergias: %s\n", this.getAlergias());
        System.out.printf("Género: %s\n", this.getGenero());
        System.out.printf("Pre-existencias: %s\n", this.getPre_existencias());
        System.out.printf("Observaciones: %s\n", this.getObservaciones());
        System.out.println("");
    }
    
}
