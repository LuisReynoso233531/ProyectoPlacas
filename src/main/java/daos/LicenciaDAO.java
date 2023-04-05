/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Licencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
            throw new RuntimeException("Error al agregar la licencia", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void renovarLicencia(Licencia licencia) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Licencia l SET l.fechaInicio = :fechaInicio, l.vigencia = :vigencia, l.fechaFin = :fechaFin, l.costo = :costo WHERE l.id_licencia = :id_licencia");
        query.setParameter("fechaInicio", licencia.getFechaInicio());
        query.setParameter("vigencia", licencia.getVigencia());
        query.setParameter("fechaFin", licencia.getFechaFin());
        query.setParameter("costo", licencia.getCosto());
        query.setParameter("id_licencia", licencia.getId_licencia());
        int rowsUpdated = query.executeUpdate();
        em.getTransaction().commit();
        }catch(Exception e){
        }finally{
        em.close();
        }
        

    }

}
