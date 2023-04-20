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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import reporte.GenerarReporte;
import reporte.Reporte;

/**
 * Esta es la interfaz de Historial
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public class Historial extends javax.swing.JFrame {

    /**
     * Atributo emf de tipo EntityManagerFactory
     */
    private EntityManagerFactory emf;
    
    /**
     * Atributo tramite de tipo Tramite
     */
    private Tramite tramite;
    
    /**
     * Atributo tramiteDAO de tipo TramiteDAO
     */
    private TramiteDAO tramiteDAO;
    
    /**
     * Atributo personaDAO de tipo PersonaDAO
     */
    private PersonaDAO personaDAO;
    
    /**
     * Atributo persona de tipo Persona
     */
    private Persona persona;
    
    /**
     * Atributo formatoFecha de tipo SimpleDateFormat
     */
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form Historial
     */
    public Historial() {
        initComponents();
        emf = Persistence.createEntityManagerFactory("ConexionPU");
        tramiteDAO = new TramiteDAO(emf);
        personaDAO = new PersonaDAO(emf);
        quitarPeriodo();
        llenarTabla();

    }

    /**
     * Método llenarTabla() que realiza el llenado de la tabla con datos de
     * tramites en la interfaz de Historial.
     */
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

    /**
     * Este método buscarTipoTramite() tiene la función de hacer la búsqueda
     * dependiendo el tipo de trámite deseado por el usuario.
     */
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

    /**
     * Este método buscarPeriodo() realiza la búsqueda para la interfaz de
     * Historial dependiendo el periodo en que se haya efectuado el trámite.
     */
    public void buscarPeriodo() {

        Date fechaInicio = null;
        Date fechaFin = null;

        if (dpFechaDespues.getDate() != null) {
            fechaInicio = Date.from(this.dpFechaDespues.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha (Despues)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dpFechaAntes.getDate() != null) {
            fechaFin = Date.from(this.dpFechaAntes.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha (Antes)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Tramite> listaTramites = this.tramiteDAO.buscarPeriodo(fechaInicio, fechaFin);
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

        //Reporte
        List<Tramite> tramites = tramiteDAO.buscarPeriodo(fechaInicio, fechaFin);
        if (tramites.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
        } else {

            List<Reporte> reportes = new LinkedList<>();
            for (Tramite tramite : tramites) {
                reportes.add(new Reporte(tramite));

            }
            GenerarReporte.generarReporte(reportes);
        }
    }

    /**
     * El método quitarPeriodo() tiene la función de quitar los periodos,
     * haciedo Set en false a los DatePicker dpFechaAntes, dpFechaDespues y al
     * botón btnPeriodo.
     */
    public void quitarPeriodo() {
        dpFechaAntes.setEnabled(false);
        dpFechaDespues.setEnabled(false);
    }

    /**
     * Este método buscarRFC() realiza la búsqueda del RFC de un cliente que ya
     * haya sido registrado y sea acorde al trámite.
     */
    public void buscarRFC() {

        String rfc = this.txtRFC.getText();

        List<Tramite> listaTramites = this.tramiteDAO.buscarRFC(rfc);
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

        //Reporte
        List<Tramite> tramites = tramiteDAO.buscarRFC(rfc);
        if (tramites.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
        } else {

            List<Reporte> reportes = new LinkedList<>();
            for (Tramite tramite : tramites) {
                reportes.add(new Reporte(tramite));

            }
            GenerarReporte.generarReporte(reportes);
        }

        if (rfc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El RFC esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * El método buscarNombre() tiene la función de realizar la búsqueda del
     * nombre de un cliente para la interfaz de Historial y sea acorde para el
     * trámite efectuado.
     */
    public void buscarNombre() {

        String nombres = this.txtNombre.getText();

        List<Tramite> listaTramites = this.tramiteDAO.buscarNombre(nombres);
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

        //Reporte
        List<Tramite> tramites = tramiteDAO.buscarNombre(nombres);
        if (tramites.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
        } else {

            List<Reporte> reportes = new LinkedList<>();
            for (Tramite tramite : tramites) {
                reportes.add(new Reporte(tramite));

            }
            GenerarReporte.generarReporte(reportes);
        }
        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTramites = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        dpFechaAntes = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dpFechaDespues = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        checkBoxPeriodo = new javax.swing.JCheckBox();
        btnReporte = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

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

        jLabel2.setText("Buscar por RFC:");

        jLabel3.setText("Buscar por tipo:");

        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
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

        jLabel4.setText("Buscar por periodo:");

        jLabel7.setText("Después de:");

        jLabel8.setText("Antes de:");

        checkBoxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpFechaAntes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpFechaDespues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkBoxPeriodo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(checkBoxPeriodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpFechaDespues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpFechaAntes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jLabel9.setText("Buscar por nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 255, 102));

        jLabel10.setText("Historial");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReporte)
                        .addGap(306, 306, 306))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(btnReporte)
                        .addGap(102, 102, 102))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void tablaTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTramitesMouseClicked
        // TODO add your handling code here:
        int seleccionar = tablaTramites.rowAtPoint(evt.getPoint());
        txtRFC.setText(String.valueOf(tablaTramites.getValueAt(seleccionar, 6)));
        txtNombre.setText(String.valueOf(tablaTramites.getValueAt(seleccionar, 5)));


    }//GEN-LAST:event_tablaTramitesMouseClicked

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        if (cbTipo.getSelectedItem().toString().equals("Todo")) {
            llenarTabla();
        } else {
            buscarTipoTramite();
        }


    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        // TODO add your handling code here:
        if (cbTipo.getSelectedItem().toString().equals("Todo")) {
            llenarTabla();
        } else {
            buscarTipoTramite();
        }

    }//GEN-LAST:event_cbTipoItemStateChanged

    /**
     * El checkbox checkBoxPeriodoActionPerformed tiene la función de habilitar
     * y hacer Set en True a los DatePicker dpFechaAntes, dpFechaDespues y
     * dpFechaInicio dependiendo si la casilla fue seleccionada.
     *
     * @param evt
     */
    private void checkBoxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPeriodoActionPerformed
        // TODO add your handling code here:
        if (checkBoxPeriodo.isSelected()) {
            dpFechaAntes.setEnabled(true);
            dpFechaDespues.setEnabled(true);
        } else {
            dpFechaAntes.setEnabled(false);
            dpFechaDespues.setEnabled(false);
            dpFechaAntes.setText("");
            dpFechaDespues.setText("");

        }
    }//GEN-LAST:event_checkBoxPeriodoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        String nombres = this.txtNombre.getText();
        Date fechaInicio = null;
        Date fechaFin = null;

        if (checkBoxPeriodo.isSelected()) {
            if (dpFechaDespues.getDate() != null) {
                fechaInicio = Date.from(this.dpFechaDespues.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha (Despues)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dpFechaAntes.getDate() != null) {
                fechaFin = Date.from(this.dpFechaAntes.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha (Antes)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dpFechaDespues.getDate() != null && dpFechaAntes.getDate() != null && nombres.isEmpty()) {
                buscarPeriodo();
                List<Tramite> tramites = tramiteDAO.buscarPeriodo(fechaInicio, fechaFin);
                if (tramites.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
                } else {

                    List<Reporte> reportes = new LinkedList<>();
                    for (Tramite tramite : tramites) {
                        reportes.add(new Reporte(tramite));

                    }
                    GenerarReporte.generarReporte(reportes);
                }
                if (tramites.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "La lista esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                List<Tramite> tramites = tramiteDAO.buscarNombrePeriodo(nombres, fechaInicio, fechaFin);
                if (tramites.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
                } else {

                    List<Reporte> reportes = new LinkedList<>();
                    for (Tramite tramite : tramites) {
                        reportes.add(new Reporte(tramite));

                    }
                    GenerarReporte.generarReporte(reportes);
                }
                if (tramites.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "La lista esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        } else {
            List<Tramite> tramites = tramiteDAO.buscarNombre(nombres);
            if (tramites.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
            } else {

                List<Reporte> reportes = new LinkedList<>();
                for (Tramite tramite : tramites) {
                    reportes.add(new Reporte(tramite));

                }
                GenerarReporte.generarReporte(reportes);
            }
            if (tramites.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La lista esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        String nombres = this.txtNombre.getText();

        List<Tramite> listaTramites = this.tramiteDAO.buscarNombre(nombres);
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
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        // TODO add your handling code here:
        String rfc = this.txtRFC.getText();

        List<Tramite> listaTramites = this.tramiteDAO.buscarRFC(rfc);
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
    }//GEN-LAST:event_txtRFCKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JCheckBox checkBoxPeriodo;
    private com.github.lgooddatepicker.components.DatePicker dpFechaAntes;
    private com.github.lgooddatepicker.components.DatePicker dpFechaDespues;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTramites;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
