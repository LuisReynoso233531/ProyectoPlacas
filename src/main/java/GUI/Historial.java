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
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public class Historial extends javax.swing.JFrame {

    // Atributo emf de tipo EntityManagerFactory
    private EntityManagerFactory emf;
    // Atributo tramite de tipo Tramite
    private Tramite tramite;
    // Atributo tramiteDAO de tipo TramiteDAO
    private TramiteDAO tramiteDAO;
    // Atributo personaDAO de tipo PersonaDAO
    private PersonaDAO personaDAO;
    // Atributo persona de tipo Persona
    private Persona persona;
    // Atributo formatoFecha de tipo SimpleDateFormat
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
     * Método buscarPorFecha() que realiza la búsqueda para la interfaz de
     * Historial dependiendo la fecha en que se haya efectuado el trámite.
     */
    public void buscarPorFecha() {

        Date fecha = null;

        if (dpFechaInicio.getDate() != null) {
            fecha = Date.from(this.dpFechaInicio.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

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
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Reporte
        List<Tramite> tramites = tramiteDAO.buscarPorFecha(fecha);
        if (tramites.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron los tramites", "", JOptionPane.ERROR_MESSAGE);
        } else {

            List<Reporte> reportes = new LinkedList<>();
            for (Tramite tramite : tramites) {
                reportes.add(new Reporte(tramite));

            }
            GenerarReporte.generarReporte(reportes);
        }

        if (fecha.after(new Date())) {
            JOptionPane.showMessageDialog(this, "No se puede buscar un tramite con fecha mayor a hoy", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    /**
     * El método buscarPorId() tiene la función de realizar la búsqueda para la
     * interfaz de Historial dependiendo el ID correspondiente para el trámite.
     */
    public void buscarPorId() {

        String Stringid = this.txtID.getText();
        if (Stringid.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de ID está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(Stringid);

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

        //Reporte
        List<Tramite> tramites = tramiteDAO.buscarPorId(id);
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
        btnPeriodo.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        dpFechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        btnBuscarFecha = new javax.swing.JButton();
        btnBuscarID = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dpFechaAntes = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dpFechaDespues = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        checkBoxPeriodo = new javax.swing.JCheckBox();
        btnPeriodo = new javax.swing.JButton();
        btnRFC = new javax.swing.JButton();
        btnNombre = new javax.swing.JButton();
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

        jLabel1.setText("Buscar por ID:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por RFC:");

        jLabel3.setText("Buscar por tipo:");

        jLabel5.setText("Buscar por fecha");

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

        jLabel4.setText("Buscar por periodo:");

        jLabel7.setText("Después de:");

        jLabel8.setText("Antes de:");

        checkBoxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPeriodoActionPerformed(evt);
            }
        });

        btnPeriodo.setText("Buscar periodo");
        btnPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoActionPerformed(evt);
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
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnPeriodo)))
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
                .addGap(18, 18, 18)
                .addComponent(btnPeriodo)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnRFC.setText("Buscar RFC");
        btnRFC.setToolTipText("");
        btnRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRFCActionPerformed(evt);
            }
        });

        btnNombre.setText("Buscar nombre");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        jLabel9.setText("Buscar por nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarFecha)
                        .addGap(70, 70, 70)
                        .addComponent(btnBuscarID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNombre)
                        .addGap(88, 88, 88)
                        .addComponent(btnRFC)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarFecha)
                            .addComponent(btnBuscarID)
                            .addComponent(btnNombre)
                            .addComponent(btnRFC))
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
            btnPeriodo.setEnabled(true);
            dpFechaInicio.setEnabled(false);
            dpFechaInicio.setText("");
        } else {
            dpFechaAntes.setEnabled(false);
            dpFechaDespues.setEnabled(false);
            btnPeriodo.setEnabled(false);
            dpFechaInicio.setEnabled(true);
            dpFechaAntes.setText("");
            dpFechaDespues.setText("");

        }
    }//GEN-LAST:event_checkBoxPeriodoActionPerformed

    private void btnPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoActionPerformed
        // TODO add your handling code here:
        buscarPeriodo();
    }//GEN-LAST:event_btnPeriodoActionPerformed

    private void btnRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRFCActionPerformed
        // TODO add your handling code here:
        buscarRFC();
    }//GEN-LAST:event_btnRFCActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        // TODO add your handling code here:
        buscarNombre();
    }//GEN-LAST:event_btnNombreActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JButton btnBuscarID;
    private javax.swing.JButton btnNombre;
    private javax.swing.JButton btnPeriodo;
    private javax.swing.JButton btnRFC;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JCheckBox checkBoxPeriodo;
    private com.github.lgooddatepicker.components.DatePicker dpFechaAntes;
    private com.github.lgooddatepicker.components.DatePicker dpFechaDespues;
    private com.github.lgooddatepicker.components.DatePicker dpFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTramites;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
