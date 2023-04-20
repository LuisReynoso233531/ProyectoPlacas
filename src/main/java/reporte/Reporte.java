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
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public class Reporte {

    //Atributo tipo de tipo String.
    private String tipo;
    //Atributo costo de tipo String.
    private String costo;
    // Atributo nombreCompleto de tipo String.
    private String nombreCompleto;
    // Atributo fechaInicio de tipo String.
    private String fechaInicio;
    // Atributo licencia de tipo Licencia.
    private Licencia licencia;
    // Atributo placas de tipo Placas.
    private Placas placas;
    // Atributo tramite de tipo Tramite.
    private Tramite tramite;

    /**
     * Constructor de la clase Reporte.
     *
     * @param tramite de tipo Tramite.
     */
    public Reporte(Tramite tramite) {
        this.tramite = tramite;
        this.tipo = this.tramite.getTipo();
        this.costo = String.valueOf(this.tramite.getCosto());
        Date fechaInicioDate = tramite.getFechaInicio();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaInicio = formatter.format(fechaInicioDate);
        this.llenarNombreCompleto(tramite);
    }

    public Reporte(String tipo, String costo, String nombreCompleto, String fechaInicio) {
        this.tipo = tipo;
        this.costo = costo;
        this.nombreCompleto = nombreCompleto;
        this.fechaInicio = fechaInicio;
    }

    /**
     * El método llenarNombreCompleto(Tramite tramite) tiene la función de
     * obtener el nombre y apellidos de una persona.
     *
     * @param tramite de tipo Tramite.
     */
    private void llenarNombreCompleto(Tramite tramite) {
        String nombres = tramite.getPersonasTramite().getNombres();
        String apellidoP = tramite.getPersonasTramite().getApellidoP();
        String apellidoM = tramite.getPersonasTramite().getApellidoM();

        this.nombreCompleto = nombres + " " + apellidoP + " " + apellidoM;
    }

    // Getter & Setter de los atributos de la clase Reporte
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
