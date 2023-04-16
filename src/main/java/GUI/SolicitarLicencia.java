/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.LicenciaDAO;
import daos.PersonaDAO;

import entidades.Licencia;
import entidades.Persona;
import entidades.Tramite;
import entidades.Vehiculo;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author luis-
 */
public class SolicitarLicencia extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private PersonaDAO personaDAO;
    private LicenciaDAO licenciaDAO;

    /**
     * Creates new form SolicitarLicencia
     */
    public SolicitarLicencia() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
        personaDAO = new PersonaDAO(emf);
        licenciaDAO = new LicenciaDAO(emf);
        initComponents();
        this.rellenarCosto();
    }

    private void rellenarCosto() {
        txtCosto.setText("0");
    }

    private void agregarCliente() {
        String rfc = this.txtRfc.getText();
        String nombres = this.txtNombre.getText();
        String apellidoP = this.txtApellidoP.getText();
        String apellidoM = this.txtApellidoM.getText();
        String telefono = this.txtTelefono.getText();
        Date fechaNacimiento = null;

        if (checkBoxPrimera.isSelected()) {
            if (dpFechaNacimiento.getDate() != null) {
                fechaNacimiento = Date.from(this.dpFechaNacimiento.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            } else {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (rfc.isEmpty() || nombres.isEmpty() || apellidoP.isEmpty() || telefono.isEmpty() || fechaNacimiento == null) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!telefono.matches("[0-9]{10}")) {
                JOptionPane.showMessageDialog(this, "El teléfono ingresado no cuenta con el formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fechaNacimiento.after(new Date())) {
                JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser mayor a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaNacimiento);
            cal.add(Calendar.YEAR, 18);
            Date fecha18 = cal.getTime();

            if (fecha18.after(new Date())) {
                JOptionPane.showMessageDialog(this, "El cliente debe tener al menos 18 años", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean discapacidad = this.checkBoxDiscapacidad.isSelected();
            Persona personaNueva = new Persona(rfc, nombres, apellidoP, apellidoM, telefono, fechaNacimiento, discapacidad);

            personaNueva = personaDAO.agregar(personaNueva);

            if (personaNueva != null) {
                // JOptionPane.showMessageDialog(this, "Se agregó el nuevo cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error", "", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!rfc.matches("[A-Z0-9]{13}")) {
            JOptionPane.showMessageDialog(this, "El RFC ingresado no cuenta con el formato correcto,\n Asegurese de solo insertar letras mayusculas y numeros,\n ademas de que sean 13 caracteres",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persona usuarioExistente = personaDAO.buscarRFC(rfc);
        if (usuarioExistente != null) {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario con el RFC ingresado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void solicitarLicencia() {
        String rfc = this.txtRfc.getText();
        String vigencia = cbVigencia.getSelectedItem().toString();
        int costo = Integer.parseInt(this.txtCosto.getText());

        if (vigencia.equals("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una vigencia correcta", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //zzz
        Persona usuarioNoExistente = personaDAO.buscarRFC(rfc);
        if (usuarioNoExistente == null) {
            JOptionPane.showMessageDialog(this, "No existe un usuario con el RFC ingresado", "Error", JOptionPane.ERROR_MESSAGE);
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

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 14; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        String identificador = sb.toString();

        Licencia nuevaLicencia = new Licencia(identificador, vigencia, "Activo", "Licencia", costo, fechaInicio, fechaFin, personaDAO.buscarRFC(this.txtRfc.getText()));
        licenciaDAO.agregarLicencia(nuevaLicencia);
        if (licenciaDAO != null) {
            JOptionPane.showMessageDialog(this, "Se agregó la nueva licencia", "Información", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Error", "", JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarPanel1 = new com.github.lgooddatepicker.components.CalendarPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        cbVigencia = new javax.swing.JComboBox<>();
        checkBoxDiscapacidad = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();
        dpFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        checkBoxPrimera = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solicitar licencia");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Solicitar licencia");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel2.setText("RFC");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellido Parterno");

        jLabel5.setText("Apellido Materno");

        jLabel6.setText("Vigencia");

        jLabel7.setText("Costo");

        txtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcActionPerformed(evt);
            }
        });

        txtApellidoP.setEnabled(false);
        txtApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPActionPerformed(evt);
            }
        });

        txtApellidoM.setEnabled(false);
        txtApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMActionPerformed(evt);
            }
        });

        txtCosto.setEditable(false);
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        cbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1 Año", "2 Años", "3 Años" }));
        cbVigencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVigenciaItemStateChanged(evt);
            }
        });
        cbVigencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbVigenciaMouseClicked(evt);
            }
        });
        cbVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVigenciaActionPerformed(evt);
            }
        });

        checkBoxDiscapacidad.setText("¿Tiene alguna discapacidad?");
        checkBoxDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDiscapacidadActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha de nacimiento");

        jLabel10.setText("Telefono");

        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtTelefono.setEnabled(false);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel8.setText("Insertar imagen aqui");

        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        dpFechaNacimiento.setEnabled(false);

        checkBoxPrimera.setText("¿Primera vez?");
        checkBoxPrimera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPrimeraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(txtRfc)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidoP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkBoxDiscapacidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(checkBoxPrimera)))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(61, 61, 61))))
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(btnReporte)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxDiscapacidad))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(dpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPrimera)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDiscapacidadActionPerformed
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

    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRfcActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPActionPerformed

    private void txtApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cbVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVigenciaActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        agregarCliente();
        solicitarLicencia();

    }//GEN-LAST:event_btnReporteActionPerformed

    private void cbVigenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbVigenciaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVigenciaMouseClicked

    private void cbVigenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVigenciaItemStateChanged
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

    }//GEN-LAST:event_cbVigenciaItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres salir?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void checkBoxPrimeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPrimeraActionPerformed
        // TODO add your handling code here:
        if (checkBoxPrimera.isSelected()) {
            this.txtApellidoM.setEnabled(true);
            this.txtApellidoP.setEnabled(true);
            this.txtNombre.setEnabled(true);
            this.txtTelefono.setEnabled(true);
            this.dpFechaNacimiento.setEnabled(true);
        } else {
            this.txtApellidoM.setEnabled(false);
            this.txtApellidoP.setEnabled(false);
            this.txtNombre.setEnabled(false);
            this.txtTelefono.setEnabled(false);
            this.dpFechaNacimiento.setEnabled(false);
            this.txtApellidoM.setText("");
            this.txtApellidoP.setText("");
            this.txtNombre.setText("");
            this.txtTelefono.setText("");
            this.dpFechaNacimiento.setText("");
        }

    }//GEN-LAST:event_checkBoxPrimeraActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private com.github.lgooddatepicker.components.CalendarPanel calendarPanel1;
    private javax.swing.JComboBox<String> cbVigencia;
    private javax.swing.JCheckBox checkBoxDiscapacidad;
    private javax.swing.JCheckBox checkBoxPrimera;
    private com.github.lgooddatepicker.components.DatePicker dpFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
