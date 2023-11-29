/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import Modelos.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelos.PlanificadorDB;
import Modelos.Planificador;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author asali
 */
public class PlanificadorC implements PlanificadorDB {
    
    public String query;
    
    public ArrayList<Planificador> Leer(Connection link){

        try{
            Statement s = link.createStatement();
            query= "select * from planificador";
            ResultSet rs=s.executeQuery(query);
            while (rs.next()){
               Planificador planificador = new Planificador();
               planificador.setHora(rs.getDate("hora"));
               planificador.setDisponibilidad(rs.getInt("disponibilidad"));
               planificador.setFicha(rs.getString("ficha"));
               planificador.setObservacion(rs.getString("observacion"));
               
               ListaPlanificador.add(planificador);
                
            }
            
            return ListaPlanificador;
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    
    
    
    @Override
    public boolean Crear(Connection link, Planificador planificador){
    try {
        //String query = "INSERT INTO planificador (rutPaciente, hora, disponibilidad, ficha, observacion) VALUES (?, ?, ?, ?, ?)";
        String query = "INSERT INTO planificador (observacion, idConsulta, disponibilidad, hora, rutDoctor, rutPaciente) VALUES (?, ?, ?, ?, ?, ?)";
        int i = 2;
        try (PreparedStatement ps = link.prepareStatement(query)) {
            ps.setString(5, "12345678-9");
            ps.setString(6, planificador.getFicha());
            ps.setInt(2, i+1);

            if (planificador.getHora() != null) {
                ps.setDate(4, new java.sql.Date(planificador.getHora().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.TIMESTAMP);
            }
            
            ps.setInt(3, planificador.getDisponibilidad());
            ps.setString(1, planificador.getObservacion());

            ps.executeUpdate();
        }

        return true;
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false;
}
    
    public Planificador Buscar(Connection link, Date hora){
     
        return null;
    }
    
    @Override
   
    
    public boolean Actualizar(Connection link, Planificador planificador){
        return false;
    }

    public boolean Eliminar(Connection link, Date hora) 
    {

        return false;
    }

    @Override
    public boolean Eliminar(Connection link, String hora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
