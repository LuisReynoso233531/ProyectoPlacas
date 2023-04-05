/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Placas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
            throw new RuntimeException("Error al agregar las placas", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Placas renovarPlacas(Placas placas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
