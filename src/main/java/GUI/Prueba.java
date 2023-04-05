/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import entidades.Licencia;
import entidades.Persona;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis-
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        //Ya funciona
//        SolicitarLicencia xd = new SolicitarLicencia();
//        xd.setVisible(true);

        SolicitarPlacas xd = new SolicitarPlacas();
        xd.setVisible(true);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Persona persona = new Persona("1111111111111","1","1","1","1111111111",new Date(11,11,11),true);
        
        em.getTransaction().begin();
        em.persist(persona);

        em.getTransaction().commit();
        em.close();
        
    }
}


