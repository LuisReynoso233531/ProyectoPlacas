/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.PersonaDAO;
import daos.TramiteDAO;
import entidades.Persona;
import entidades.Tramite;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis-
 */
public class Historial extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private Tramite tramite;
    private TramiteDAO tramiteDAO;
    private PersonaDAO personaDAO;

    private Persona persona;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form Historial
     */
    public Historial() {
        initComponents();
        emf = Persistence.createEntityManagerFactory("ConexionPU");
        tramiteDAO = new TramiteDAO(emf);
        personaDAO = new PersonaDAO(emf);
        llenarTabla();
    }

    public void llenarTabla() {
        List<Tramite> listaTramites = this.tramiteDAO.mostrarTramite();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaTramites.getModel();
        modeloTabla.setRowCount(0);
        listaTramites.forEach(tramite -> {
            Object[] fila = new Object[7];
            fila[0] = tramite.getId();
            fila[1] = tramite.getTipo();
            fila[2] = tramite.getPersonasTramite().getId();
            fila[3] = tramite.getCosto();
            fila[4] = formatoFecha.format(tramite.getFechaInicio().getTime());
            fila[5] = tramite.getPersonasTramite().getNombres();
            fila[6] = tramite.getPersonasTramite().getRfc();

            modeloTabla.addRow(fila);

        });
    }

    public void buscarTipoTramite() {

        String tipo = this.cbTipo.getSelectedItem().toString();

        List<Tramite> listaTramites = this.tramiteDAO.buscarTipo(tipo);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaTramites.getModel();
        modeloTabla.setRowCount(0);
        listaTramites.forEach(tramite -> {
            Object[] fila = new Object[7];
            fila[0] = tramite.getId();
            fila[1] = tramite.getTipo();
            fila[2] = tramite.getPersonasTramite().getId();
            fila[3] = tramite.getCosto();
            fila[4] = formatoFecha.format(tramite.getFechaInicio().getTime());
            fila[5] = tramite.getPersonasTramite().getNombres();
            fila[6] = tramite.getPersonasTramite().getRfc();

            modeloTabla.addRow(fila);

        });

    }

    public void buscarPorFecha() {

        Date fecha = Date.from(this.dpFechaInicio.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Tramite> listaTramites = this.tramiteDAO.buscarPorFecha(fecha);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaTramites.getModel();
        modeloTabla.setRowCount(0);
        listaTramites.forEach(tramite -> {
            Object[] fila = new Object[7];
            fila[0] = tramite.getId();
            fila[1] = tramite.getTipo();
            fila[2] = tramite.getPersonasTramite().getId();
            fila[3] = tramite.getCosto();
            fila[4] = formatoFecha.format(tramite.getFechaInicio().getTime());
            fila[5] = tramite.getPersonasTramite().getNombres();
            fila[6] = tramite.getPersonasTramite().getRfc();

            modeloTabla.addRow(fila);

        });

        if (fecha.after(new Date())) {
            JOptionPane.showMessageDialog(this, "No se puede buscar un tramite con fecha mayor a hoy", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    public void buscarPorId() {

        int id = Integer.parseInt(this.txtID.getText());

        List<Tramite> listaTramites = this.tramiteDAO.buscarPorId(id);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaTramites.getModel();
        modeloTabla.setRowCount(0);
        listaTramites.forEach(tramite -> {
            Object[] fila = new Object[7];
            fila[0] = tramite.getId();
            fila[1] = tramite.getTipo();
            fila[2] = tramite.getPersonasTramite().getId();
            fila[3] = tramite.getCosto();
            fila[4] = formatoFecha.format(tramite.getFechaInicio().getTime());
            fila[5] = tramite.getPersonasTramite().getNombres();
            fila[6] = tramite.getPersonasTramite().getRfc();

            modeloTabla.addRow(fila);

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTramites = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        dpFechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        btnBuscarFecha = new javax.swing.JButton();
        btnBuscarID = new javax.swing.JButton();

        setTitle("Historial");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tablaTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "ID_Cliente", "Costo", "Fecha", "Nombres", "RFC"
            }
        ));
        tablaTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTramites);

        jLabel1.setText("Buscar por ID");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por RFC");

        jLabel3.setText("Buscar por tipo");

        jLabel5.setText("Buscar por fecha");

        jLabel6.setText("Nose como hacer esto xdxd");

        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Licencia", "Placas" }));
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        dpFechaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dpFechaInicioMouseClicked(evt);
            }
        });

        btnBuscarFecha.setText("Buscar Fecha");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });

        btnBuscarID.setText("Buscar ID");
        btnBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel6)
                .addGap(103, 103, 103)
                .addComponent(btnBuscarFecha)
                .addGap(62, 62, 62)
                .addComponent(btnBuscarID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtRFC)
                                    .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarFecha)
                        .addComponent(btnBuscarID)))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres salir?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void tablaTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTramitesMouseClicked
        // TODO add your handling code here:
        int seleccionar = tablaTramites.rowAtPoint(evt.getPoint());
        txtID.setText(String.valueOf(tablaTramites.getValueAt(seleccionar, 0)));
        txtRFC.setText(String.valueOf(tablaTramites.getValueAt(seleccionar, 6)));
        dpFechaInicio.setText(String.valueOf(tablaTramites.getValueAt(seleccionar, 4)));

    }//GEN-LAST:event_tablaTramitesMouseClicked

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        // TODO add your handling code here:
        if (cbTipo.getSelectedItem().toString().equals("Todo")) {
            llenarTabla();
        } else {
            buscarTipoTramite();
        }

    }//GEN-LAST:event_cbTipoItemStateChanged

    private void dpFechaInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dpFechaInicioMouseClicked
        // TODO add your handling code here:
        buscarPorFecha();

    }//GEN-LAST:event_dpFechaInicioMouseClicked

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
        // TODO add your handling code here:
        buscarPorFecha();

    }//GEN-LAST:event_btnBuscarFechaActionPerformed

    private void btnBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIDActionPerformed
        // TODO add your handling code here:
        buscarPorId();
    }//GEN-LAST:event_btnBuscarIDActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JButton btnBuscarID;
    private javax.swing.JComboBox<String> cbTipo;
    private com.github.lgooddatepicker.components.DatePicker dpFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTramites;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
