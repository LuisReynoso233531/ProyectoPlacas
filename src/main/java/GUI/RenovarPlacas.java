/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.CostoDAO;
import daos.PersonaDAO;
import daos.PlacasDAO;
import daos.VehiculoDAO;
import entidades.Costo;
import entidades.Persona;
import entidades.Placas;
import entidades.Vehiculo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es la interfaz de RenovarPlacas
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public class RenovarPlacas extends javax.swing.JFrame {

    /**
     * Atributo emf de tipo EntityManagerFactory
     */
    private EntityManagerFactory emf;

    /**
     * Atributo personaDAO de tipo PersonaDAO
     */
    private PersonaDAO personaDAO;

    /**
     * Atributo vehiculoDAO de tipo VehiculoDAO
     */
    private VehiculoDAO vehiculoDAO;

    /**
     * Atributo placasDAO de tipo PlacasDAO
     */
    private PlacasDAO placasDAO;

    /**
     * Atributo persona de tipo Persona
     */
    private Persona persona;

    /**
     * Atributo vehiculo de tipo Vehiculo
     */
    private Vehiculo vehiculo;
    
    /**
     * Atributo costoDAO de tipo CostoDAO
     */
    private CostoDAO costoDAO;
    
    /**
     * Creates new form RenovarPlacas
     */
    public RenovarPlacas() {

        emf = Persistence.createEntityManagerFactory("ConexionPU");
        personaDAO = new PersonaDAO(emf);
        placasDAO = new PlacasDAO(emf);
        vehiculoDAO = new VehiculoDAO(emf);
        costoDAO = new CostoDAO(emf);
        initComponents();
        this.rellenarCosto();

    }

    /**
     * El método rellenarCosto() realiza la función de hacer Set para el
     * txtCosto a 1000.
     */
    public void rellenarCosto() {
        this.txtCosto.setText("1000");
    }

    /**
     * Este método llenarTabla() tiene la función de llenar con datos de
     * vehículos la tabla en la GUI de RenovarPlacas.
     */
    public void llenarTabla() {
        String rfc = this.txtRfc.getText();
        List<Vehiculo> vehiculos = this.vehiculoDAO.buscarRFC(rfc);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblVehiculo.getModel();
        modeloTabla.setRowCount(0);
        vehiculos.forEach(vehiculo -> {
            Object[] fila = new Object[4];
            fila[0] = vehiculo.getPersonaVehiculo().getNombres();
            fila[1] = vehiculo.getPersonaVehiculo().getRfc();
            fila[2] = vehiculo.getNumeroSerie();
            modeloTabla.addRow(fila);

        });
    }

    /**
     * El método renovarPlacas() realiza la función de efectuar la renovación de
     * placas una vez que el cliente haya llenado todos los campos de la GUI
     * RenovarPlacas, toma el RFC de un cliente y brinda tanto el número de
     * serie de un vehículo como el costo del trámite.
     */
    public void renovarPlacas() {
        String rfc = this.txtRfc.getText();
        String numeroSerie = this.txtNumeroSerie.getText();
        int costo = Integer.parseInt(this.txtCosto.getText());
        Date fechaInicio = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date fechaFin = calendar.getTime();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 3; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        String numeroPlacas = sb.toString();

        StringBuilder sb2 = new StringBuilder();
        Random random2 = new Random();
        String caracteres2 = "123456789";
        for (int i = 0; i < 3; i++) {
            sb2.append(caracteres2.charAt(random2.nextInt(caracteres2.length())));
        }
        String numeroPlacas2 = sb2.toString();

        String numeroPlacas3 = numeroPlacas + "-" + numeroPlacas2;

        if (!rfc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
        }

        if (!rfc.matches("[A-Z0-9]{13}")) {
            JOptionPane.showMessageDialog(this, "El RFC ingresado no cuenta con el formato correcto,\n Asegurese de solo insertar letras mayusculas y numeros,\n ademas de que sean 13 caracteres",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (checkBoxExtravio.isSelected()) {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas renovar?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (mensaje == JOptionPane.NO_OPTION) {
                this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            } else {
                Placas renovarPlacas = new Placas(numeroPlacas3, "Activo", numeroSerie, "Placas", costo, fechaInicio, fechaFin, personaDAO.buscarRFC(rfc));
                placasDAO.actualizarPlacas(numeroSerie, "Caduco");
                placasDAO.agregarPlacas(renovarPlacas);
                if (renovarPlacas != null) {
                    JOptionPane.showMessageDialog(this, "Se ha renovado con éxito una nueva Placa", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Error!!", "Información", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            Placas placasRenovadas = placasDAO.buscarPorVehiculo(numeroSerie);
            if (placasRenovadas != null && placasRenovadas.getFechaFin().after(new Date())) {
                JOptionPane.showMessageDialog(this, "Aun no expiran sus placas", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Placas renovarPlacas = new Placas(numeroPlacas3, "Activo", numeroSerie, "Placas", costo, fechaInicio, fechaFin, personaDAO.buscarRFC(rfc));
                placasDAO.actualizarPlacas(numeroSerie, "Caduco");
                placasDAO.agregarPlacas(renovarPlacas);
                if (renovarPlacas != null) {
                    JOptionPane.showMessageDialog(this, "Se ha renovado con éxito una nueva Placa", "Información", JOptionPane.INFORMATION_MESSAGE);
                    Costo nuevoCosto = new Costo(fechaInicio, costo, renovarPlacas);
                    costoDAO.agregar(nuevoCosto);
                } else {
                    JOptionPane.showMessageDialog(this, "Error!!", "Información", JOptionPane.ERROR_MESSAGE);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkBoxExtravio = new javax.swing.JCheckBox();
        txtRfc = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculo = new javax.swing.JTable();
        txtNumeroSerie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Renovar placas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("RFC:");

        jLabel3.setText("Número de serie:");

        jLabel4.setText("Costo:");

        checkBoxExtravio.setText("¿Extravió las placas?");
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

        btnReporte.setText("Aceptar");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Renovar placas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
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

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "RFC", "Numero de serie"
            }
        ));
        tblVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVehiculo);

        txtNumeroSerie.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxExtravio)
                        .addGap(181, 181, 181))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRfc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxExtravio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnReporte))))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxExtravioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxExtravioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxExtravioActionPerformed

    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRfcActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        renovarPlacas();

    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculoMouseClicked
        // TODO add your handling code here:
        int seleccionar = tblVehiculo.rowAtPoint(evt.getPoint());
        txtNumeroSerie.setText(String.valueOf(tblVehiculo.getValueAt(seleccionar, 2)));
    }//GEN-LAST:event_tblVehiculoMouseClicked

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JCheckBox checkBoxExtravio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVehiculo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
