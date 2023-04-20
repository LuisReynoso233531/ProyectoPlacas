/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoplacas;

import entidades.Licencia;
import entidades.Persona;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta es la clase main ProyectoPlacas
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public class ProyectoPlacas {

    /**
     * Método main de clase ProyectoPlacas
     * @param args de tipo String[]
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Licencia licencia = new Licencia();
        licencia.setId_licencia("xd");
        licencia.setCosto(222);
        licencia.setFechaFin(new Date(11, 11, 11));
        licencia.setFechaInicio(new Date(10, 11, 11));

        licencia.setVigencia("1");
        licencia.setTipo("xd");

        em.getTransaction().begin();
        em.persist(licencia);

        em.getTransaction().commit();
        em.close();

    }
}
