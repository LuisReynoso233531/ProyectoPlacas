/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta es la clase entidad para la entidad Licencia
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "licencia")
public class Licencia extends Tramite implements Serializable {

    /**
     * Columna id_licencia
     */
    @Column(name = "id_licencia")
    private String id_licencia;
    
    /**
     * Columna vigencia
     */
    @Column(name = "vigencia")
    private String Vigencia;
    
    /**
     * Columna estado
     */
    @Column(name = "estado")
    private String estado;

    /**
     * Constructor de la entidad Licencia.
     */
    public Licencia() {
        super();
    }

    /**
     * Constructor con todos los atributos de la entidad Licencia sin super.
     *
     * @param id_licencia de tipo String.
     * @param Vigencia de tipo String.
     * @param estado de tipo String.
     */
    public Licencia(String id_licencia, String Vigencia, String estado) {
        this.id_licencia = id_licencia;
        this.Vigencia = Vigencia;
        this.estado = estado;
    }

    /**
     * Constructor con todos los atributos de la entidad Licencia con super.
     *
     * @param id_licencia de tipo String.
     * @param Vigencia de tipo String.
     * @param estado de tipo String.
     * @param tipo de tipo String.
     * @param costo de tipo Integer.
     * @param fechaInicio de tipo Date.
     * @param fechaFin de tipo Date.
     * @param personasTramite de tipo Persona.
     */
    public Licencia(String id_licencia, String Vigencia, String estado, String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite) {
        super(tipo, costo, fechaInicio, fechaFin, personasTramite);
        this.id_licencia = id_licencia;
        this.Vigencia = Vigencia;
        this.estado = estado;
    }

    /**
     * Getter del atributo id_licencia
     * @return id_licencia
     */
    public String getId_licencia() {
        return id_licencia;
    }

    /**
     * Setter del atributo id_licencia
     * @param id_licencia de tipo String
     */
    public void setId_licencia(String id_licencia) {
        this.id_licencia = id_licencia;
    }

    /**
     * Getter del atributo Vigencia
     * @return Vigencia
     */
    public String getVigencia() {
        return Vigencia;
    }

    /**
     * Setter del atributo Vigencia
     * @param Vigencia de tipo String
     */
    public void setVigencia(String Vigencia) {
        this.Vigencia = Vigencia;
    }

    @Override
    public Integer getCosto() {
        return costo;
    }

    @Override
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public Persona getPersonasTramite() {
        return personasTramite;
    }

    @Override
    public void setPersonasTramite(Persona personasTramite) {
        this.personasTramite = personasTramite;
    }

    /**
     * Getter del atributo estado
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter del atributo estado
     * @param estado de tipo String
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
