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

/**
 *
 * @author luis-
 */
@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vehiculo")
    private int id;

    @Basic
    @Column(name = "NumeroSerie")
    private String numeroSerie;

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
    @JoinColumn(name="id_persona", nullable = false)
    private Persona personaVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(int id, String numeroSerie, String marca, String color, String modelo, String linea, Persona personaVehiculo) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.personaVehiculo = personaVehiculo;
    }

    public Vehiculo(String numeroSerie, String marca, String color, String modelo, String linea, Persona personaVehiculo) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.personaVehiculo = personaVehiculo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final Vehiculo other = (Vehiculo) obj;
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehiculo[ id=" + id + " ]";
    }

}
