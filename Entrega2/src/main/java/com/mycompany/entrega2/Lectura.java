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
                Date fechaNacimiento = formatoFecha.parse(nextRecord[3]);
                Doctor doctor = new Doctor(
                        nextRecord[7],     // Especialidad
                        nextRecord[8],     // formacion
                        nextRecord[9],     // consulta
                        nextRecord[0],     // rut
                        nextRecord[1],     // nombre
                        nextRecord[2],     // apellido
                        fechaNacimiento,   // fecha_nacimiento
                        nextRecord[4],     // direccion
                        nextRecord[5],     // telefono
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


public ArrayList<Historial> LeerHistorial() throws CsvValidationException, FileNotFoundException, IOException, ParseException {
    ArrayList<Historial> historial = new ArrayList<>();
    File file = new File(this.rutaHistorial);
    try {
        FileReader inputfile = new FileReader(file);
        CSVReader reader = new CSVReader(inputfile);
        String[] nextRecord;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        int i = 0;
        while ((nextRecord = reader.readNext()) != null) {
            if (i > 0) { // Salta el header
                Date fechaNacimiento = formatoFecha.parse(nextRecord[3]);
                Paciente paciente = new Paciente(
                        nextRecord[7],  // altura
                        nextRecord[8],  // peso
                        nextRecord[9],  // grupo_sanguineo
                        nextRecord[10], // alergias
                        nextRecord[11], // genero
                        nextRecord[12], // pre_existencias
                        nextRecord[13], // observaciones
                        nextRecord[0],  // rut
                        nextRecord[1],  // nombre
                        nextRecord[2],  // apellido
                        fechaNacimiento, // fecha_nacimiento
                        nextRecord[4],  // direccion
                        nextRecord[5],  // telefono
                        nextRecord[6]   // correo
                );
                Date fechaConsulta = formatoFecha.parse(nextRecord[14]);
                Historial histo = new Historial(
                        paciente, 
                        fechaConsulta, 
                        nextRecord[15], // receta_Entregada
                        nextRecord[16], // examenes
                        nextRecord[17]  // obs
                );
                historial.add(histo);
            }
            i++;
        }
        inputfile.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return historial;
}

public ArrayList<Planificador> LeerPlanificador() throws CsvValidationException {
    ArrayList<Planificador> planificaciones = new ArrayList<>();
    File file = new File(this.rutaPlanificador);
    try {
        FileReader inputfile = new FileReader(file);
        CSVReader reader = new CSVReader(inputfile);
        String[] nextRecord;
        int i = 0;
        while ((nextRecord = reader.readNext()) != null) {
            if (i > 0) { 
                Date fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(nextRecord[0]);
                int disponibilidad = Integer.parseInt(nextRecord[1]); //0 si esta disponible, 1 si la hora esta reservada
                
                // Crear objeto Paciente desde el CSV
                Paciente ficha = new Paciente(
                    nextRecord[9],  // altura
                    nextRecord[10], // peso
                    nextRecord[11], // grupo_sanguineo
                    nextRecord[12], // alergias
                    nextRecord[13], // genero
                    nextRecord[14], // pre_existencias
                    nextRecord[15], // observaciones
                    nextRecord[2],  // rut
                    nextRecord[3],  // nombre
                    nextRecord[4],  // apellido
                    new SimpleDateFormat("dd/MM/yyyy").parse(nextRecord[5]), // fecha_nacimiento
                    nextRecord[6],  // direccion
                    nextRecord[7],  // telefono
                    nextRecord[8]   // correo
                );
                
                String observacion = nextRecord[16];
                
                Planificador planificador = new Planificador(fecha, disponibilidad, ficha, observacion);
                planificaciones.add(planificador);
            }
            i++;
        }
        inputfile.close();
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    return planificaciones;
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

//Al crear el panificador, recibe un objeto paciente, este objeto debe estar creado dentro del arraylist paciente y por medio del metodo buscar paciente
//si existe este paciente se llama a esta funcion para que se cree la planificacion, si no existe el paciente no se agregara la ficha
public Planificador crearPlanificadorPorTeclado(Paciente paciente) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese fecha y hora (dd/MM/yyyy HH:mm:ss): ");
    String horaStr = scanner.nextLine();
    SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
    Paciente ficha = paciente;

    System.out.print("Ingrese observación: ");
    String observacion = scanner.nextLine();

    return new Planificador(hora, disponibilidad, ficha, observacion);
}
public Historial crearHistorialPorTeclado(Paciente paciente) {
    Scanner scanner = new Scanner(System.in);

    // Asumiendo que tienes un método para crear un paciente por teclado, de lo contrario deberás adaptarlo.
    System.out.println("Ingrese la información del paciente:");
    Paciente ficha = paciente;

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



