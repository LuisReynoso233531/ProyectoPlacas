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
        Menu xd = new Menu();
        xd.setVisible(true);
//  Ya funciona
//        SolicitarPlacas xd = new SolicitarPlacas();
//        xd.setVisible(true);

//        Renovarlicencia xd = new Renovarlicencia();
//        xd.setVisible(true);
//        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//        
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
        
//        Licencia licencia = new Licencia("1","1 Año","Licencia",1, new Date(11,11,11), new Date(12,11,11),persona);
//        
//        em.getTransaction().begin();
//        em.persist(persona);
//        em.persist(licencia);
//        
//        em.getTransaction().commit();
//        em.close();
        
    }
}
