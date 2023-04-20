/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Costo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencias.ICosto;


public class CostoDAO implements ICosto {

    /**
     * Atributo EntityManagerFactory que hace una conexión con la BD. Mientras
     * se hace la unidad de persistencia denominada ConexionPU
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    /**
     * Constructor para inicializar el CostoDAO como EntityManagerFactory
     *
     * @param emf de tipo EntityManagerFactory
     */
    public CostoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Método agregar(Costo costo) que se encarga de insertar un dato. En este
     * caso agrega un costo
     *
     * @param costo de tipo Costo
     * @return costo
     */
    @Override
    public Costo agregar(Costo costo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(costo);
            em.getTransaction().commit();
            return costo;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error. No es posible agregar la Licencia", e);
        } finally {
            em.close();
        }
    }

}
