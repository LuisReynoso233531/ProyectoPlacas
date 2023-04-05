/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Vehiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencias.IVehiculo;

/**
 *
 * @author luis-
 */
public class VehiculoDAO implements IVehiculo {
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public VehiculoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Vehiculo agregar(Vehiculo vehiculo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.getTransaction().commit();
            return vehiculo;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al agregar el vehiculo", e);
        } finally {
            em.close();
        }

    }
    
}
