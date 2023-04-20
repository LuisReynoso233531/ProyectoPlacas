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
 * Esta es la clase entidad para la entidad Placas
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "placas")
public class Placas extends Tramite implements Serializable {

    /**
     * Atributo numeroPlacas de tipo String
     */
    private String numeroPlacas;

    /**
     * Atributo estado de tipo String
     */
    private String estado;

    /**
     * Atributo vehiculo de tipo String
     */
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

    /**
     * Getter para el atributo estado
     *
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter para el atributo estado
     *
     * @param estado de tipo String
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Getter para el atributo id
     *
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Setter para el atributo id
     *
     * @param id de tipo int
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para el atributo tipo
     *
     * @return tipo
     */
    @Override
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter para el atributo tipo
     *
     * @param tipo de tipo String
     */
    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter para el atributo fechaInicio
     *
     * @return fechaInicio
     */
    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Setter para el atributo fechaInicio
     *
     * @param fechaInicio de tipo Date
     */
    @Override
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Getter para el atributo fechaFin
     *
     * @return fechaFin
     */
    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Setter para el atributo fechaFin
     *
     * @param fechaFin de tipo Date
     */
    @Override
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Getter para el atributo personasTramite
     *
     * @return personasTramite
     */
    @Override
    public Persona getPersonasTramite() {
        return personasTramite;
    }

    /**
     * Setter para el atributo personasTramite
     *
     * @param personasTramite de tipo Persona
     */
    @Override
    public void setPersonasTramite(Persona personasTramite) {
        this.personasTramite = personasTramite;
    }

    /**
     * Getter para el atributo numeroPlacas
     *
     * @return numeroPlacas
     */
    public String getNumeroPlacas() {
        return numeroPlacas;
    }

    /**
     * Setter para el atributo numeroPlacas
     *
     * @param numeroPlacas de tipo String
     */
    public void setNumeroPlacas(String numeroPlacas) {
        this.numeroPlacas = numeroPlacas;
    }

    /**
     * Getter para el atributo costo
     *
     * @return costo
     */
    @Override
    public Integer getCosto() {
        return costo;
    }

    /**
     * Setter para el atributo costo
     *
     * @param costo de tipo Integer
     */
    @Override
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

}
