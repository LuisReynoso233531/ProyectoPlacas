/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Tramite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import persistencias.ITramite;

/**
 *
 * @author luis-
 */
public class TramiteDAO implements ITramite {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public TramiteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Tramite> mostrarTramite() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT t FROM Tramite t");
            List<Tramite> tramites = query.getResultList();
            em.getTransaction().commit();
            return tramites;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la búsqueda de trámites: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceException("No se pudo generar la búsqueda de trámites: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

}
