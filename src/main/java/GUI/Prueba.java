/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import daos.TramiteDAO;
import entidades.Licencia;
import entidades.Persona;
import entidades.Placas;
import entidades.Tramite;
import entidades.Vehiculo;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import persistencias.ITramite;
import reporte.GenerarReporte;
import reporte.Reporte;

/**
 * Esta es la clase Prueba
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public class Prueba {

    /**
     * Método main de la clase Prueba
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Menu xd = new Menu();
        xd.setVisible(true);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//
//        ITramite tramiteDAO = new TramiteDAO(emf);
//
////        String nombres = "xd";
////
////        Calendar cal1 = Calendar.getInstance();
////        cal1.set(1980, Calendar.APRIL, 1);
////        Date fechaInicio = cal1.getTime();
////
////        Calendar cal2 = Calendar.getInstance();
////        cal2.set(2023, Calendar.APRIL, 30);
////        Date fechaFin = cal2.getTime();
////
////        List<Tramite> tramites = tramiteDAO.buscarNombrePeriodo(nombres, fechaInicio, fechaFin) ;
////        if (tramites.isEmpty()) {
////
////        } else {
////
////            List<Reporte> reportes = new LinkedList<>();
////            for (Tramite tramite : tramites) {
////                reportes.add(new Reporte(tramite));
////
////            }
////            GenerarReporte.generarReporte(reportes);
////        }
////        if (tramites.isEmpty()) {
////
////        }
//
//        Persona persona = new Persona("xd", "xd", "Xd", "xd", "xd", new Date(11, 111, 11), true);
//        Licencia actualizarLicencia = new Licencia("xd", "2 Años", "Activo", "Licencia", 500, new Date(11, 11, 11), new Date(12, 12, 12), persona);
//        Vehiculo vehiculo = new Vehiculo("xd", "xd", "xd", "xd", "xd", persona);
//        Placas placas = new Placas("xd", "Caduco", "xd", "xd", 500, new Date(11, 11, 11), new Date(12, 12, 12), persona);
//        em.getTransaction().begin();
//        em.persist(persona);
//        em.persist(actualizarLicencia);
//        em.persist(vehiculo);
//        em.persist(placas);
//
//        em.getTransaction().commit();
//        em.close();
//        //System.out.println(tramites.get(0).getId());
    }
}
