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
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Persona")
    private int id;

    @Basic
    @Column(name = "RFC")
    private String rfc;

    @Basic
    @Column(name = "Nombres")
    private String nombres;

    @Basic
    @Column(name = "ApellidoP")
    private String apellidoP;

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

    public Persona() {
    }

    public Persona(int id, String rfc, String nombres, String apellidoP, String apellidoM, String telefono, Date fechaNacimiento, boolean discapacidad, List<Vehiculo> vehiculos, List<Tramite> tramites) {
        this.id = id;
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.vehiculos = vehiculos;
        this.tramites = tramites;
    }

    public Persona(String rfc, String nombres, String apellidoP, String apellidoM, String telefono, Date fechaNacimiento, boolean discapacidad, List<Vehiculo> vehiculos, List<Tramite> tramites) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.vehiculos = vehiculos;
        this.tramites = tramites;
    }

    

    public Persona(String rfc, String nombres, String apellidoP, String apellidoM, String telefono, Date fechaNacimiento, boolean discapacidad) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.apellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ id=" + id + " ]";
    }

}
