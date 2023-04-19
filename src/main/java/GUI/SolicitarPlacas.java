/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.LicenciaDAO;
import daos.PersonaDAO;
import daos.PlacasDAO;
import daos.VehiculoDAO;
import entidades.Licencia;
import entidades.Placas;
import entidades.Vehiculo;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public class SolicitarPlacas extends javax.swing.JFrame {

    /**
     * Creates new form SolicitarPlacas
     */
    // Atributo emf de tipo EntityManagerFactory
    private EntityManagerFactory emf;
    // Atributo personaDAO de tipo PersonaDAO
    private PersonaDAO personaDAO;
    // Atributo vehiculoDAO de tipo VehiculoDAO
    private VehiculoDAO vehiculoDAO;
    // Atributo placasDAO de tipo PlacasDAO
    private PlacasDAO placasDAO;
    // Atributo vehiculo de tipo Vehiculo
    private Vehiculo vehiculo;
    // Atributo licenciaDAO de tipo LicenciaDAO
    private LicenciaDAO licenciaDAO;

    /**
     * Constructor
     */
    public SolicitarPlacas() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
        personaDAO = new PersonaDAO(emf);
        placasDAO = new PlacasDAO(emf);
        vehiculoDAO = new VehiculoDAO(emf);
        licenciaDAO = new LicenciaDAO(emf);
        initComponents();
        this.rellenarCosto();
    }

    /**
     * El método rellenarCosto tiene la función de hacer Set al txtCosto con el
     * valor de 1500.
     */
    private void rellenarCosto() {
        txtCosto.setText("1500");
    }

    /**
     * Este método agregarVehiculo() realiza la función de agregar un vehículo
     * tomando el RFC del cliente y los datos del vehículo en cuestión
     * ingresados por el usuario.
     */
    public void agregarVehiculo() {
        String numeroSerie = this.formatNumeroSerie.getText();
        String marca = this.txtMarca.getText();
        String modelo = this.txtModelo.getText();
        String linea = this.txtLinea.getText();
        String color = this.txtColor.getText();
        String rfc = this.txtRFC.getText();
        if (numeroSerie.isEmpty() || marca.isEmpty() || modelo.isEmpty() || linea.isEmpty() || color.isEmpty() || rfc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        if (!rfc.matches("[A-Z0-9]{13}")) {
//            JOptionPane.showMessageDialog(this, "El RFC ingresado no cuenta con el formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        Vehiculo nuevoVehiculo = new Vehiculo(numeroSerie, marca, color, modelo, linea, personaDAO.buscarRFC(this.txtRFC.getText()));
        nuevoVehiculo = vehiculoDAO.agregar(nuevoVehiculo);
        if (nuevoVehiculo != null) {
           // JOptionPane.showMessageDialog(this, "Se ha agregado con éxito un nuevo Vehículo", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * El método agregarPlacas() tiene la función de agregar las placas del
     * vehículo del cliente en cuestión, generando unas placas nuevas y
     * aleatorias.
     */
    public void agregarPlacas() {
        int costo = Integer.parseInt(this.txtCosto.getText());
        Date fechaInicio = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date fechaFin = calendar.getTime();
        String vehiculoSerie = this.formatNumeroSerie.getText();
        String identificador = this.txtIdentificador.getText();

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

        Licencia licenciaRenovada = licenciaDAO.buscarPorLicencia(identificador);
        if (licenciaRenovada != null && licenciaRenovada.getFechaFin().after(new Date())) {
            Placas nuevasPlacas = new Placas(numeroPlacas3, "Activo", vehiculoSerie, "Placas", costo, fechaInicio, fechaFin, personaDAO.buscarRFC(this.txtRFC.getText()));
            nuevasPlacas = placasDAO.agregarPlacas(nuevasPlacas);
            if (nuevasPlacas != null) {
                JOptionPane.showMessageDialog(this, "Se ha agregado con éxito una nueva Placa", "Información", JOptionPane.INFORMATION_MESSAGE);
                 dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error", "", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Su licencia ha caducado, no se pueden sacar las placas", "Información", JOptionPane.ERROR_MESSAGE);
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

        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        formatNumeroSerie = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solicitar placas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("Número de serie:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Modelo:");

        jLabel5.setText("Línea:");

        jLabel6.setText("Color:");

        jLabel7.setText("Costo:");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        txtLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLineaActionPerformed(evt);
            }
        });

        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });

        txtCosto.setEditable(false);
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jLabel8.setText("RFC:");

        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        try {
            formatNumeroSerie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatNumeroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatNumeroSerieActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Solicitar placas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
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

        jLabel9.setText("Identificador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReporte)
                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(txtModelo)
                    .addComponent(txtLinea)
                    .addComponent(txtColor)
                    .addComponent(txtCosto)
                    .addComponent(txtRFC)
                    .addComponent(formatNumeroSerie)
                    .addComponent(txtIdentificador))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(formatNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReporte)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        agregarVehiculo();
        agregarPlacas();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void formatNumeroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatNumeroSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formatNumeroSerieActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres salir?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JFormattedTextField formatNumeroSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
