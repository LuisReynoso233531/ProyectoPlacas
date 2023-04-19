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
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import reporte.GenerarReporte;
import reporte.Reporte;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Menu xd = new Menu();
        xd.setVisible(true);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        Persona persona = new Persona("xd", "xd", "Xd", "xd", "xd", new Date(11, 111, 11), true);
        Licencia actualizarLicencia = new Licencia("xd", "2 Años", "Activo", "Licencia", 500, new Date(11, 11, 11), new Date(12, 12, 12), persona);
        em.getTransaction().begin();
        em.persist(persona);
        em.persist(actualizarLicencia);
        em.getTransaction().commit();
        em.close();
    }
}
