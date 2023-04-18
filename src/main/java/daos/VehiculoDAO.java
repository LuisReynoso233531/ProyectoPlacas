/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
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
            throw new RuntimeException("Error. No es posible agregar el Vehículo"+ e.getMessage(),e);
        } finally {
            em.close();
        }

    }

    @Override
    public List<Vehiculo> buscarRFC(String rfc) {
        EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT v FROM Vehiculo v INNER JOIN v.personaVehiculo p WHERE p.rfc = :rfc");
        query.setParameter("rfc", rfc) ;
        List<Vehiculo> vehiculos = query.getResultList();
        em.getTransaction().commit();
        return vehiculos;
    } catch (Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "No se pudo generar la búsqueda de trámites: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        throw new PersistenceException("No se pudo generar la búsqueda de trámites: " + e.getMessage(), e);
    } finally {
        em.close();
    }
    }
    
}
