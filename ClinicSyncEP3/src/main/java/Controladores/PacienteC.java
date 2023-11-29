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

import Modelos.PacienteDB;
import Modelos.Paciente;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author asali
 */
public class PacienteC implements PacienteDB {
    
    public String query;
    
    public ArrayList<Paciente> Leer(Connection link){

        try{
            Statement s = link.createStatement();
            query= "select * from paciente";
            ResultSet rs=s.executeQuery(query);
            while (rs.next()){
               Paciente paciente =new Paciente();
               paciente.setRut(rs.getString("rutPaciente"));
               paciente.setNombre(rs.getString("nombre"));
               paciente.setApellido(rs.getString("apellido"));
               paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
               paciente.setDireccion(rs.getString("direccion"));
               paciente.setTelefono(rs.getString("telefono"));
               paciente.setAltura(rs.getString("altura"));
               paciente.setPeso(rs.getString("peso"));
               paciente.setCorreo(rs.getString("correo"));
               paciente.setGrupo_sanguineo(rs.getString("grupo_sanguineo"));
               paciente.setAlergias(rs.getString("alergias"));
               paciente.setGenero(rs.getString("genero"));
               paciente.setPre_existencias(rs.getString("pre_existencias"));
               paciente.setObservaciones(rs.getString("observaciones"));
               
               ListaPaciente.add(paciente);
                
            }
            
            return ListaPaciente;
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    
    
    
    @Override
    public boolean Crear(Connection link, Paciente paciente){
        
        /*try{
            Statement s = link.createStatement();
            query = "INSERT INTO paciente(rutPaciente,nombre,apellido,fecha_nacimiento,direccion,telefono,altura,peso,correo,grupo_sanguineo,alergias,genero,pre_existencias,observaciones)VALUES('"+paciente.getRut()+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getFecha_nacimiento()+"','"+paciente.getDireccion()+"','"+paciente.getTelefono()+"','"+paciente.getAltura()+"','"+paciente.getPeso()+"','"+paciente.getCorreo()+"','"+paciente.getGrupo_sanguineo()+"','"+paciente.getAlergias()+"','"+paciente.getObservaciones()+paciente.getGenero()+"','"+paciente.getPre_existencias()+"','";
            s.executeUpdate(query);
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;*/
        try {
            String query = "INSERT INTO paciente (rutPaciente, nombre, apellido, fecha_nacimiento, direccion, telefono, altura, peso, correo, grupo_sanguineo, alergias, genero, pre_existencias, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = link.prepareStatement(query)) {
                ps.setString(1, paciente.getRut());
                ps.setString(2, paciente.getNombre());
                ps.setString(3, paciente.getApellido());
                ps.setDate(4, new java.sql.Date(paciente.getFecha_nacimiento().getTime()));
                ps.setString(5, paciente.getDireccion());
                ps.setString(6, paciente.getTelefono());
                ps.setString(7, paciente.getAltura());
                ps.setString(8, paciente.getPeso());
                ps.setString(9, paciente.getCorreo());
                ps.setString(10, paciente.getGrupo_sanguineo());
                ps.setString(11, paciente.getAlergias());
                ps.setString(12, paciente.getGenero());
                ps.setString(13, paciente.getPre_existencias());
                ps.setString(14, paciente.getObservaciones());

                ps.executeUpdate();
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public Paciente Buscar(Connection link, String rut){
        Paciente paciente=new Paciente();
        try {
            Statement s = link.createStatement();
            query="select * from paciente where rutPaciente='"+rut+"'";
            ResultSet rs=s.executeQuery(query);
            
                   
   
            while (rs.next()){
               paciente.setRut(rs.getString("rutPaciente"));
               paciente.setNombre(rs.getString("nombre"));
               paciente.setApellido(rs.getString("apellido"));
               paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
               paciente.setDireccion(rs.getString("direccion"));
               paciente.setTelefono(rs.getString("telefono"));
               paciente.setAltura(rs.getString("altura"));
               paciente.setPeso(rs.getString("peso"));
               paciente.setCorreo(rs.getString("correo"));
               paciente.setGrupo_sanguineo(rs.getString("grupo_sanguineo"));
               paciente.setAlergias(rs.getString("alergias"));
               paciente.setGenero(rs.getString("genero"));
               paciente.setPre_existencias(rs.getString("pre_existencias"));
               paciente.setObservaciones(rs.getString("observaciones"));
                
            }
            return paciente;
  
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
   
    
    public boolean Actualizar(Connection link, Paciente paciente){
        try {
        String query = "UPDATE paciente SET nombre=?, apellido=?, fecha_nacimiento=?, direccion=?, telefono=?, altura=?, peso=?, correo=?, grupo_sanguineo=?, alergias=?, genero=?, pre_existencias=?, observaciones=? WHERE rutPaciente=?";
        
        try (PreparedStatement ps = link.prepareStatement(query)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setDate(3, new java.sql.Date(paciente.getFecha_nacimiento().getTime()));
            ps.setString(4, paciente.getDireccion());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getAltura());
            ps.setString(7, paciente.getPeso());
            ps.setString(8, paciente.getCorreo());
            ps.setString(9, paciente.getGrupo_sanguineo());
            ps.setString(10, paciente.getAlergias());
            ps.setString(11, paciente.getGenero());
            ps.setString(12, paciente.getPre_existencias());
            ps.setString(13, paciente.getObservaciones());
            ps.setString(14, paciente.getRut());

            ps.executeUpdate();
        }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean Eliminar(Connection link, String rut) 
    {
        try {
            try (Statement s = link.createStatement()) 
            {
                String query = "DELETE FROM paciente WHERE rutPaciente='" + rut + "'";
                int rowsAffected = s.executeUpdate(query);
                if (rowsAffected > 0) 
            {
                return true;
            }
            }
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    return false;
}}
