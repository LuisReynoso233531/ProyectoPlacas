/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Licencia;
import entidades.Persona;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import persistencias.ILicencia;

/**
 * Esta es la clase DAO de Licencia
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public class LicenciaDAO implements ILicencia {

    /**
     * Atributo EntityManagerFactory que hace una conexión con la BD. Mientras
     * se hace la unidad de persistencia denominada ConexionPU.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    /**
     * Constructor para inicializar la LicenciaDAO como EntityManagerFactory.
     *
     * @param emf de tipo EntityManagerFactory.
     */
    public LicenciaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Método agregarLicencia() que se encarga de insertar un dato. En este caso
     * agrega una licencia.
     *
     * @param licencia de tipo Licencia.
     * @return licencia.
     */
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

    /**
     * Método renovarLicencia() que se encarga de actualizar un dato. En este
     * caso renueva una licencia.
     *
     * @param id_licencia de tipo String.
     * @param estado de tipo String.
     */
    @Override
    public void renovarLicencia(String id_licencia, String estado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Licencia l SET l.estado = :estado WHERE l.id_licencia = :id_licencia AND l.fechaFin <= CAST(CURRENT_DATE AS date)");
            query.setParameter("estado", estado);
            query.setParameter("id_licencia", id_licencia);
            int rowsUpdated = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }

    }

    /**
     * Método buscarPorLicencia() que se encarga de buscar un dato. En este caso
     * busca una licencia.
     *
     * @param id_licencia de tipo String.
     * @return Licencia.
     */
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
