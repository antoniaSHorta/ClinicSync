/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.entrega2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;


public class Entrega2 {

    public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException, ParseException {
        int opcion = -1, opcion_leer = 0;
        
        //Asegurarse de poner bien la ruta
        Scanner Entrada = new Scanner(System.in);
        Lectura lector = new Lectura("D:\\WorkSapce\\Java\\Entrega2\\src\\test\\pacientes.csv",  
                "D:\\WorkSapce\\Java\\Entrega2\\src\\test\\doctor.csv", 
                "D:\\WorkSapce\\Java\\Entrega2\\src\\test\\historial.csv",
                "D:\\WorkSapce\\Java\\Entrega2\\src\\test\\planificador.csv");
        Opciones operaciones = new Opciones();
        ArrayList<Paciente> pacientes = lector.LeerPaciente();
        ArrayList<Doctor> doctor = lector.LeerDoctor();
        ArrayList<Planificador> planificador = lector.LeerPlanificador();
        ArrayList<Historial> historial = lector.LeerHistorial();
        
        //MENU
        while (opcion != 0) {
            operaciones.Menu();
            
            opcion = Entrada.nextInt();
            switch (opcion) {
                case 1 -> { //Agreagar datos
                  
                    operaciones.Menu1();
                    opcion_leer = Entrada.nextInt();
                                
                    if (opcion_leer == 1) {
                        pacientes.add(lector.crearPacientePorTeclado());
                    } else if (opcion_leer == 2) {
                        doctor.add(lector.crearDoctorPorTeclado());
                    } else if (opcion_leer == 3) {
                        if (pacientes != null) {
                            //Revisar forma de agregar para minimizar codigo
                            System.out.print("Ingrese rut paciente:");
                            String rut = Entrada.next();
                            Entrada.nextLine();
                            Paciente buscado = lector.buscarPaciente(pacientes,rut);
                            if(buscado != null)
                            {
                             planificador.add(lector.crearPlanificadorPorTeclado(buscado));
                            }
                        }
                    } else if (opcion_leer == 4) {
                        if (pacientes != null) {
                            System.out.print("Ingrese rut paciente:");
                            String rut = Entrada.next();
                            Entrada.nextLine();
                            Paciente buscado = lector.buscarPaciente(pacientes, rut);
                            if (buscado!= null)
                            {
                                historial.add(lector.crearHistorialPorTeclado(buscado));
                            }
                            
                        }
                    }
                    break;
                }
                
                case 3 -> {//Imprimir los datos
                    operaciones.Menu2();
                    opcion_leer = Entrada.nextInt();

                    if (opcion_leer == 1 && pacientes != null) {
                        for (int i = 0; i < pacientes.size(); i++) {
                            pacientes.get(i).mostrarPaciente();
                        }
                    }
                    if (opcion_leer == 2 && doctor != null) {
                        for(int i = 0; i < doctor.size(); i++){
                            doctor.get(i).mostrarDatosDoctor();
                        }
                    }
                    if (opcion_leer == 3 && planificador != null){
                        for(int i = 0; i < planificador.size(); i++){
                            planificador.get(i).mostrarDatosPlanificador();
                            }
                    }
                    if (opcion_leer == 4 && historial != null) {
                        for(int i = 0; i < historial.size(); i++){
                            historial.get(i).mostrarDatosHistorial();
                        }
                    }
                    break;
                }
                case 0-> {
                System.out.println("Saliendo del programa");
                EscribirPaciente(pacientes);
                EscribirDoctor(doctor);
                EscribirHistorial(historial);
                EscribirPlanificador(planificador);
                }
                default -> System.out.println("Opcion no disponible");
            }
                //String[] header = {"rut","Nombre","Apellido","fecha_Nacimiento","altura","peso","grupo_Sanguineo","alergias","genero","telefono","correo","direccion","pre_Existencias","observaciones"};              
        }    
    }
     
public static void EscribirPaciente(ArrayList<Paciente> pacientes) {
    File file = new File("D:\\workspace\\Java\\ClinicSync\\Entrega2\\src\\test\\pacientes.csv");
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    String[] header = {"rut","Nombre","Apellido","fecha_Nacimiento","altura","peso","grupo_Sanguineo","alergias","genero","telefono","correo","direccion","pre_Existencias","observaciones"};
    try (
        FileWriter outputfile = new FileWriter(file, false);
        CSVWriter writer = new CSVWriter(outputfile)
    ) {
        writer.writeNext(header);
        
        for (Paciente paciente : pacientes) {
            String[] data = {
                paciente.getRut(),
                paciente.getNombre(),
                paciente.getApellido(),
                formatoFecha.format(paciente.getFecha_nacimiento()).toString(),
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
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void EscribirDoctor(ArrayList<Doctor> doctores) {
    File file = new File("D:\\WorkSapce\\Java\\Entrega2\\src\\test\\doctor.csv");
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    String []header = {"Nombre","Apellido","rut","Especialidad","Formacion","Direccion","Correo","Telefono","Consulta","fechaNacimiento"};
    try (
        FileWriter outputfile = new FileWriter(file, false);
        CSVWriter writer = new CSVWriter(outputfile)
    ) {
        writer.writeNext(header);
        
        for (Doctor doctor : doctores) {
            String[] data = {
                doctor.getRut(),
                doctor.getNombre(),
                doctor.getApellido(),
                formatoFecha.format(doctor.getFecha_nacimiento()).toString(),
                doctor.getDireccion(),
                doctor.getTelefono(),
                doctor.getCorreo(),
                doctor.getEspecialidad(),
                doctor.getFormacion(),
                doctor.getConsulta()
            };
            writer.writeNext(data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public static void EscribirHistorial(ArrayList<Historial> historiales) {
    File file = new File("D:\\WorkSapce\\Java\\Entrega2\\src\\test\\historial.csv");
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    String[] header = {
        "rut", "nombre", "apellido", "fecha_nacimiento", "direccion", "telefono", "correo", 
        "altura", "peso", "grupo_sanguineo", "alergias", "genero", "pre_existencias", "observaciones", 
        "dia_consulta", "receta_Entregada", "examenes", "obs"
    };

    try (
        FileWriter outputfile = new FileWriter(file, false);
        CSVWriter writer = new CSVWriter(outputfile)
    ) {
        writer.writeNext(header);
        
        for (Historial historial : historiales) {
            Paciente paciente = historial.getFicha();
            String[] data = {
                paciente.getRut(),
                paciente.getNombre(),
                paciente.getApellido(),
                formatoFecha.format(paciente.getFecha_nacimiento()).toString(),
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
                formatoFecha.format(historial.getDia_consulta()).toString(),
                historial.getReceta_Entregada(),
                historial.getExamenes(),
                historial.getObs()
            };
            writer.writeNext(data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public static void EscribirPlanificador(ArrayList<Planificador> planificaciones) {
    File file = new File("D:\\WorkSapce\\Java\\Entrega2\\src\\test\\planificador.csv");
    
    SimpleDateFormat formatoHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Formato para la fecha y hora
    SimpleDateFormat formatoFechaNacimiento = new SimpleDateFormat("dd-MM-yyyy"); // Formato para fecha de nacimiento
    String []header = {
        "hora", "disponibilidad", "rut", "nombre", "apellido", "fecha_nacimiento", 
        "direccion", "telefono", "correo", "altura", "peso", "grupo_sanguineo", 
        "alergias", "genero", "pre_existencias", "observaciones", "observacion_planificador"
    };


    try (
        FileWriter outputfile = new FileWriter(file, false);
        CSVWriter writer = new CSVWriter(outputfile)
    ) {
        writer.writeNext(header);
        
        for (Planificador plan : planificaciones) {
            Paciente ficha = plan.getFicha();
            String[] data = {
                formatoHora.format(plan.getHora()).toString(),
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
        e.printStackTrace();
    }
}

}

