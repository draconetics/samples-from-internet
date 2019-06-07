/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * Principal.java
 *
 * Created on 23-jun-2011, 12:36:53
 */
package com.cpxall;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.cpxall.util.Reportes;
import com.cpxall.util.Utilidades;
import java.util.HashMap;
import java.util.Map;
import com.cpxall.conexion.ConexionOracle;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Administrador
 */
public class Principal extends javax.swing.JFrame implements Runnable {

    private final JFileChooser guardar = new JFileChooser();
    private final JFileChooser abrir = new JFileChooser();
    public static final boolean ENABLELOGGING = false;
    private static final Logger logger = Logger.getLogger(Principal.class.getName());

    /**
     * Creates new form Principal
     */
    /**
     * Creates new form frmPrincipal
     */
    public Principal() {
        abrir.addChoosableFileFilter(null);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Jrprint", "jrprint");
        abrir.setFileFilter(filtro);
        // guardar.setFileFilter (filtro);
        BasicConfigurator.configure();
        logger.info("Entrar en la aplicación");
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.add(guardar);
        this.add(abrir);
        ImageIcon icono = new ImageIcon(this.getClass().getResource("/imagenes/cpxall.png"));
        this.setIconImage(icono.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFactura = new javax.swing.JPanel();
        jComboBoxReportes = new javax.swing.JComboBox();
        jButtonGenerar = new javax.swing.JButton();
        jButtonAbrirArchivos = new javax.swing.JButton();
        jCheckBoxGuardar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cpxall - Reportes v1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        jPanelFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Impresión General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 16), new java.awt.Color(51, 51, 255))); // NOI18N

        jComboBoxReportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Generar PDF" }));
        jComboBoxReportes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxReportesItemStateChanged(evt);
            }
        });
        jComboBoxReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxReportesActionPerformed(evt);
            }
        });

        jButtonGenerar.setBackground(new java.awt.Color(0, 102, 204));
        jButtonGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back.png"))); // NOI18N
        jButtonGenerar.setMnemonic('g');
        jButtonGenerar.setText("Generar");
        jButtonGenerar.setToolTipText("Generar Factura");
        jButtonGenerar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back_f2.png"))); // NOI18N
        jButtonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarActionPerformed(evt);
            }
        });

        jButtonAbrirArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file.png"))); // NOI18N
        jButtonAbrirArchivos.setMnemonic('a');
        jButtonAbrirArchivos.setText("Abrir");
        jButtonAbrirArchivos.setToolTipText("Abrir Jrprint");
        jButtonAbrirArchivos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file.png"))); // NOI18N
        jButtonAbrirArchivos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file_f2.png"))); // NOI18N
        jButtonAbrirArchivos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file.png"))); // NOI18N
        jButtonAbrirArchivos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file.png"))); // NOI18N
        jButtonAbrirArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirArchivosActionPerformed(evt);
            }
        });

        jCheckBoxGuardar.setText("Guardar Copia");

        javax.swing.GroupLayout jPanelFacturaLayout = new javax.swing.GroupLayout(jPanelFactura);
        jPanelFactura.setLayout(jPanelFacturaLayout);
        jPanelFacturaLayout.setHorizontalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxReportes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                        .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBoxGuardar)
                            .addComponent(jButtonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jButtonAbrirArchivos)))
                .addGap(188, 188, 188))
        );
        jPanelFacturaLayout.setVerticalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFacturaLayout.createSequentialGroup()
                .addComponent(jComboBoxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jCheckBoxGuardar)
                .addGap(9, 9, 9)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAbrirArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxReportesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxReportesItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jComboBoxReportesItemStateChanged

    private void jButtonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarActionPerformed
        if (jCheckBoxGuardar.isSelected()) {
            guardar.setSelectedFile(new File("Customer"  + "-" + Utilidades.fechaDinamicaDiaMesAno()));
            int selecion = 0;
            selecion = guardar.showSaveDialog(this.jPanelFactura);
            switch (selecion) {
                case JFileChooser.APPROVE_OPTION:
                    Thread hilo = new Thread(this);
                    hilo.start();
                    break;
                //  JOptionPane.showMessageDialog(this,"Operacion Cancelada.","Informacion",JOptionPane.INFORMATION_MESSAGE);
                case JFileChooser.CANCEL_OPTION:
                    break;
                case JFileChooser.ERROR_OPTION:
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un nombre de archivo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    break;
            }
        } else {
            Thread hilo = new Thread(this);
            hilo.start();
        }

    }//GEN-LAST:event_jButtonGenerarActionPerformed

    private void jButtonAbrirArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirArchivosActionPerformed

        int selecion = 0;
        selecion = abrir.showOpenDialog(this.jPanelFactura);
        switch (selecion) {
            case JFileChooser.APPROVE_OPTION:
                try {
                    //  try {
                    // TODO add your handling code here:
                    //Reportes re= new Reportes();
                    // re.mostrarReporte(abrir.getSelectedFile().getAbsolutePath());
                    Utilidades.abrirArchivos(abrir.getSelectedFile());
                    //  } catch (FileNotFoundException ex) {
                    //  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    //} catch (JRException ex) {
                    // }
                    // }
                } catch (IOException ex) {
               logger.log(Level.SEVERE, null, ex);

                    JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
               logger.log(Level.SEVERE, null, ex);

                    JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Debe Escojer un  archivo.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Debe seleccionar un nombre de archivo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonAbrirArchivosActionPerformed

    private void jComboBoxReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxReportesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirArchivos;
    private javax.swing.JButton jButtonGenerar;
    private javax.swing.JCheckBox jCheckBoxGuardar;
    private javax.swing.JComboBox jComboBoxReportes;
    private javax.swing.JPanel jPanelFactura;
    // End of variables declaration//GEN-END:variables

    public void run() {

        start();

    }

    public void start() {
        try {
            jButtonGenerar.setText("Cargando.....");
            switch (jComboBoxReportes.getSelectedIndex()) {
                case 0:
                    //Acta de Visitas Solicitudes y Quejas

                        jButtonGenerar.setText("Cargando.....");
                        Thread.sleep(1000);
                        if (jComboBoxReportes.getSelectedIndex() == 0) {
                                Reportes reporte = new Reportes();
                                Map<String, Object> para = new HashMap<String, Object>();
                                ConexionOracle.getInstancia().conectar();
                                // File file = new File(Principal.class.getResourceAsStream("/reporte/urbaser.jpg").toString());

                               
                                if (jCheckBoxGuardar.isSelected()) {
                                    if (!reporte.jasperReport(guardar.getSelectedFile().toString(), Principal.class.getResourceAsStream("/reportes/Mi_primer_reporte.jrxml"), para, ConexionOracle.getInstancia().getConexion())) {
                                        JOptionPane.showMessageDialog(null, "La consulta no genero resultados.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } else if (!reporte.jasperReportInterno(Principal.class.getResourceAsStream("/reportes/Mi_primer_reporte.jrxml"), para, ConexionOracle.getInstancia().getConexion())) {
                                    JOptionPane.showMessageDialog(null, "La consulta no genero resultados.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                }
                                ConexionOracle.getInstancia().desconectar();
                            

                        }

                    
                    jButtonGenerar.setText("Generar");
                    break;

                default:
                    break;
            }
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        finally {
            try {
                jButtonGenerar.setText("Generar");
                ConexionOracle.getInstancia().desconectar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}