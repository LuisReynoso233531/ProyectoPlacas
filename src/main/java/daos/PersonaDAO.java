/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import persistencias.IPersona;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public class PersonaDAO implements IPersona {

    /**
     * Atributo EntityManagerFactory que hace una conexión con la BD. Mientras
     * se hace la unidad de persistencia denominada ConexionPU.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    /**
     * Constructor para inicializar la PersonaDAO como EntityManagerFactory.
     *
     * @param emf de tipo EntityManagerFactory.
     */
    public PersonaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Método agregar(Persona persona) que se encarga de insertar un dato. En
     * este caso agrega una persona.
     *
     * @param persona de tipo Persona.
     * @return persona.
     */
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
            throw new RuntimeException("Error. No es posible agregar la persona", e);
        } finally {
            em.close();
        }

    }

    /**
     * Método buscarRFC(String rfc) que se encarga de buscar un dato. En este
     * caso busca un rfc que pertenece a una persona.
     *
     * @param rfc de tipo String.
     * @return persona.
     */
    @Override
    public Persona buscarRFC(String rfc) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.rfc = :rfc", Persona.class);
            query.setParameter("rfc", rfc);
            Persona persona = (Persona) query.getSingleResult();
            em.getTransaction().commit();
            return persona;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al buscar persona por RFC: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;

    }

    /**
     * Método agregarMasivo(Persona persona) que se encarga de insertar datos.
     * En este caso agrega un total de 20 personas con sus respectivos
     * atributos.
     *
     * @param persona de tipo Persona.
     * @return persona.
     */
    @Override
    public Persona agregarMasivo(Persona persona) {
        EntityManager em = emf.createEntityManager();
        try {
            Persona persona1 = new Persona("LECJ901217A15", "Javier", "Legarreta", "Contreras", "6442567633", new Date(1990, 12, 17), true);
            Persona persona2 = new Persona("QUMA470929F37", "Alfonso", "Quintero", "Montenegro", "6441166443", new Date(1947, 9, 29), true);
            Persona persona3 = new Persona("MOSC900920R43", "Carolina", "Montes", "Salinas", "6441857696", new Date(1990, 9, 20), false);
            Persona persona4 = new Persona("PAMM960818C21", "Mario", "Palacios", "Molina", "6442642090", new Date(1996, 8, 18), false);
            Persona persona5 = new Persona("POVA011228B12", "Anya", "Polanco", "Valenzuela", "6441310840", new Date(2001, 12, 28), false);
            Persona persona6 = new Persona("JITF850423V36", "Fernando", "Jimenez", "Tapia", "6442655929", new Date(1985, 4, 23), true);
            Persona persona7 = new Persona("UROR981025D14", "Regina", "Urias", "Ocampo", "6442554028", new Date(1998, 10, 25), false);
            Persona persona8 = new Persona("CALL020316F40", "Luis", "Cazares", "Lugo", "6441773340", new Date(2002, 3, 16), true);
            Persona persona9 = new Persona("FIMJ921121G47", "Jocelyn", "Figueroa", "Martinez", "6442879091", new Date(1992, 11, 21), false);
            Persona persona10 = new Persona("ANRE790614L68", "Enrique", "Angulo", "Robles", "6441902035", new Date(1979, 6, 14), false);
            Persona persona11 = new Persona("RASL951211P54", "Lucia", "Ramirez", "Sanchez", "6442478321", new Date(1995, 12, 11), false);
            Persona persona12 = new Persona("AGPD870217F16", "Diego", "Aguilar", "Pineda", "6441432750", new Date(1987, 2, 17), false);
            Persona persona13 = new Persona("BAGS990120E64", "Silvia", "Bacasegua", "Galindo", "6442321260", new Date(1999, 1, 20), true);
            Persona persona14 = new Persona("HISP821022G33", "Pedro", "Hinojos", "Sierra", "6441667710", new Date(1982, 10, 22), false);
            Persona persona15 = new Persona("VIAV931130F58", "Valeria", "Villares", "Acedo", "6442401550", new Date(1993, 11, 30), false);
            Persona persona16 = new Persona("CATF811216J94", "Francisco", "Cano", "Torres", "6441187021", new Date(1981, 12, 16), false);
            Persona persona17 = new Persona("ESGK770518C23", "Karina", "Espinoza", "Gonzalez", "6442401550", new Date(1977, 5, 18), false);
            Persona persona18 = new Persona("BOMC921124K48", "Carlos", "Bocardo", "Murillo", "6441186142", new Date(1992, 11, 24), false);
            Persona persona19 = new Persona("MABA940715F32", "Alondra", "Manjarrez", "Bustillos", "6441708422", new Date(1994, 7, 15), false);
            Persona persona20 = new Persona("COSP931130D45", "Paulina", "Contreras", "Soto", "6442401550", new Date(1993, 11, 30), false);
            em.getTransaction().begin();
            em.persist(persona1);
            em.persist(persona2);
            em.persist(persona3);
            em.persist(persona4);
            em.persist(persona5);
            em.persist(persona6);
            em.persist(persona7);
            em.persist(persona8);
            em.persist(persona9);
            em.persist(persona10);
            em.persist(persona11);
            em.persist(persona12);
            em.persist(persona13);
            em.persist(persona14);
            em.persist(persona15);
            em.persist(persona16);
            em.persist(persona17);
            em.persist(persona18);
            em.persist(persona19);
            em.persist(persona20);
            em.getTransaction().commit();
            return persona;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo insertar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceException("No se pudo insertar los clientes: " + e.getMessage(), e);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al ingresar clientes " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    /**
     * Método buscarRfcTabla(String rfc) que se encarga de buscar un dato. En
     * este caso un rfc que pertenece a una persona.
     *
     * @param rfc de tipo String
     * @return personas.
     */
    @Override
    public List<Persona> buscarRfcTabla(String rfc) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Persona p INNER JOIN p.tramites t WHERE p.rfc = :rfc");
            query.setParameter("rfc", rfc);
            List<Persona> personas = query.getResultList();
            em.getTransaction().commit();
            return personas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la búsqueda de rfc: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceException("No se pudo generar la búsqueda de rfc: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    /**
     * Método mostrarPersonas() que se encarga de mostrar datos. En este caso
     * muestra una lista de personas.
     *
     * @return personas.
     */
    @Override
    public List<Persona> mostrarPersonas() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Persona p");
            List<Persona> personas = query.getResultList();
            em.getTransaction().commit();
            return personas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la búsqueda de trámites: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceException("No se pudo generar la búsqueda de trámites: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
