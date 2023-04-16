/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;

import entidades.Licencia;
import entidades.Placas;
import entidades.Tramite;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luis-
 */
public class Reporte {

    private String tipo;
    private String costo;
    private String nombreCompleto;
    private String fechaInicio;
    private Licencia licencia;
    private Placas placas;
    private Tramite tramite;

    public Reporte(Tramite tramite) {
        this.tramite = tramite;
        this.tipo = this.tramite.getTipo();
        this.costo = String.valueOf(this.tramite.getCosto());
        Date fechaInicioDate = tramite.getFechaInicio();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaInicio = formatter.format(fechaInicioDate);
        this.llenarNombreCompleto(tramite);
    }


    private void llenarNombreCompleto(Tramite tramite) {
        String nombres = tramite.getPersonasTramite().getNombres();
        String apellidoP = tramite.getPersonasTramite().getApellidoP();
        String apellidoM = tramite.getPersonasTramite().getApellidoM();

        this.nombreCompleto = nombres + " " + apellidoP + " " + apellidoM;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public Placas getPlacas() {
        return placas;
    }

    public void setPlacas(Placas placas) {
        this.placas = placas;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
    
    
    
}
