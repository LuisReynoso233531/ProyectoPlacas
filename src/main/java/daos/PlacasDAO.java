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
            throw new RuntimeException("Error. No es posible agregar las Placas"+ e.getMessage(),e);
        } finally {
            em.close();
        }
    }

    @Override
    public Placas renovarPlacas(Placas placas) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Placas placaActualizada = em.find(Placas.class, placas.getId());
            if (placaActualizada == null) {
                throw new RuntimeException("No se han encontrado las Placas por renovar");
            }
//            placaActualizada.setFechaInicio(placas.getFechaInicio());
//            placaActualizada.setFechaFin(placas.getFechaFin());
//            placaActualizada.setVigencia(placas.getVigencia());
            em.getTransaction().commit();
            return placaActualizada;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error. No es posible renovar las Placas", e);
        } finally {
            em.close();
        }
    }
    
    
    
}
