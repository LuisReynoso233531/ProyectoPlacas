/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.CostoDAO;
import daos.LicenciaDAO;
import daos.PersonaDAO;
import daos.TramiteDAO;
import entidades.Costo;
import entidades.Licencia;
import entidades.Tramite;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es la interfaz de RenovarLicencia
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public class Renovarlicencia extends javax.swing.JFrame {

    /**
     * Atributo emf de tipo EntityManagerFactory
     */
    private EntityManagerFactory emf;

    /**
     * Atributo personaDAO de tipo PersonaDAO
     */
    private PersonaDAO personaDAO;

    /**
     * Atributo licenciaDAO de tipo LicenciaDAO
     */
    private LicenciaDAO licenciaDAO;
    
    /**
     * Atributo costoDAO de tipo CostoDAO
     */
    private CostoDAO costoDAO;

    /**
     * Creates new form RenovarPlacas
     */
    public Renovarlicencia() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
        personaDAO = new PersonaDAO(emf);
        licenciaDAO = new LicenciaDAO(emf);
        costoDAO = new CostoDAO(emf);
        initComponents();
        this.rellenarCosto();
    }

    /**
     * El método rellenarCosto() realiza la función de hacer Set para el
     * txtCosto a 0.
     */
    private void rellenarCosto() {
        txtCosto.setText("0");
    }

    /**
     * El método renovarLicencia() realiza la función de efectuar la renovación
     * de licencia una vez que el usuario haya llenado todos los campos de la
     * GUI Renovarlicencia, toma el RFC de un cliente, el identificador de su
     * licencia, la vigencia deseada por renovar y brinda el costo del trámite.
     */
    public void renovarLicencia() {
        String rfc = this.txtRfc.getText();
        String vigencia = cbVigencia.getSelectedItem().toString();
        int costo = Integer.parseInt(this.txtCosto.getText());
        String identificador = this.txtIdentificador.getText();
        if (vigencia.equals("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una vigencia correcta", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Date fechaInicio = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        if (vigencia.equals("1 Año")) {
            calendar.add(Calendar.YEAR, 1);
        } else if (vigencia.equals("2 Años")) {
            calendar.add(Calendar.YEAR, 2);
        } else if (vigencia.equals("3 Años")) {
            calendar.add(Calendar.YEAR, 3);
        }
        Date fechaFin = calendar.getTime();

        if (checkBoxExtravio.isSelected()) {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas renovar?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (mensaje == JOptionPane.NO_OPTION) {
                this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            } else {
                Licencia licenciaRenovada = licenciaDAO.buscarPorLicencia(identificador);
                if (licenciaRenovada != null) {
                    licenciaDAO.renovarLicencia(identificador, "Caduco");
                }
                Licencia actualizarLicencia = new Licencia(identificador, vigencia, "Activo", "Licencia", costo, fechaInicio, fechaFin, personaDAO.buscarRFC(this.txtRfc.getText()));
                licenciaDAO.agregarLicencia(actualizarLicencia);
                if (actualizarLicencia != null) {
                    JOptionPane.showMessageDialog(this, "Se ha renovado con éxito la Licencia", "", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error! No es posible renovar la Licencia", "", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            Licencia licenciaRenovada = licenciaDAO.buscarPorLicencia(identificador);
            if (licenciaRenovada != null && licenciaRenovada.getFechaFin().after(new Date())) {
                JOptionPane.showMessageDialog(this, "Aun no se ha expirado su licencia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Licencia actualizarLicencia = new Licencia(identificador, vigencia, "Activo", "Licencia", costo, fechaInicio, fechaFin, personaDAO.buscarRFC(this.txtRfc.getText()));
                licenciaDAO.renovarLicencia(identificador, "Caduco");
                licenciaDAO.agregarLicencia(actualizarLicencia);
                if (actualizarLicencia != null) {
                    JOptionPane.showMessageDialog(this, "Se ha renovado con éxito la Licencia", "", JOptionPane.INFORMATION_MESSAGE);
                    Costo nuevoCosto = new Costo(fechaInicio, costo, actualizarLicencia);
                    costoDAO.agregar(nuevoCosto);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error! No es posible renovar la Licencia", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkBoxExtravio = new javax.swing.JCheckBox();
        txtRfc = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        cbVigencia = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        checkBoxDiscapacidad = new javax.swing.JCheckBox();
        txtIdentificador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("RFC:");

        jLabel3.setText("Vigencia:");

        jLabel4.setText("Costo:");

        checkBoxExtravio.setText("¿Extravió la Licencia?");
        checkBoxExtravio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxExtravioActionPerformed(evt);
            }
        });

        txtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcActionPerformed(evt);
            }
        });

        txtCosto.setEditable(false);
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        cbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1 Año", "2 Años", "3 Años" }));
        cbVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVigenciaActionPerformed(evt);
            }
        });

        btnReporte.setText("Generar reporte");
        btnReporte.setActionCommand("Aceptar");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        checkBoxDiscapacidad.setText("¿Obtuvo una dicapacidad?");
        checkBoxDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDiscapacidadActionPerformed(evt);
            }
        });

        jLabel5.setText("Identificador:");

        jPanel1.setBackground(new java.awt.Color(51, 255, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Renovar licencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkBoxExtravio)
                                .addGap(36, 36, 36)
                                .addComponent(checkBoxDiscapacidad))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbVigencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRfc)
                                    .addComponent(txtCosto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnReporte)
                        .addGap(79, 79, 79)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxExtravio)
                    .addComponent(checkBoxDiscapacidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxExtravioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxExtravioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxExtravioActionPerformed

    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRfcActionPerformed

    /**
     * Este combobox cvVigenciaActionPerformed utiliza la vigencia que desee el
     * usuario para renovar la licencia del cliente.
     *
     * @param evt
     */
    private void cbVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVigenciaActionPerformed
        // TODO add your handling code here:
        if (cbVigencia.getSelectedItem().toString().equals("Seleccione")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(0));
            } else {
                txtCosto.setText(String.valueOf(0));
            }
        }
        if (cbVigencia.getSelectedItem().toString().equals("1 Año")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(200));
            } else {
                txtCosto.setText(String.valueOf(600));
            }
        }

        if (cbVigencia.getSelectedItem().toString().equals("2 Años")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(500));
            } else {
                txtCosto.setText(String.valueOf(900));
            }
        }

        if (cbVigencia.getSelectedItem().toString().equals("3 Años")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(700));
            } else {
                txtCosto.setText(String.valueOf(1100));
            }
        }
    }//GEN-LAST:event_cbVigenciaActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        renovarLicencia();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Este checkbox checkboxDiscapacidadActionPerformed utiliza la opción de
     * discapacidad que ingrese el usuario según el cliente en cuestión, ya sea
     * si está seleccionada la casilla o no y hará Set a txtCosto.
     *
     * @param evt
     */
    private void checkBoxDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDiscapacidadActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (cbVigencia.getSelectedItem().toString().equals("Seleccione")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(0));
            } else {
                txtCosto.setText(String.valueOf(0));
            }
        }

        if (cbVigencia.getSelectedItem().toString().equals("1 Año")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(200));
            } else {
                txtCosto.setText(String.valueOf(600));
            }
        }
        if (cbVigencia.getSelectedItem().toString().equals("2 Años")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(500));
            } else {
                txtCosto.setText(String.valueOf(900));
            }
        }
        if (cbVigencia.getSelectedItem().toString().equals("3 Años")) {
            if (checkBoxDiscapacidad.isSelected()) {
                txtCosto.setText(String.valueOf(700));
            } else {
                txtCosto.setText(String.valueOf(1100));
            }
        }


    }//GEN-LAST:event_checkBoxDiscapacidadActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbVigencia;
    private javax.swing.JCheckBox checkBoxDiscapacidad;
    private javax.swing.JCheckBox checkBoxExtravio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
