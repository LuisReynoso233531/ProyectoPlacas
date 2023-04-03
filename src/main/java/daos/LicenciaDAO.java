/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Licencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
            throw new RuntimeException("Error al agregar la licencia", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Licencia renovarLicencia(Licencia licencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
