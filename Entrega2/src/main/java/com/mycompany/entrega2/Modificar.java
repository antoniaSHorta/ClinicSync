/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega2;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author benji
 */
public class Modificar {
    
    Scanner scanner = new Scanner(System.in);
    
    public void ModificarPaciente(ArrayList <Paciente> pacientes, int index){
        Paciente aModificar = pacientes.get(index);
        
        System.out.print("Ingrese la nueva altura: ");
        String altura = scanner.nextLine();

        System.out.print("Ingrese el nuevo peso: ");
        String peso = scanner.nextLine();

        System.out.print("Ingrese las nuevas alergias: ");
        String alergias = scanner.nextLine();

        System.out.print("Ingrese el nuevo género: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese las nuevas pre-existencias: ");
        String pre_existencias = scanner.nextLine();

        System.out.print("Ingrese nuevas observaciones: ");
        String observaciones = scanner.nextLine();

        System.out.print("Ingrese nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese nuevo apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la nueva dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el nuevo teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.nextLine();
        
        
        //Cambio de parametros
        
        aModificar.setAltura(altura);
        aModificar.setPeso(peso);
        aModificar.setAlergias(alergias);
        aModificar.setGenero(genero);
        aModificar.setCorreo(correo);
        aModificar.setPre_existencias(pre_existencias);
        aModificar.setTelefono(telefono);
        aModificar.setDireccion(direccion);
        aModificar.setObservaciones(observaciones);
        aModificar.setNombre(nombre);
        aModificar.setApellido(apellido);
        
    }
    
    
    
    public void ModificarDoctor(ArrayList <Doctor> doctores, int index){
        Doctor aModificar = doctores.get(index);
        
        System.out.print("Ingrese la nueva Especialidad: ");
        String Especialidad = scanner.nextLine();

        System.out.print("Ingrese la nueva formación: ");
        String formacion = scanner.nextLine();

        System.out.print("Ingrese la nueva consulta: ");
        String consulta = scanner.nextLine();

        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la nueva dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el nuevo teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.nextLine();
        
        aModificar.setApellido(apellido);
        aModificar.setNombre(nombre);
        aModificar.setConsulta(consulta);
        aModificar.setEspecialidad(Especialidad);
        aModificar.setCorreo(correo);
        aModificar.setDireccion(direccion);
        aModificar.setNombre(nombre);
        aModificar.setTelefono(telefono);
        aModificar.setFormacion(formacion);
        
    }
    
    public void ModificarPlanificador(ArrayList <Planificador> planificadores, int index){
        Planificador aModificar = planificadores.get(index);
        
        System.out.print("Ingrese la nueva fecha y hora (dd/MM/yyyy HH:mm:ss): ");
        String horaStr = scanner.nextLine();
        SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date hora = null;
        try {
            hora = formatoHora.parse(horaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Ingrese la nueva disponibilidad de la hora (0 para libre, 1 para ocupado): ");
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

        System.out.print("Ingrese nueva observación: ");
        String observacion = scanner.nextLine();
        
        aModificar.setHora(hora);
        aModificar.setDisponibilidad(disponibilidad);
        aModificar.setObservacion(observacion);
        
    }
    
    public void ModificarHistorial(ArrayList <Historial> historiales, int index){
        Historial aModificar = historiales.get(index);

        System.out.print("Ingrese la nueva fecha de consulta (dd/MM/yyyy): ");
        String fechaConsultaStr = scanner.nextLine();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date dia_consulta = null;
        try {
            dia_consulta = formatoFecha.parse(fechaConsultaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Ingrese la nueva receta entregada: ");
        String receta_Entregada = scanner.nextLine();

        System.out.print("Ingrese los nuevos exámenes: ");
        String examenes = scanner.nextLine();

        System.out.print("Ingrese las nuevas observaciones: ");
        String obs = scanner.nextLine();
        
        aModificar.setDia_consulta(dia_consulta);
        aModificar.setExamenes(examenes);
        aModificar.setObs(obs);
        aModificar.setReceta_Entregada(receta_Entregada);
        
    }
    
}
