/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "placas")
public class Placas extends Tramite implements Serializable {

    // Atributo numeroPlacas de tipo String.
    private String numeroPlacas;
    // Atributo estado de tipo String.
    private String estado;
    // Atributo vehiculo de tipo String.
    private String vehiculo;

    /**
     * Constructor vacío de la entidad Placas.
     */
    public Placas() {

    }

    /**
     * Constructor con todos los atributos de la entidad Placas sin super.
     *
     * @param numeroPlacas de tipo String.
     * @param estado de tipo String.
     * @param vehiculo de tipo String.
     */
    public Placas(String numeroPlacas, String estado, String vehiculo) {
        this.numeroPlacas = numeroPlacas;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor con todos los atributos de la entidad Placas con super.
     *
     * @param numeroPlacas de tipo String.
     * @param estado de tipo String.
     * @param vehiculo de tipo String.
     * @param tipo de tipo String.
     * @param costo de tipo Integer.
     * @param fechaInicio de tipo Date.
     * @param fechaFin de tipo Date.
     * @param personasTramite de tipo Persona.
     */
    public Placas(String numeroPlacas, String estado, String vehiculo, String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite) {
        super(tipo, costo, fechaInicio, fechaFin, personasTramite);
        this.numeroPlacas = numeroPlacas;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    // Getter & Setter de los atributos de la entidad Placas.
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Persona getPersonasTramite() {
        return personasTramite;
    }

    public void setPersonasTramite(Persona personasTramite) {
        this.personasTramite = personasTramite;
    }

    public String getNumeroPlacas() {
        return numeroPlacas;
    }

    public void setNumeroPlacas(String numeroPlacas) {
        this.numeroPlacas = numeroPlacas;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

}
