/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;


import Controladores.*;
import Modelos.Historial;
import Modelos.Paciente;
import Modelos.Planificador;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asali
 */
public class PlanificadorCrud extends javax.swing.JInternalFrame {

    public Conexion conexion;
    public Connection link;
    
    public PlanificadorCrud() {
        initComponents();
        conexion=new Conexion();
        link=conexion.Conectar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDisponibilidad = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        btnGuardarHistorial = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setText("Rut:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Disponibilidad:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Hora:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Observacion:");

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblMensaje.setForeground(new java.awt.Color(255, 51, 102));

        btnGuardarHistorial.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnGuardarHistorial.setText("Guardar Historial");
        btnGuardarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHistorialActionPerformed(evt);
            }
        });

        btnMostrar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(lblMensaje))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarHistorial)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensaje)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardarHistorial)
                    .addComponent(btnMostrar))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        PlanificadorC planificador=new PlanificadorC();
        Planificador ConsultaPlanificador= new Planificador(); //Esto siempre da disponibilidad 0

        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date horaSeleccionada = null;
        try {
            horaSeleccionada = formatoFecha.parse(txtHora.getText());
        } catch (ParseException ex) {
            Logger.getLogger(PlanificadorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultaPlanificador = planificador.Buscar(link, horaSeleccionada);
        
        if (ConsultaPlanificador == null) { // ESTA DESOCUPADA
                        
            lblMensaje.setText("HAY HORA!");
            
        }else{
            lblMensaje.setText("COLOQUE UNA HORA VALIDA, ESTA OCUPADA");
            Date Hora = ConsultaPlanificador.getHora();
        
            String fechaFormateada = formatoFecha.format(Hora);
            txtHora.setText(fechaFormateada);
            txtDisponibilidad.setText(String.valueOf(ConsultaPlanificador.getDisponibilidad()));
            txtRut.setText(ConsultaPlanificador.getFicha());
            txtObservacion.setText(ConsultaPlanificador.getObservacion());
        }
        

        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
                                        
    PlanificadorC planificador = new PlanificadorC();
    Planificador ConsultaPlanificador = new Planificador();
    if (txtHora == null || txtHora.getText().trim().isEmpty()) {
        lblMensaje.setText("INGRESE HORA VALIDA.");
        return;
    }

    ConsultaPlanificador.setFicha(txtRut.getText());

    try {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date hora = formatoFecha.parse(txtHora.getText());
        ConsultaPlanificador.setHora(hora);
    } catch (ParseException e) {
        e.printStackTrace();
        lblMensaje.setText("FORMATO INCORRECTO, OCUPE:  yyyy-MM-dd HH:mm:ss");
        return;
    }
    if (txtDisponibilidad == null || txtObservacion == null) {
        lblMensaje.setText("ALGUN CAMPO ES NULO");
        return;
    }

    try {
        int disponibilidad = Integer.parseInt(txtDisponibilidad.getText());
        ConsultaPlanificador.setDisponibilidad(disponibilidad);
    } catch (NumberFormatException e) {
        e.printStackTrace();
        lblMensaje.setText("DISPONIBILIDAD DEBE SER VALIDO 1 SI QUIERE AGREGAR CONSULTA 0 SI NO");
        return; 
    }

    ConsultaPlanificador.setObservacion(txtObservacion.getText());

    if (planificador.Crear(link, ConsultaPlanificador)) {
        lblMensaje.setText("SE GUARDÓ SU HORA");
    } else {
        lblMensaje.setText("NO SE PUDIERON GUARDAR SU HORA");
    }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        PlanificadorC planificador = new PlanificadorC();
        Planificador ConsultaPlanificador = new Planificador();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date horaSeleccionada = null;
        
        try {
            Date hora = formatoFecha.parse(txtHora.getText());
            ConsultaPlanificador.setHora(hora);
        } catch (ParseException e) {
            e.printStackTrace();
            lblMensaje.setText("FORMATO INCORRECTO, OCUPE:  yyyy-MM-dd HH:mm:ss");
            return;
        }
        if (txtDisponibilidad == null || txtObservacion == null) {
            lblMensaje.setText("ALGUN CAMPO ES NULO");
            return;
        }
        
        if(planificador.Eliminar(link,ConsultaPlanificador.getHora())){
            lblMensaje.setText("SE ELIMINO LA CONSULTA");
        }else{
            lblMensaje.setText("NO EXISTE CONSULTA ASOCIADA A ESTA HORA");
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        PlanificadorC planificador = new PlanificadorC();
        Planificador ConsultaPlanificador = new Planificador();

        if (txtHora == null || txtHora.getText().trim().isEmpty()) {
            lblMensaje.setText("INGRESE HORA VÁLIDA.");
            return;
        }

        ConsultaPlanificador.setFicha(txtRut.getText());

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date hora = formatoFecha.parse(txtHora.getText());
            ConsultaPlanificador.setHora(hora);
        } catch (ParseException e) {
            e.printStackTrace();
            lblMensaje.setText("FORMATO INCORRECTO, OCUPA: yyyy-MM-dd HH:mm:ss");
            return;
        }

        if (txtDisponibilidad == null || txtObservacion == null) {
            lblMensaje.setText("ALGÚN CAMPO ES NULO");
            return;
        }

        try {
            int disponibilidad = Integer.parseInt(txtDisponibilidad.getText());
            ConsultaPlanificador.setDisponibilidad(disponibilidad);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            lblMensaje.setText("DISPONIBILIDAD DEBE SER UN NÚMERO VÁLIDO (1 PARA AGREGAR CONSULTA, 0 PARA NO)");
            return; 
        }

        ConsultaPlanificador.setObservacion(txtObservacion.getText());

        if (planificador.Actualizar(link, ConsultaPlanificador)) {
            lblMensaje.setText("SE ACTUALIZÓ LA CONSULTA");
        } else {
            lblMensaje.setText("NO SE PUDO ACTUALIZAR LA CONSULTA");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHistorialActionPerformed
        // Validar que los campos estén llenos y que txtHora tenga el formato correcto
        if (txtRut.getText().isEmpty() || txtHora.getText().isEmpty()) {
            // Mostrar un mensaje de error o realizar alguna acción según tus necesidades
            return;
        }

        Historial historialActual = new Historial();
        historialActual.setFicha(txtRut.getText());

        // Convertir la fecha de txtHora a formato Date
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date fechaHora = formatoFecha.parse(txtHora.getText());

            // Verificar si el formato es correcto
            String fechaHoraFormateada = formatoFecha.format(fechaHora);
            if (!txtHora.getText().equals(fechaHoraFormateada)) {
                // Mostrar un mensaje de error o realizar alguna acción según tus necesidades
                return;
            }

            historialActual.setDia_consulta(fechaHora);
        } catch (ParseException ex) {
            // Manejar la excepción según tus necesidades
            ex.printStackTrace();
            return;
        }

        // Abrir la nueva vista con el historial creado
        HistorialAgregar historialVista = new HistorialAgregar(historialActual);
        historialVista.setVisible(true);
        this.getParent().add(historialVista);
    }//GEN-LAST:event_btnGuardarHistorialActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // Crear una nueva instancia de PlanificadorReporte
        PlanificadorReporte reporte = new PlanificadorReporte();

        // Hacer visible la ventana de reporte
        reporte.setVisible(true);
    }//GEN-LAST:event_btnMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarHistorial;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtDisponibilidad;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
