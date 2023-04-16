/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luis-
 */
public class GenerarReporte {

    public static void generarReporte(List<Reporte> reportes) {
        try {
            JRBeanCollectionDataSource objeto = new JRBeanCollectionDataSource(reportes);
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.putIfAbsent("CollectionBeanParam", objeto);
            String jasperFilePath = "target/classes/Reporte.jrxml";
            InputStream input = new FileInputStream(jasperFilePath);
            JasperDesign jasperDesign = JRXmlLoader.load(input);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
            view.setAlwaysOnTop(true);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
