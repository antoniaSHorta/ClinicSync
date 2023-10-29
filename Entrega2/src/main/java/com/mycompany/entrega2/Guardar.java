/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega2;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Guardar {
    
    private ArrayList<Paciente> pacientes;
    private ArrayList <Doctor> doctores;
    private ArrayList <Planificador> planificadores;
    private ArrayList <Historial> historiales;
    
    // CONSTRUCTOR
    public Guardar(ArrayList<Paciente> pacientes, ArrayList<Doctor> doctores, ArrayList<Planificador> planificadores, ArrayList<Historial> historiales) 
    {
        this.pacientes = pacientes;
        this.doctores = doctores;
        this.planificadores = planificadores;
        this.historiales = historiales;
    }

    // GUARDAR DATOS EN CSV PACIENTES
    public void GuardarPaciente(ArrayList<Paciente> pacientes) 
    {
        File file = new File("datos/pacientes.csv");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String[] header = {"rut","Nombre","Apellido","fecha_Nacimiento","altura","peso","grupo_Sanguineo","alergias","genero","telefono","correo","direccion","pre_Existencias","observaciones"};
        
        try
            (FileWriter outputfile = new FileWriter(file, false);
            CSVWriter writer = new CSVWriter(outputfile)) {
        
            writer.writeNext(header);

            for (Paciente paciente : pacientes) {
                String[] data = {
                    paciente.getRut(),
                    paciente.getNombre(),
                    paciente.getApellido(),
                    formatoFecha.format(paciente.getFecha_nacimiento()),
                    paciente.getAltura(),
                    paciente.getPeso(),
                    paciente.getGrupo_sanguineo(),
                    paciente.getAlergias(),
                    paciente.getGenero(),
                    paciente.getTelefono(),
                    paciente.getCorreo(),
                    paciente.getDireccion(),
                    paciente.getPre_existencias(),
                    paciente.getObservaciones()
                };
                writer.writeNext(data);
            }
        } 
        catch (IOException e) {
        }
    }
    // GUARDAR DATOS EN CSV DOCTOR
    public void GuardarDoctor(ArrayList<Doctor> doctores) {
        
        File file = new File("datos/doctor.csv");SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String []header = {"Nombre","Apellido","rut","Especialidad","Formacion","Direccion","Correo","Telefono","Consulta","fechaNacimiento"};
            
        try (FileWriter outputfile = new FileWriter(file, false);
            CSVWriter writer = new CSVWriter(outputfile)){
            writer.writeNext(header);
            for (Doctor doctor : doctores) {
                String[] data = {
                doctor.getRut(),
                doctor.getNombre(),
                doctor.getApellido(),
                formatoFecha.format(doctor.getFecha_nacimiento()),
                doctor.getDireccion(),
                doctor.getTelefono(),
                doctor.getCorreo(),
                doctor.getEspecialidad(),
                doctor.getFormacion(),
                doctor.getConsulta()
                };
                writer.writeNext(data);
            }
        } 
        catch (IOException e) {
        }
    }
    
    // GUARDAR DATOS EN CSV HISTORIAL
    public void GuardarHistorial(ArrayList<Historial> historiales) {
        
        File file = new File("datos/historial.csv");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String[] header = {
            "rut", "nombre", "apellido", "fecha_nacimiento", "direccion", "telefono", "correo", 
            "altura", "peso", "grupo_sanguineo", "alergias", "genero", "pre_existencias", "observaciones", 
            "dia_consulta", "receta_Entregada", "examenes", "obs"
        };
        try (FileWriter outputfile = new FileWriter(file, false);
            CSVWriter writer = new CSVWriter(outputfile)) {
            
            writer.writeNext(header);
            for (Historial historial : historiales) {
                Paciente paciente = historial.getFicha();
                String[] data = {
                paciente.getRut(),
                paciente.getNombre(),
                paciente.getApellido(),
                formatoFecha.format(paciente.getFecha_nacimiento()),
                paciente.getDireccion(),
                paciente.getTelefono(),
                paciente.getCorreo(),
                paciente.getAltura(),
                paciente.getPeso(),
                paciente.getGrupo_sanguineo(),
                paciente.getAlergias(),
                paciente.getGenero(),
                paciente.getPre_existencias(),
                paciente.getObservaciones(),
                formatoFecha.format(historial.getDia_consulta()),
                historial.getReceta_Entregada(),
                historial.getExamenes(),
                historial.getObs()
                };
                writer.writeNext(data);
            }
        } 
        catch (IOException e) {
        }
    }

    // GUARDAR DATOS EN CSV PLANIFICADOR
    public void GuardarPlanificador(ArrayList<Planificador> planificaciones) {
        
        File file = new File("datos/planificador.csv");
        SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Formato para la fecha y hora
        SimpleDateFormat formatoFechaNacimiento = new SimpleDateFormat("dd/MM/yyyy"); // Formato para fecha de nacimiento
        String []header = {
            "hora", "disponibilidad", "rut", "nombre", "apellido", "fecha_nacimiento", 
            "direccion", "telefono", "correo", "altura", "peso", "grupo_sanguineo", 
            "alergias", "genero", "pre_existencias", "observaciones", "observacion_planificador"
        };

        try (FileWriter outputfile = new FileWriter(file, false);
            CSVWriter writer = new CSVWriter(outputfile)) {
            
            writer.writeNext(header);
            for (Planificador plan : planificaciones) {
                Paciente ficha = plan.getFicha();
                String[] data = {
                formatoHora.format(plan.getHora()),
                Integer.toString(plan.getDisponibilidad()),
                ficha.getRut(),
                ficha.getNombre(),
                ficha.getApellido(),
                formatoFechaNacimiento.format(ficha.getFecha_nacimiento()),
                ficha.getDireccion(),
                ficha.getTelefono(),
                ficha.getCorreo(),
                ficha.getAltura(),
                ficha.getPeso(),
                ficha.getGrupo_sanguineo(),
                ficha.getAlergias(),
                ficha.getGenero(),
                ficha.getPre_existencias(),
                ficha.getObservaciones(),
                plan.getObservacion()    
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
        }
    }


// METODO
    public void GuardarTodo()
    {
        this.GuardarPaciente(pacientes);
        this.GuardarDoctor(doctores);
        this.GuardarPlanificador(planificadores);
        this.GuardarHistorial(historiales);
    }    
}