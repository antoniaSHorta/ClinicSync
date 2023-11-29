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
public interface HistorialDB {
    ArrayList<Historial>ListaHistorial=new ArrayList<Historial>();
    public ArrayList<Historial> Leer(Connection link);
    public boolean Crear(Connection link, Historial historial);
}
