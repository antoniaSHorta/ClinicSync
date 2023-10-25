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
import java.util.Scanner;


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
    
        
    //
    //
    //CREAR OBJETOS
    //
    //
    public Paciente crearPacientePorTeclado() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese altura: ");
    String altura = scanner.nextLine();

    System.out.print("Ingrese peso: ");
    String peso = scanner.nextLine();

    System.out.print("Ingrese grupo sanguíneo: ");
    String grupo_sanguineo = scanner.nextLine();

    System.out.print("Ingrese alergias: ");
    String alergias = scanner.nextLine();

    System.out.print("Ingrese género: ");
    String genero = scanner.nextLine();

    System.out.print("Ingrese pre-existencias: ");
    String pre_existencias = scanner.nextLine();

    System.out.print("Ingrese observaciones: ");
    String observaciones = scanner.nextLine();

    System.out.print("Ingrese RUT: ");
    String rut = scanner.nextLine();

    System.out.print("Ingrese nombre: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese apellido: ");
    String apellido = scanner.nextLine();

    System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
    String fechaNacimientoStr = scanner.nextLine();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha_nacimiento = null;
    try {
        fecha_nacimiento = formatoFecha.parse(fechaNacimientoStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    System.out.print("Ingrese dirección: ");
    String direccion = scanner.nextLine();

    System.out.print("Ingrese teléfono: ");
    String telefono = scanner.nextLine();

    System.out.print("Ingrese correo: ");
    String correo = scanner.nextLine();

    return new Paciente(altura, peso, grupo_sanguineo, alergias, genero, pre_existencias, observaciones, rut, nombre, apellido, fecha_nacimiento, direccion, telefono, correo);
}
public Doctor crearDoctorPorTeclado() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese Especialidad: ");
    String Especialidad = scanner.nextLine();

    System.out.print("Ingrese formación: ");
    String formacion = scanner.nextLine();

    System.out.print("Ingrese consulta: ");
    String consulta = scanner.nextLine();

    System.out.print("Ingrese RUT: ");
    String rut = scanner.nextLine();

    System.out.print("Ingrese nombre: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese apellido: ");
    String apellido = scanner.nextLine();

    System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
    String fechaNacimientoStr = scanner.nextLine();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha_nacimiento = null;
    try {
        fecha_nacimiento = formatoFecha.parse(fechaNacimientoStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    System.out.print("Ingrese dirección: ");
    String direccion = scanner.nextLine();

    System.out.print("Ingrese teléfono: ");
    String telefono = scanner.nextLine();

    System.out.print("Ingrese correo: ");
    String correo = scanner.nextLine();

    return new Doctor(Especialidad, formacion, consulta, rut, nombre, apellido, fecha_nacimiento, direccion, telefono, correo);
}
public Planificador crearPlanificadorPorTeclado() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese hora (HH:mm): ");
    String horaStr = scanner.nextLine();
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
    Date hora = null;
    try {
        hora = formatoHora.parse(horaStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    System.out.print("Ingrese disponibilidad (0 para libre, 1 para ocupado): ");
    int disponibilidad;
    while (true) {
        try {
            disponibilidad = Integer.parseInt(scanner.nextLine());
            if (disponibilidad == 0 || disponibilidad == 1) {
                break;
            } else {
                System.out.println("Ingrese un valor válido (0 o 1).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un valor válido (0 o 1).");
        }
    }

    // Asumiendo que tienes un método para crear un paciente por teclado, de lo contrario deberás adaptarlo.
    Paciente ficha = crearPacientePorTeclado();

    System.out.print("Ingrese observación: ");
    String observacion = scanner.nextLine();

    return new Planificador(hora, disponibilidad, ficha, observacion);
}
public Historial crearHistorialPorTeclado() {
    Scanner scanner = new Scanner(System.in);

    // Asumiendo que tienes un método para crear un paciente por teclado, de lo contrario deberás adaptarlo.
    System.out.println("Ingrese la información del paciente:");
    Paciente ficha = crearPacientePorTeclado();

    System.out.print("Ingrese fecha de consulta (dd/MM/yyyy): ");
    String fechaConsultaStr = scanner.nextLine();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date dia_consulta = null;
    try {
        dia_consulta = formatoFecha.parse(fechaConsultaStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    System.out.print("Ingrese receta entregada: ");
    String receta_Entregada = scanner.nextLine();

    System.out.print("Ingrese exámenes: ");
    String examenes = scanner.nextLine();

    System.out.print("Ingrese observaciones: ");
    String obs = scanner.nextLine();

    return new Historial(ficha, dia_consulta, receta_Entregada, examenes, obs);
}
  
}



