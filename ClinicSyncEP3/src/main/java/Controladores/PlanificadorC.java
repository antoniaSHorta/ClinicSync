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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author asali
 */
public class PlanificadorC implements PlanificadorDB {
    
    public String query;
    
    @Override
    public ArrayList<Planificador> Leer(Connection link, Date diaEspecifico) {
            ArrayList<Planificador> Horarios = new ArrayList<>();
            try {
                // Formato de fecha para SQL
                String strFecha = new SimpleDateFormat("yyyy-MM-dd").format(diaEspecifico);

                Statement s = link.createStatement();
                query = "SELECT * FROM planificador WHERE DATE(hora) = '" + strFecha + "' ORDER BY hora";
                ResultSet rs = s.executeQuery(query);

                while (rs.next()) {
                    Planificador planificador = new Planificador();
                    planificador.setHora(rs.getTimestamp("hora")); // Usar getTimestamp para conservar hora y fecha
                    planificador.setDisponibilidad(rs.getInt("disponibilidad"));
                    planificador.setFicha(rs.getString("rutPaciente"));
                    planificador.setObservacion(rs.getString("observacion"));

                    Horarios.add(planificador);
                }

                return Horarios;
            } catch (SQLException ex) {
                Logger.getLogger(PlanificadorC.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    
    @Override
    public boolean Crear(Connection link, Planificador planificador) {
        try {
                // La consulta SQL para insertar un nuevo planificador
                String query = "INSERT INTO planificador (observacion, disponibilidad, hora, rutDoctor, rutPaciente) VALUES (?, ?, ?, ?, ?)";

                // Preparando la consulta SQL
                try (PreparedStatement ps = link.prepareStatement(query)) {
                    // Asignando valores a los marcadores de posición en la consulta SQL
                    ps.setString(1, planificador.getObservacion());
                    ps.setInt(2, planificador.getDisponibilidad());

                    if (planificador.getHora() != null) {
                        ps.setTimestamp(3, new java.sql.Timestamp(planificador.getHora().getTime()));
                    } else {
                        ps.setNull(3, java.sql.Types.TIMESTAMP);
                    }

                    // Suponiendo que "12345678-9" es un valor de ejemplo para rutDoctor
                    ps.setString(4, "12345678-9"); 
                    ps.setString(5, planificador.getFicha());

                    // Ejecutando la consulta SQL
                    ps.executeUpdate();
                }

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al crear planificador", ex);
                System.out.println("Error SQL: " + ex.getMessage());
                return false;
            }
    }

    
    @Override
    public Planificador Buscar(Connection link, Date hora) {
        try {
            query = "SELECT * FROM planificador WHERE hora = ?";

            try (PreparedStatement ps = link.prepareStatement(query)) {
                // Configurar el parámetro de la consulta
                ps.setTimestamp(1, new java.sql.Timestamp(hora.getTime()));

                // Ejecutar la consulta
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Si se encuentra un resultado, crea un objeto Planificador y configura sus atributos
                    Planificador planificador = new Planificador();
                    // Usa getTimestamp para obtener la fecha y hora completa
                    planificador.setHora(rs.getTimestamp("hora"));
                    planificador.setDisponibilidad(rs.getInt("disponibilidad"));
                    planificador.setFicha(rs.getString("rutPaciente"));
                    planificador.setObservacion(rs.getString("observacion"));

                    return planificador;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Si no se encuentra ningún resultado, retorna null
        return null;
    }

    
    @Override
   
    
    
    public boolean Actualizar(Connection link, Planificador planificador) {
        try {
            // Ajustar la consulta para excluir la actualización de idConsulta y rutDoctor
            query = "UPDATE planificador SET observacion = ?, disponibilidad = ? WHERE hora = ?";

            try (PreparedStatement ps = link.prepareStatement(query)) {
                ps.setString(1, planificador.getObservacion());
                ps.setInt(2, planificador.getDisponibilidad());

                if (planificador.getHora() != null) {
                    // Configurar la fecha y hora completa usando Timestamp
                    ps.setTimestamp(3, new java.sql.Timestamp(planificador.getHora().getTime()));
                } else {
                    ps.setNull(3, java.sql.Types.TIMESTAMP);
                }

                // Ejecutar la consulta de actualización
                int filasAfectadas = ps.executeUpdate();

                // Verificar si se actualizó alguna fila
                return filasAfectadas > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Si no se actualizó ninguna fila, o hubo un error, retornar false
        return false;
    }



        public boolean Eliminar(Connection link, Date hora) {
        try {
            query = "DELETE FROM planificador WHERE hora = ?";

            try (PreparedStatement ps = link.prepareStatement(query)) {
                // Configurar el parámetro de la consulta
                ps.setTimestamp(1, new java.sql.Timestamp(hora.getTime()));

                // Ejecutar la consulta de eliminación
                int filasAfectadas = ps.executeUpdate();

                // Verificar si se eliminó alguna fila
                if (filasAfectadas > 0) {
                    return true; // Éxito al eliminar
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Si no se eliminó ninguna fila, o hubo un error, retornar false
        return false;
    }

    @Override
    public boolean Eliminar(Connection link, String hora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
