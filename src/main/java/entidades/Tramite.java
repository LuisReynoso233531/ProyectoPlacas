/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta es la clase entidad para la entidad Tramite
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "Tramite")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     * Columna id_tramite
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    protected int id;

    /**
     * Columna Tipo
     */
    @Basic
    @Column(name = "Tipo")
    protected String tipo;

    /**
     * Columna Costo
     */
    @Basic
    @Column(name = "Costo")
    protected Integer costo;

    /**
     * Columna FechaInicio
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaInicio")
    protected Date fechaInicio;

    /**
     * Columna FechaFin
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaFin")
    protected Date fechaFin;

    /**
     * JoinColumn de id_persona
     */
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    protected Persona personasTramite;

    /**
     * OneToMany mapeado por tramiteCosto
     */
    @OneToMany(mappedBy = "tramiteCosto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Costo> costos;

    /**
     * Constructor vacío de la entidad Tramite.
     */
    public Tramite() {
    }

    /**
     * Constructor con todos los atributos de la entidad Tramite.
     *
     * @param id de tipo int.
     * @param tipo de tipo String.
     * @param costo de tipo Integer.
     * @param fechaInicio de tipo Date.
     * @param fechaFin de tipo Date.
     * @param personasTramite de tipo Persona.
     * @param costos de tipo ListCosto.
     */
    public Tramite(int id, String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite, List<Costo> costos) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personasTramite = personasTramite;
        this.costos = costos;
    }

    /**
     * Constructor con todos los atributos de la entidad Tramite a excepción del
     * atributo id.
     *
     * @param tipo de tipo String.
     * @param costo de tipo Integer.
     * @param fechaInicio de tipo Date.
     * @param fechaFin de tipo Date.
     * @param personasTramite de tipo Persona.
     * @param costos de tipo ListCosto.
     */
    public Tramite(String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite, List<Costo> costos) {
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personasTramite = personasTramite;
        this.costos = costos;
    }

    /**
     * Constructor con todos los atributos de la entidad Tramite a excepción de
     * id y costos.
     *
     * @param tipo de tipo String
     * @param costo de tipo Integer
     * @param fechaInicio de tipo Date
     * @param fechaFin de tipo Date
     * @param personasTramite de tipo Persona
     */
    public Tramite(String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite) {
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personasTramite = personasTramite;
    }

    /**
     * Getter del atributo id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del atributo id
     *
     * @param id de tipo int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del atributo tipo
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     *
     * @param tipo de tipo String
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter del atributo costo
     *
     * @return costo
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * Setter del atributo costo
     *
     * @param costo de tipo Integer
     */
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    /**
     * Getter del atributo fechaInicio
     *
     * @return fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Setter del atributo fechaInicio
     *
     * @param fechaInicio de tipo Date
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Getter del atributo fechaFin
     *
     * @return fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Setter del atributo fechaFin
     *
     * @param fechaFin de tipo Date
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Getter del atributo personasTramite
     *
     * @return personasTramite
     */
    public Persona getPersonasTramite() {
        return personasTramite;
    }

    /**
     * Setter del atributo personasTramite
     *
     * @param personasTramite de tipo Persona
     */
    public void setPersonasTramite(Persona personasTramite) {
        this.personasTramite = personasTramite;
    }

    /**
     * Getter de la lista Costo
     *
     * @return costos de la lista Costo
     */
    public List<Costo> getCostos() {
        return costos;
    }

    /**
     * Setter de la lista Costo
     *
     * @param costos de tipo ListCosto
     */
    public void setCostos(List<Costo> costos) {
        this.costos = costos;
    }

    /**
     * Método hashCode() de la entidad Tramite
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    /**
     * Método equals(Object object) de la entidad Tramite
     *
     * @param object de tipo Object
     * @return true en caso verdadero y false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * Método toString() de la entidad Tramite
     *
     * @return id de Tramite en formato String
     */
    @Override
    public String toString() {
        return "entidades.Tramite[ id=" + id + " ]";
    }

}
