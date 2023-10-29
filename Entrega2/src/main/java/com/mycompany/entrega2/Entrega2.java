/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*
Integrantes: - Deivit Contreras Cortez
             - Benjamin Correa Vergara
             - Antonia Salinas Horta
*/

package com.mycompany.entrega2;

// Importacion de librerias //
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
import java.util.Date;

// clase "Principal"
public class Entrega2 {

    public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException, ParseException {
        
        // Definicion de datos
        int opcion = -1, opcion_leer = 0, pos = 0;
        
        //Definicion variable de Entrada, csv y de clases con sus Arraylist
        Scanner Entrada = new Scanner(System.in);
        
        Lectura lector = new Lectura("datos/pacientes.csv",  
                "datos/doctor.csv", 
                "datos/historial.csv",
                "datos/planificador.csv");
        
        Opciones operaciones = new Opciones();
        Buscar buscador = new Buscar();
        Modificar modificador = new Modificar();
        Eliminar eliminador = new Eliminar();
        
        
        ArrayList<Paciente> pacientes = lector.LeerPaciente();
        ArrayList<Doctor> doctor = lector.LeerDoctor();
        ArrayList<Planificador> planificador = lector.LeerPlanificador();
        ArrayList<Historial> historial = lector.LeerHistorial();
        
        // MENU //
        while (opcion != 0) {
            operaciones.Menu();
            opcion = Entrada.nextInt();
            
            switch (opcion) {
                /////// AGREGAR ///////
                case 1 -> { 
                    operaciones.Menu1();
                    opcion_leer = Entrada.nextInt();  
                    
                    switch (opcion_leer) {
                        // PACIENTE
                        case 1:
                            pacientes.add(lector.crearPacientePorTeclado());
                            break;
                        // DOCTOR
                        case 2:
                            doctor.add(lector.crearDoctorPorTeclado());
                            break;
                        // PLANIFICADOR
                        case 3:
                            if (pacientes != null) {
                                System.out.print("Ingrese rut paciente: ");
                                String rut = Entrada.next();
                                Entrada.nextLine();
                                pos = buscador.buscarPaciente(pacientes,rut);

                                if(pos != -1)
                                {
                                    Paciente buscado = pacientes.get(pos);
                                    planificador.add(lector.crearPlanificadorPorTeclado(buscado));
                                }
                                break;
                            }
                        // HISTORIAL  
                        case 4:
                            if (pacientes != null) {
                                System.out.print("Ingrese rut paciente: ");
                                String rut = Entrada.next();
                                Entrada.nextLine();
                                pos = buscador.buscarPaciente(pacientes,rut);

                                if(pos != -1)
                                {
                                    Paciente buscado = pacientes.get(pos);
                                    historial.add(lector.crearHistorialPorTeclado(buscado));
                                }
                                break;
                            }
                        default:
                            break;
                            }
                    break;
                }
                
                ///// MODIFICAR /////
                case 2 -> {
                    
                    operaciones.Menu2();
                    opcion_leer = Entrada.nextInt();
                    
                    switch(opcion_leer){
                        // PACIENTE 
                        case 1:
                        {
                            System.out.print("Ingrese RUT del paciente a modificar: ");
                            String rut = Entrada.nextLine();
                            Entrada.nextLine();
                            pos = buscador.buscarPaciente(pacientes, rut);
                            
                            if (pos != -1){
                                modificador.ModificarPaciente(pacientes, pos);
                            }
                            break;
                        }
                        // DOCTOR
                        case 2:
                        {
                            System.out.print("Ingrese RUT del doctor a modificar: ");
                            String rut = Entrada.nextLine();
                            Entrada.nextLine();
                            pos = buscador.buscarDoctor(doctor, rut);
                            
                            if (pos != -1){
                                modificador.ModificarDoctor(doctor, pos);
                            }
                            break;
                        }
                        // PLANIFICADOR
                        case 3:
                        {
                            System.out.print("Ingrese fecha y hora de la planificacion que quiere modificar (dd/MM/yyyy HH:mm:ss): ");
                            String horaStr = Entrada.nextLine();
                            SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            Date hora = null;
                      
                            try 
                            {
                                hora = formatoHora.parse(horaStr);
                            } 
                            catch (ParseException e){
                            }
                            
                            pos = buscador.buscarPlanificador(planificador, hora);
                            if (pos != -1){
                                modificador.ModificarPlanificador(planificador, pos);
                            }
                            break;
                        }
                        // HISTORIAL
                        case 4: {
                                System.out.print("Ingrese fecha de consulta que quiere modificar (dd/MM/yyyy): ");
                                String fechaConsultaStr = Entrada.nextLine();
                                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                                Date dia_consulta = null;
                                
                                try 
                                {
                                    dia_consulta = formatoFecha.parse(fechaConsultaStr);
                                } 
                                catch (ParseException e) {
                                }
                                
                                System.out.print("Ingrese el rut del paciente asociado: ");
                                String rut = Entrada.nextLine();
                                
                                pos = buscador.buscarHistorial(historial, dia_consulta, rut);
                                if (pos != -1){
                                    modificador.ModificarHistorial(historial, pos);
                                }
                                break;
                        }
                        default:
                            break;
                    }  
                }
                
                ////////// IMPRIMIR ///////////
                case 3 -> {
                    operaciones.Menu3();
                    opcion_leer = Entrada.nextInt();

                    if (opcion_leer == 1 && pacientes != null) {
                        for (Paciente paciente : pacientes) {
                            paciente.describir();
                        }
                    }
                    if (opcion_leer == 2 && doctor != null) {
                        for (Doctor doc : doctor) {
                            doc.describir();
                        }
                    }
                    if (opcion_leer == 3 && planificador != null) {
                        for (Planificador plan : planificador) {
                            plan.mostrarDatosPlanificador(); 
                        }
                    }
                    if (opcion_leer == 4 && historial != null) {
                        for (Historial hist : historial) {
                            hist.mostrarDatosHistorial(); 
                        }
                    }
                    break;
                }

                ///// ELIMINAR /////
                case 4 -> {
                    
                    operaciones.Menu4();
                    opcion_leer = Entrada.nextInt();
                    
                    switch (opcion_leer){
                        // ELIMINAR PACIENTES
                        case 1:
                        {
                            System.out.print("Ingrese RUT del paciente a eliminar: ");
                            String rut = Entrada.next();
                            Entrada.nextLine();
                            pos = buscador.buscarPaciente(pacientes, rut);
                            
                            if (pos != -1){
                                eliminador.EliminarPaciente(pacientes, pos);
                            }
                            break;
                        }
                        // ELIMINAR DOCTOR
                        case 2:
                        {
                            System.out.print("Ingrese RUT del doctor a eliminar: ");
                            String rut = Entrada.nextLine();
                            pos = buscador.buscarDoctor(doctor, rut);
                            
                            if (pos != -1){
                                eliminador.EliminarDoctores(doctor, pos);
                            }
                            break;
                        }
                        // ELIMINAR PLANIFICADOR
                        case 3:
                        {
                            System.out.print("Ingrese fecha y hora (dd/MM/yyyy HH:mm:ss): ");
                            String horaStr = Entrada.nextLine();
                            SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            Date hora = null;
                            
                            try 
                            {
                                hora = formatoHora.parse(horaStr);
                            } 
                            catch (ParseException e) {
                            }
                            
                            pos = buscador.buscarPlanificador(planificador, hora);
                            if (pos != -1){
                                eliminador.EliminarPlanificador(planificador, pos);
                            }
                            break;
                        }
                        // ELIMINAR HISTORIAL
                        case 4:
                        {
                            System.out.print("Ingrese fecha de consulta (dd/MM/yyyy): ");
                            String fechaConsultaStr = Entrada.nextLine();
                            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                            Date dia_consulta = null;
                            
                            try 
                            {
                                dia_consulta = formatoFecha.parse(fechaConsultaStr);
                            } 
                            catch (ParseException e) {
                            }
                            
                            System.out.print("Ingrese el rut del paciente asociado: ");
                            String rut = Entrada.nextLine();
                            pos = buscador.buscarHistorial(historial, dia_consulta, rut);
                            
                            if (pos != -1){
                                eliminador.EliminarHistorial(historial, pos);
                            }
                            break;
                        }
                        default:
                            break;
                    }
                }
                
                case 0 -> 
                {
                    System.out.println("SALIENDO DEL PROGRAMA.......");
                    // SE GUARDAN LOS DATOS MODIFICADOS //
                    Guardar guardar = new Guardar(pacientes,doctor,planificador,historial);
                    guardar.GuardarTodo();
                }
                default -> System.out.println("Opcion no disponible");
            }                    
        }    
    }
}

