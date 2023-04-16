/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import daos.TramiteDAO;
import entidades.Licencia;
import entidades.Persona;
import entidades.Placas;
import entidades.Tramite;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import reporte.GenerarReporte;
import reporte.Reporte;

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

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        TramiteDAO tramiteDAO = new TramiteDAO(emf);
//
//        Date fechaInicio = new Date(11, 11, 11);
//        Date fechaFin = new Date(123, 11, 11);
//
//        List<Tramite> tramites = tramiteDAO.buscarPeriodo(fechaInicio, fechaFin);
//        List<Reporte> reportes = new LinkedList<>();
//        
//        System.out.println(fechaInicio);
//        System.out.println(fechaFin);
//        
//        for (Tramite tramite : tramites) {
//            System.out.println(tramite.getPersonasTramite().getNombres());
//            reportes.add(new Reporte(tramite));
//
//        }
//
//        GenerarReporte.generarReporte(reportes);

    }
}
