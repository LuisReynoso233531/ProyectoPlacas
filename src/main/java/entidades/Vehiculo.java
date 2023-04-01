/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luis-
 */
@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehiculo implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vehiculo")
    private String id;

    @Basic
    @Column(name = "Marca")
    private String marca;

    @Basic
    @Column(name = "Color")
    private String color;

    @Basic
    @Column(name = "Modelo")
    private String modelo;

    @Basic
    @Column(name = "Linea")
    private String linea;

    @ManyToOne
    private Persona personaVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(String id, String marca, String color, String modelo, String linea, Persona personaVehiculo) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.personaVehiculo = personaVehiculo;
    }

    public Vehiculo(String marca, String color, String modelo, String linea, Persona personaVehiculo) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.personaVehiculo = personaVehiculo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public Persona getPersonaVehiculo() {
        return personaVehiculo;
    }

    public void setPersonaVehiculo(Persona personaVehiculo) {
        this.personaVehiculo = personaVehiculo;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehiculo[ id=" + id + " ]";
    }

}
