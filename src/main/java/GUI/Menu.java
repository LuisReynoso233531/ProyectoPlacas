/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import daos.PersonaDAO;
import entidades.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author luis-
 */
public class Menu extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private PersonaDAO personaDAO;
    int contador=1;
    /**
     * Creates new form Menu
     */
    public Menu() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
        initComponents();
        personaDAO = new PersonaDAO(emf);
    }
    
    public void agregarMasivo() {
        if(contador==1){
              List<Persona> listaPersonas = new ArrayList<>();
        Persona persona1 = new Persona("LECJ901217A15", "Javier", "Legarreta", "Contreras", "6442567633", new Date(90, 12, 17), true);
        Persona persona2 = new Persona("QUMA470929F37", "Alfonso", "Quintero", "Montenegro", "6441166443", new Date(47, 9, 29), true);
        Persona persona3 = new Persona("MOSC900920R43", "Carolina", "Montes", "Salinas", "6441857696", new Date(90, 9, 20), false);
        Persona persona4 = new Persona("PAMM960818C21", "Mario", "Palacios", "Molina", "6442642090", new Date(96, 8, 18), false);
        Persona persona5 = new Persona("POVA011228B12", "Anya", "Polanco", "Valenzuela", "6441310840", new Date(101, 12, 28), false);
        Persona persona6 = new Persona("JITF850423V36", "Fernando", "Jimenez", "Tapia", "6442655929", new Date(85, 4, 23), true);
        Persona persona7 = new Persona("UROR981025D14", "Regina", "Urias", "Ocampo", "6442554028", new Date(98, 10, 25), false);
        Persona persona8 = new Persona("CALL020316F40", "Luis", "Cazares", "Lugo", "6441773340", new Date(102, 3, 16), true);
        Persona persona9 = new Persona("FIMJ921121G47", "Jocelyn", "Figueroa", "Martinez", "6442879091", new Date(92, 11, 21), false);
        Persona persona10 = new Persona("ANRE790614L68", "Enrique", "Angulo", "Robles", "6441902035", new Date(79, 6, 14), false);
        Persona persona11 = new Persona("RASL951211P54", "Lucia", "Ramirez", "Sanchez", "6442478321", new Date(95, 12, 11), false);
        Persona persona12 = new Persona("AGPD870217F16", "Diego", "Aguilar", "Pineda", "6441432750", new Date(87, 2, 17), false);
        Persona persona13 = new Persona("BAGS990120E64", "Silvia", "Bacasegua", "Galindo", "6442321260", new Date(99, 1, 20), true);
        Persona persona14 = new Persona("HISP821022G33", "Pedro", "Hinojos", "Sierra", "6441667710", new Date(82, 10, 22), false);
        Persona persona15 = new Persona("VIAV931130F58", "Valeria", "Villares", "Acedo", "6442401550", new Date(93, 11, 30), false);
        Persona persona16 = new Persona("CATF811216J94", "Francisco", "Cano", "Torres", "6441187021", new Date(81, 12, 16), false);
        Persona persona17 = new Persona("ESGK770518C23", "Karina", "Espinoza", "Gonzalez", "6442401550", new Date(77, 5, 18), false);
        Persona persona18 = new Persona("BOMC921124K48", "Carlos", "Bocardo", "Murillo", "6441186142", new Date(92, 11, 24), false);
        Persona persona19 = new Persona("MABA940715F32", "Alondra", "Manjarrez", "Bustillos", "6441708422", new Date(94, 7, 15), false);
        Persona persona20 = new Persona("COSP931130D45", "Paulina", "Contreras", "Soto", "6442401550", new Date(93, 11, 30), false);

        persona1 = personaDAO.agregar(persona1);
        persona2 = personaDAO.agregar(persona2);
        persona3 = personaDAO.agregar(persona3);
        persona4 = personaDAO.agregar(persona4);
        persona5 = personaDAO.agregar(persona5);
        persona6 = personaDAO.agregar(persona6);
        persona7 = personaDAO.agregar(persona7);
        persona8 = personaDAO.agregar(persona8);
        persona9 = personaDAO.agregar(persona9);
        persona10 = personaDAO.agregar(persona10);
        persona11 = personaDAO.agregar(persona11);
        persona12 = personaDAO.agregar(persona12);
        persona13 = personaDAO.agregar(persona13);
        persona14 = personaDAO.agregar(persona14);
        persona15 = personaDAO.agregar(persona15);
        persona16 = personaDAO.agregar(persona16);
        persona17 = personaDAO.agregar(persona17);
        persona18 = personaDAO.agregar(persona18);
        persona19 = personaDAO.agregar(persona19);
        persona20 = personaDAO.agregar(persona20);
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        listaPersonas.add(persona6);
        listaPersonas.add(persona7);
        listaPersonas.add(persona8);
        listaPersonas.add(persona9);
        listaPersonas.add(persona10);
        listaPersonas.add(persona11);
        listaPersonas.add(persona12);
        listaPersonas.add(persona13);
        listaPersonas.add(persona14);
        listaPersonas.add(persona15);
        listaPersonas.add(persona16);
        listaPersonas.add(persona17);
        listaPersonas.add(persona18);
        listaPersonas.add(persona19);
        listaPersonas.add(persona20);
        contador++;

        if (listaPersonas.size() == 20) {
            JOptionPane.showMessageDialog(this, "Se agregaron las 20 personas", "", JOptionPane.INFORMATION_MESSAGE);

        
        }else if(contador>=2){
            JOptionPane.showMessageDialog(this, "Ya se han agregado las personas", "", JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this, "Ya se han agregado las personas", "!!", JOptionPane.ERROR_MESSAGE);
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

        btnInsert = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSolicitarLicencia = new javax.swing.JButton();
        btnSolicitarPlacas = new javax.swing.JButton();
        btnRenovarLicencia = new javax.swing.JButton();
        btnRenovarPlacas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnInsert.setText("Insert Masivo");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 255, 102));
        jPanel2.setForeground(new java.awt.Color(0, 255, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Bienvenido al Sistema de ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Agencia de Tránsito");

        btnSolicitarLicencia.setText("Solicitar licencia");
        btnSolicitarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicenciaActionPerformed(evt);
            }
        });

        btnSolicitarPlacas.setText("Solicitar placas");
        btnSolicitarPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarPlacasActionPerformed(evt);
            }
        });

        btnRenovarLicencia.setText("Renovar licencia");
        btnRenovarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovarLicenciaActionPerformed(evt);
            }
        });

        btnRenovarPlacas.setText("Renovar placas");
        btnRenovarPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovarPlacasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("¿Qué desea hacer?");

        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(56, 56, 56))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSolicitarLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRenovarLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRenovarPlacas)
                                .addComponent(btnSolicitarPlacas))
                            .addGap(48, 48, 48))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitarLicencia)
                    .addComponent(btnSolicitarPlacas))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRenovarLicencia)
                    .addComponent(btnRenovarPlacas))
                .addGap(26, 26, 26)
                .addComponent(btnHistorial)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInsert)
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRenovarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovarLicenciaActionPerformed
        // TODO add your handling code here:
        Renovarlicencia xd = new Renovarlicencia();
        xd.setVisible(true);
    }//GEN-LAST:event_btnRenovarLicenciaActionPerformed

    private void btnSolicitarPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarPlacasActionPerformed
        // TODO add your handling code here:
        SolicitarPlacas xd = new SolicitarPlacas();
        xd.setVisible(true);
    }//GEN-LAST:event_btnSolicitarPlacasActionPerformed

    private void btnSolicitarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicenciaActionPerformed
        // TODO add your handling code here:
        SolicitarLicencia xd = new SolicitarLicencia();
        xd.setVisible(true);
    }//GEN-LAST:event_btnSolicitarLicenciaActionPerformed

    private void btnRenovarPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovarPlacasActionPerformed
        // TODO add your handling code here:
        RenovarPlacas xd = new RenovarPlacas();
        xd.setVisible(true);
    }//GEN-LAST:event_btnRenovarPlacasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres salir?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        Historial xd = new Historial();
        xd.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        agregarMasivo();
    }//GEN-LAST:event_btnInsertActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRenovarLicencia;
    private javax.swing.JButton btnRenovarPlacas;
    private javax.swing.JButton btnSolicitarLicencia;
    private javax.swing.JButton btnSolicitarPlacas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
