/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega2;
import java.util.ArrayList;

/**
 *
 * @author benji
 */
public class Eliminar {
    
    public void EliminarPaciente (ArrayList <Paciente> pacientes, int index){
        pacientes.remove(index);
    }
    
    public void EliminarDoctores (ArrayList <Doctor> doctores, int index){
        doctores.remove(index);
    }
    
    public void EliminarPlanificador (ArrayList <Planificador> planificados, int index){
        planificados.remove(index);
    }
    
    public void EliminarHistorial (ArrayList <Historial> historiales, int index){
        historiales.remove(index);
    }
    
    
}
