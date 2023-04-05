/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencias.IPersona;

/**
 *
 * @author luis-
 */
public class PersonaDAO implements IPersona {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public PersonaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Persona agregar(Persona persona) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return persona;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al agregar la persona", e);
        } finally {
            em.close();
        }

    }

    @Override
    public Persona buscarRFC(String rfc) {
        EntityManager em = emf.createEntityManager();
        try{
           Query query = em.createQuery("SELECT p FROM Persona p WHERE p.rfc = :rfc");
        query.setParameter("rfc", rfc);
        return (Persona) query.getSingleResult(); 
        }catch(Exception e){
           em.getTransaction().rollback();
            throw new RuntimeException("Error al agregar la persona", e); 
        }finally{
            em.close();
        }
        
    }
    
    

    @Override
    public Persona agregarMasivo(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona buscarDiscapacidad(boolean discapacidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
