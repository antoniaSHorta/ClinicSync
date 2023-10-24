/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.entrega2;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Entrega2 {

    public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException, ParseException {
          int opcion = -1, opcion_leer = 0;
        //leer y mostrar datos
        Scanner Entrada = new Scanner(System.in);
        Lectura lector = new Lectura("D:\\WorkSapce\\Java\\EP2\\Entrega2\\src\\test\\pacientes.csv",  
                "D:\\WorkSapce\\Java\\EP2\\Entrega2\\src\\test\\doctor.csv", 
                "D:\\WorkSapce\\Java\\EP2\\Entrega2\\src\\test\\historial.csv",
                "D:\\WorkSapce\\Java\\EP2\\Entrega2\\src\\test\\planificador.csv");
        Opciones operaciones = new Opciones();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Doctor> doctor = new ArrayList<>();
        ArrayList<Planificador> planificador = new ArrayList<>();
        ArrayList<Historial> historial = new ArrayList<>();

        while (opcion != 0) {
            operaciones.Menu();
            opcion = Entrada.nextInt();
            switch (opcion) {
                case 1 -> { //Agreagar datos
                    operaciones.Menu1();
                    opcion_leer = Entrada.nextInt();

                    if (opcion_leer == 1) {
                        pacientes = lector.LeerPaciente();
                    } else if (opcion_leer == 2) {
                        doctor = lector.LeerDoctor();
                    } else if (opcion_leer == 3) {
                        if (pacientes != null) {
                            planificador = lector.LeerPlanificador(pacientes);
                        }
                    } else if (opcion_leer == 4) {
                        if (pacientes != null) {
                            historial = lector.LeerHistorial(pacientes);
                        }
                    }
                    break;
                }
                case 3 -> {//Imprimir los datos
                    operaciones.Menu2();
                    opcion_leer = Entrada.nextInt();

                    if (opcion_leer == 1 && pacientes != null) {
                        for (int i = 0; i < pacientes.size(); i++) {
                            pacientes.get(i).mostrarPaciente();
                        }
                    }
                    if (opcion_leer == 2 && doctor != null) {
                        for(int i = 0; i < doctor.size(); i++){
                            doctor.get(i).mostrarDatosDoctor();
                        }
                    }
                    if (opcion_leer == 3 && planificador != null){
                        for(int i = 0; i < planificador.size(); i++){
                            planificador.get(i).mostrarDatosPlanificador();
                            }
                    }
                    if (opcion_leer == 4 && historial != null) {
                        for(int i = 0; i < historial.size(); i++){
                            historial.get(i).mostrarDatosHistorial();
                        }
                    }
                    break;
                }
                case 0-> System.out.println("Saliendo del programa");
                default -> System.out.println("Opcion no disponible");
            }
        }
    }
}
