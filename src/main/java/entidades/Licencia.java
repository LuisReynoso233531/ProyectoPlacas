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
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "licencia")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "id_licencia")
    private String id_licencia;
    @Column(name = "vigencia")
    private String Vigencia;
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

    // Getter & Setter de los atributos de la entidad Licencia.
    public String getId_licencia() {
        return id_licencia;
    }

    public void setId_licencia(String id_licencia) {
        this.id_licencia = id_licencia;
    }

    public String getVigencia() {
        return Vigencia;
    }

    public void setVigencia(String Vigencia) {
        this.Vigencia = Vigencia;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
