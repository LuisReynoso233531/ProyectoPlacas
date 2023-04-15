/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Tramite;
import java.util.Date;
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

    @Override
    public List<Tramite> buscarTipo(String tipo) {
        EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Tramite t WHERE t.tipo = :tipo");
        query.setParameter("tipo", tipo) ;
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

    @Override
    public List<Tramite> buscarPorId(int id) {
           EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Tramite t WHERE t.id = :id");
        query.setParameter("id", id) ;
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

    @Override
    public List<Tramite> buscarPorFecha(Date fecha) {
        EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Tramite t WHERE t.fechaInicio = :fecha");
        query.setParameter("fecha", fecha);
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

    @Override
    public List<Tramite> buscarPeriodo(Date fechaInicio, Date fechaFin) {
       EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Tramite t WHERE t.fechaInicio BETWEEN :fechaInicio AND :fechaFin");
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
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

    @Override
    public List<Tramite> buscarRFC(String rfc) {
          EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Tramite t INNER JOIN t.personasTramite p WHERE p.rfc = :rfc");
        query.setParameter("rfc", rfc);
        List<Tramite> tramites = query.getResultList();
        em.getTransaction().commit();
        return tramites;
    }catch (Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "No se pudo generar la búsqueda de rfc: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        throw new PersistenceException("No se pudo generar la búsqueda de rfc: " + e.getMessage(), e);
    } finally {
        em.close();
    }
    }

    @Override
    public List<Tramite> buscarNombre(String nombres) {
            EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Tramite t INNER JOIN t.personasTramite p WHERE p.nombres = :nombres");
        query.setParameter("nombres", nombres);
        List<Tramite> tramites = query.getResultList();
        em.getTransaction().commit();
        return tramites;
    }catch (Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "No se pudo generar la búsqueda de rfc: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        throw new PersistenceException("No se pudo generar la búsqueda de rfc: " + e.getMessage(), e);
    } finally {
        em.close();
    }
    }



}
