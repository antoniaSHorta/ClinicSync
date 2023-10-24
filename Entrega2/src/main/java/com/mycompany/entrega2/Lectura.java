/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega2;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Lectura {
    private String rutaPacientes;
    private String rutaDoctores;
    private String rutaHistorial;
    private String rutaPlanificador;
    

    public Lectura(String rutaPacientes, String rutaDoctores, String rutaHistorial, String rutaPlanificador) {
        this.rutaPacientes = rutaPacientes;
        this.rutaDoctores = rutaDoctores;
        this.rutaHistorial = rutaHistorial;
        this.rutaPlanificador = rutaPlanificador;
    }

public ArrayList<Paciente> LeerPaciente() throws CsvValidationException {
    ArrayList<Paciente> pacientes = new ArrayList<>();
    File file = new File(this.rutaPacientes);
    try {
        FileReader inputfile = new FileReader(file);
        CSVReader reader = new CSVReader(inputfile);
        String[] nextRecord;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        while ((nextRecord = reader.readNext()) != null) {
            if (i > 0) { // Ignora la cabecera
                Date fechaNacimiento = formatoFecha.parse(nextRecord[3]);
                Paciente paciente = new Paciente(
                        nextRecord[4],     // altura
                        nextRecord[5],     // peso
                        nextRecord[6],     // grupo_sanguineo
                        nextRecord[7],     // alergias
                        nextRecord[8],     // genero
                        nextRecord[12],     // pre_existencias
                        nextRecord[13],    // observaciones
                        nextRecord[0],     // rut
                        nextRecord[1],     // nombre
                        nextRecord[2],     // apellido
                        fechaNacimiento, // fecha_nacimiento
                        nextRecord[11],    // direccion
                        nextRecord[10],    // telefono
                        nextRecord[9]     // correo
                );
                pacientes.add(paciente);
            }
            i++;
        }
        inputfile.close();
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    return pacientes;
}


public ArrayList<Doctor> LeerDoctor() throws CsvValidationException {
    ArrayList<Doctor> doctores = new ArrayList<>();
    File file = new File(this.rutaDoctores);
    try {
        FileReader inputfile = new FileReader(file);
        CSVReader reader = new CSVReader(inputfile);
        String[] nextRecord;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        while ((nextRecord = reader.readNext()) != null) {
            if (i > 0) { // Ignora la cabecera
                Date fechaNacimiento = formatoFecha.parse(nextRecord[9]);
                Doctor doctor = new Doctor(
                        nextRecord[3],     // Especialidad
                        nextRecord[4],     // formacion
                        nextRecord[8],     // consulta
                        nextRecord[2],     // rut
                        nextRecord[0],     // nombre
                        nextRecord[1],     // apellido
                        fechaNacimiento, // fecha_nacimiento
                        nextRecord[5],     // direccion
                        nextRecord[7],     // telefono
                        nextRecord[6]      // correo
                );
                doctores.add(doctor);
            }
            i++;
        }
        inputfile.close();
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    return doctores;
}

    public  ArrayList<Historial> LeerHistorial(ArrayList<Paciente> pacientes) throws CsvValidationException, FileNotFoundException, IOException, ParseException {
        ArrayList<Historial> historial = new ArrayList<>();
        File file = new File(this.rutaHistorial);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);
            String[] nextRecord;
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int i = 0;
            while ((nextRecord = reader.readNext()) != null) {
                if (i > 0) { 
                    Paciente paciente = buscarPaciente(pacientes, nextRecord[0]);
                    if (paciente != null){
                        Date fecha = null;
                        fecha = formatoFecha.parse(nextRecord[1]);
                        Historial histo = new Historial(paciente, fecha, nextRecord[2], nextRecord[3], nextRecord[4]);
                        historial.add(histo);
                    }
                }
                i++;
            }
            inputfile.close();
    }catch (IOException e) {
        e.printStackTrace();
    }

    return historial;
    }
    
    public  ArrayList<Planificador> LeerPlanificador(ArrayList<Paciente> pacientes) throws CsvValidationException {
        ArrayList<Planificador> planificaciones = new ArrayList<>();
        File file = new File(this.rutaPlanificador);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);
            String[] nextRecord;
            int i = 0;
            while ((nextRecord = reader.readNext()) != null) {
                if (i > 0) { 
                    Date fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(nextRecord[0]);
                    int disponibilidad = Integer.parseInt(nextRecord[1]); //0 si esta disponible, 1 si la hora esta reservada
                    String rutPaciente = nextRecord[2];
                    Paciente ficha = buscarPaciente(pacientes, rutPaciente);
                    String observacion = nextRecord[3];
                    if (ficha != null){
                        Planificador planificador = new Planificador(fecha, disponibilidad, ficha, observacion);
                        planificaciones.add(planificador);
                    }
                }
                i++;
            }
            inputfile.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return planificaciones;
}
    public static Paciente buscarPaciente(ArrayList<Paciente>paciente, String Rut)
    {
        for(int i=0; i< paciente.size(); i++)
        {
            if(paciente.get(i).getRut().equals(Rut))
                return paciente.get(i);
        }
        return null;
    }
}


