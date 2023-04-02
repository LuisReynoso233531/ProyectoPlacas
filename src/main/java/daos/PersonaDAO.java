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
    EntityManager em = emf.createEntityManager();

    public PersonaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Persona agregar(Persona persona) {

        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery(" (rfc, nombres, apellidoP, apellidoM, telefono, fechaNacimiento, discapacidad) "
                    + "VALUES (:rfc, :nombres, :apellidoP, :apellidoM, :telefono, :fechaNacimiento, :discapacidad)");
            query.setParameter("rfc", persona.getRfc());
            query.setParameter("nombres", persona.getNombres());
            query.setParameter("apellidoP", persona.getApellidoP());
            query.setParameter("apellidoM", persona.getApellidoM());
            query.setParameter("telefono", persona.getTelefono());
            query.setParameter("fechaNacimiento", persona.getFechaNacimiento());
            query.setParameter("discapacidad", persona.isDiscapacidad());
            query.executeUpdate();
            em.getTransaction().commit();
            return persona;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al agregar la persona", e);
        } finally {
            em.close();
        }
        //        
//        try {
//            em.getTransaction().begin();
//            em.persist(persona);
//            em.getTransaction().commit();
//            return persona;
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            throw new RuntimeException("Error al agregar la persona", e);
//        } finally {
//            em.close();
//        }
    }

    @Override
    public Persona agregarEmpleado(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona agregarMasivo(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
