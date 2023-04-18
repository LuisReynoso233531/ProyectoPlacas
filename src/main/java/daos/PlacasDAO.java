/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Placas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencias.IPlacas;

/**
 *
 * @author luis-
 */
public class PlacasDAO implements IPlacas {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public PlacasDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Placas agregarPlacas(Placas placas) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(placas);
            em.getTransaction().commit();
            return placas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error. No es posible agregar las Placas"+ e.getMessage(),e);
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarPlacas(String numeroPlacas, String estado) {
            EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Placas p SET p.estado = :estado WHERE p.vehiculo = :vehiculo");
        query.setParameter("estado", estado);
        query.setParameter("vehiculo", numeroPlacas);
        int rowsUpdated = query.executeUpdate();
        em.getTransaction().commit();
    } catch (Exception e) {
        System.err.println(e.getMessage());
    } finally {
        em.close();
    }
    }
    
    
    
}
