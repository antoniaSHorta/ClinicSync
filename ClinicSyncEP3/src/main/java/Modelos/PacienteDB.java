/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author asali
 */
public interface PacienteDB {
    ArrayList<Paciente>ListaPaciente=new ArrayList<Paciente>();
    public boolean Crear(Connection link, Paciente paciente);
    public boolean Actualizar(Connection link, Paciente paciente);
    public boolean Eliminar(Connection link, String rut);
    public ArrayList<Paciente> Leer(Connection link);
    public Paciente Buscar(Connection link, String rut);
}
