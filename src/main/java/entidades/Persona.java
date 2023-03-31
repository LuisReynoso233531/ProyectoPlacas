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
@Table(name = "Persona")
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RFC")
    private String id;

    @Basic
    @Column(name = "Nombres")
    private String nombres;

    @Basic
    @Column(name = "ApellidoP")
    private String ApellidoP;

    @Basic
    @Column(name = "ApellidoM")
    private String apellidoM;

    @Basic
    @Column(name = "Telefono")
    private String telefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaDeNacimiento")
    private Date fechaNacimiento;

    @Basic
    @Column(name = "Discapacidad")
    private boolean discapacidad;

    @OneToMany(mappedBy = "personaVehiculo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "personasTramite", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Tramite> tramites;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ id=" + id + " ]";
    }

}
