/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Licencia;
import entidades.Placas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencias.IPlacas;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public class PlacasDAO implements IPlacas {

    /**
     * Atributo EntityManagerFactory que hace una conexión con la BD. Mientras
     * se hace la unidad de persistencia denominada ConexionPU.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    /**
     * Constructor para inicializar la PlacasDAO como EntityManagerFactory.
     *
     * @param emf de tipo EntityManagerFactory.
     */
    public PlacasDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Método agregarPlacas(Placas placas) que se encarga de insertar un dato.
     * En este caso agrega una placa.
     *
     * @param placas de tipo Placas.
     * @return placas.
     */
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
            throw new RuntimeException("Error. No es posible agregar las Placas" + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    /**
     * Método actualizarPlacas(String numeroPlacas, String estado) que se
     * encarga de actualizar un dato. En este caso actualiza una placa.
     *
     * @param numeroPlacas de tipo String.
     * @param estado de tipo String.
     */
    @Override
    public void actualizarPlacas(String numeroPlacas, String estado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Placas p SET p.estado = :estado WHERE p.vehiculo = :vehiculo AND p.fechaFin <= CAST(CURRENT_DATE AS date)");
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
    
    /**
     * El metodo buscarPorVehiculo() se encarga de buscar un dato
     * en este caso, por vehiculo
     * @param vehiculo de tipo String
     * @return Placas
     */
    
    @Override
    public Placas buscarPorVehiculo(String vehiculo) {
         EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Placas p WHERE p.vehiculo = :vehiculo");
            query.setParameter("vehiculo", vehiculo);
            return (Placas) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}
