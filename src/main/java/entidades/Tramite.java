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
 *
 * @author luis-
 */
@Entity
@Table(name = "Tramite")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    protected int id;

    @Basic
    @Column(name = "Tipo")
    protected String tipo;

    @Basic
    @Column(name = "Costo")
    protected Integer costo;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaInicio")
    protected Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaFin")
    protected Date fechaFin;

    @ManyToOne
    @JoinColumn(name="id_persona", nullable = false)
    protected Persona personasTramite;

    @OneToMany(mappedBy = "tramiteCosto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Costo> costos;

    public Tramite() {
    }

    public Tramite(int id, String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite, List<Costo> costos) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personasTramite = personasTramite;
        this.costos = costos;
    }

    public Tramite(String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite, List<Costo> costos) {
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personasTramite = personasTramite;
        this.costos = costos;
    }

    public Tramite(String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite) {
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personasTramite = personasTramite;
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

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
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

    public List<Costo> getCostos() {
        return costos;
    }

    public void setCostos(List<Costo> costos) {
        this.costos = costos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

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

    @Override
    public String toString() {
        return "entidades.Tramite[ id=" + id + " ]";
    }

}
