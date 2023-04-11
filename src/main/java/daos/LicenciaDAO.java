/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Licencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencias.ILicencia;

/**
 *
 * @author luis-
 */
public class LicenciaDAO implements ILicencia {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public LicenciaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Licencia agregarLicencia(Licencia licencia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
            return licencia;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error. No es posible agregar la Licencia", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void renovarLicencia(Licencia licencia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Licencia l SET l.fechaInicio = :fechaInicio, l.vigencia = :vigencia, l.fechaFin = :fechaFin, l.costo = :costo WHERE l.id_licencia = :id_licencia");
            query.setParameter("fechaInicio", licencia.getFechaInicio());
            query.setParameter("vigencia", licencia.getVigencia());
            query.setParameter("fechaFin", licencia.getFechaFin());
            query.setParameter("costo", licencia.getCosto());
            query.setParameter("id_licencia", licencia.getId_licencia());
            int rowsUpdated = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public Licencia buscarPorLicencia(String id_licencia) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT l FROM Licencia l WHERE l.id_licencia = :id_licencia");
            query.setParameter("id_licencia", id_licencia);
            return (Licencia) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

    }
}
