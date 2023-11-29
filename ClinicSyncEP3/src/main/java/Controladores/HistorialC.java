/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelos.HistorialDB;
import Modelos.Historial;
import java.util.ArrayList;
/**
 *
 * @author asali
 */
public class HistorialC implements HistorialDB {
    
    public String query;
    
    @Override
    public ArrayList<Historial> Leer(Connection link){

        try{
            Statement s = link.createStatement();
            query= "select * from historial";
            ResultSet rs=s.executeQuery(query);
            while (rs.next()){
               Historial historial = new Historial();
               historial.setFicha(rs.getString("rutPaciente"));
               historial.setDia_consulta(rs.getDate("fecha"));
               historial.setReceta_Entregada(rs.getString("recetas"));
               historial.setExamenes(rs.getString("examenes"));
               historial.setObs(rs.getString("observaciones"));

               ListaHistorial.add(historial);
                
            }
            
            return ListaHistorial;
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    
    
    
   
}