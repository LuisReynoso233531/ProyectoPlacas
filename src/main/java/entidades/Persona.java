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
 * Esta es la clase entidad para la entidad Persona
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

    /**
     * Columna id_Persona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Persona")
    private int id;

    /**
     * Columna RFC
     */
    @Basic
    @Column(name = "RFC")
    private String rfc;

    /**
     * Columna Nombres
     */
    @Basic
    @Column(name = "Nombres")
    private String nombres;

    /**
     * Columna ApellidoP
     */
    @Basic
    @Column(name = "ApellidoP")
    private String apellidoP;

    /**
     * Columna ApellidoM
     */
    @Basic
    @Column(name = "ApellidoM")
    private String apellidoM;

    /**
     * Columna Telefono
     */
    @Basic
    @Column(name = "Telefono")
    private String telefono;

    /**
     * FechaDeNacimiento
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaDeNacimiento")
    private Date fechaNacimiento;

    /**
     * Columna Discapacidad
     */
    @Basic
    @Column(name = "Discapacidad")
    private boolean discapacidad;

    /**
     * OneToMany mapeado por personaVehiculo
     */
    @OneToMany(mappedBy = "personaVehiculo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Vehiculo> vehiculos;

    /**
     * OneToMany mapeado por personasTramite
     */
    @OneToMany(mappedBy = "personasTramite", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Tramite> tramites;

    /**
     * Constructor vacío de la entidad Persona
     */
    public Persona() {
    }

    /**
     * Constructor con todos los atributos de la entidad Persona.
     *
     * @param id de tipo int.
     * @param rfc de tipo String.
     * @param nombres de tipo String.
     * @param apellidoP de tipo String.
     * @param apellidoM de tipo String.
     * @param telefono de tipo String.
     * @param fechaNacimiento de tipo Date.
     * @param discapacidad de tipo boolean.
     * @param vehiculos de tipo ListVehiculo
     * @param tramites de tipo ListTramite
     */
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

    /**
     * Constructor con todos los atributos de la entidad Persona a excepción del
     * atributo id.
     *
     * @param rfc de tipo String.
     * @param nombres de tipo String.
     * @param apellidoP de tipo String.
     * @param apellidoM de tipo String.
     * @param telefono de tipo String.
     * @param fechaNacimiento de tipo Date.
     * @param discapacidad de tipo boolean.
     * @param vehiculos de tipo ListVehiculo.
     * @param tramites de tipo ListTramite.
     */
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

    /**
     * Constructor con todos los atributos de la entidad Persona a excepción de
     * los atributos vehiculos y tramites.
     *
     * @param rfc de tipo String.
     * @param nombres de tipo String.
     * @param apellidoP de tipo String.
     * @param apellidoM de tipo String.
     * @param telefono de tipo String.
     * @param fechaNacimiento de tipo Date.
     * @param discapacidad de tipo boolean.
     */
    public Persona(String rfc, String nombres, String apellidoP, String apellidoM, String telefono, Date fechaNacimiento, boolean discapacidad) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
    }

    /**
     * Getter para el atributo id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para el atributo id
     *
     * @param id de tipo int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para el atributo nombres
     *
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Setter para el atributo nombres
     *
     * @param nombres de tipo String
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Getter para el atributo apellidoP
     *
     * @return apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Setter para el atributo apellidoP
     *
     * @param ApellidoP de tipo String
     */
    public void setApellidoP(String ApellidoP) {
        this.apellidoP = ApellidoP;
    }

    /**
     * Getter para el atributo apellidoM
     *
     * @return apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Setter para el atributo apellidoM
     *
     * @param apellidoM de tipo String
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Getter para el atributo telefono
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter para el atributo telefono
     *
     * @param telefono de tipo String
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter para el atributo fechaNacimiento
     *
     * @return fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Setter para el atributo fechaNacimiento
     *
     * @param fechaNacimiento de tipo Date
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter para el atributo discapacidad
     *
     * @return discapacidad
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     * Setter para el atributo discapacidad
     *
     * @param discapacidad de tipo boolean
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Getter para el atributo vehiculos
     *
     * @return vehiculos
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter para el atributo vehiculos
     *
     * @param vehiculos de tipo ListVehiculo
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Getter para el atributo tramites
     *
     * @return tramites
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Setter para el atributo tramites
     *
     * @param tramites de tipo ListTramite
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Getter para el atributo rfc
     *
     * @return rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Setter para el atributo rfc
     *
     * @param rfc de tipo String
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método hashcode() de la entidad Persona
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    /**
     * Método equals(Object obj) de la entidad Persona
     *
     * @param obj de tipo Object
     * @return true en caso verdadero o false en caso contrario
     */
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

    /**
     * Método toString() de la entidad Persona
     *
     * @return id de persona
     */
    @Override
    public String toString() {
        return "entidades.Persona[ id=" + id + " ]";
    }

}
