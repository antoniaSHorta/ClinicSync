/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asali
 */
public interface PlanificadorDB {
    ArrayList<Planificador>ListaPlanificador=new ArrayList<Planificador>();
    public boolean Crear(Connection link, Planificador planificador);
    public boolean Actualizar(Connection link, Planificador planificador);
    public boolean Eliminar(Connection link, String hora);
    public ArrayList<Planificador> Leer(Connection link);
    public Planificador Buscar(Connection link, Date hora);
}
