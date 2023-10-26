/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author benji
 */
public class Buscar {
    
    public int buscarPaciente(ArrayList<Paciente>paciente, String Rut)
    {
        for(int i=0; i< paciente.size(); i++)
        {
            if(paciente.get(i).getRut().equals(Rut)) return i;
        }
        return -1;
    }
    
    
    public int buscarDoctor(ArrayList <Doctor> doctores, String rut){
        int i;
        
        for (i = 0; i < doctores.size(); i++){
            if (doctores.get(i).getRut().equals(rut)) return i;
        }
        return -1;
    }
    
    public int buscarPlanificador(ArrayList <Planificador> planificadores, Date fecha){
        int i;
        for (i = 0; i < planificadores.size(); i++){
            if (planificadores.get(i).getHora().compareTo(fecha) == 0) return i;
        }
        return -1;
    }
    
    public int buscarHistorial(ArrayList <Historial> historiales, Date fecha, String rutPaciente){
        int i;
        for (i = 0; i < historiales.size(); i++){
            if (historiales.get(i).getDia_consulta().compareTo(fecha) == 0 &&
                    historiales.get(i).getFicha().getRut().equals(rutPaciente)) return i;
            
        }
        
        return -1;
    }
    
    
}
