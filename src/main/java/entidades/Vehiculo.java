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
 * Esta es la clase entidad para la entidad Vehiculo
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    /**
     * Columna id_Vehiculo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vehiculo")
    private int id;

    /**
     * Columna NumeroSerie
     */
    @Basic
    @Column(name = "NumeroSerie")
    private String numeroSerie;

    /**
     * Columna Marca
     */
    @Basic
    @Column(name = "Marca")
    private String marca;

    /**
     * Columna Color
     */
    @Basic
    @Column(name = "Color")
    private String color;

    /**
     * Columna Modelo
     */
    @Basic
    @Column(name = "Modelo")
    private String modelo;

    /**
     * Columna Linea
     */
    @Basic
    @Column(name = "Linea")
    private String linea;

    /**
     * JoinColumn de id_persona
     */
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona personaVehiculo;

    /**
     * Constructor vacío de la entidad Vehiculo
     */
    public Vehiculo() {
    }

    /**
     * Constructor con todos los atributos de la entidad Vehiculo.
     *
     * @param id de tipo int.
     * @param numeroSerie de tipo String.
     * @param marca de tipo String.
     * @param color de tipo String.
     * @param modelo de tipo String.
     * @param linea de tipo String.
     * @param personaVehiculo de tipo Persona.
     */
    public Vehiculo(int id, String numeroSerie, String marca, String color, String modelo, String linea, Persona personaVehiculo) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.personaVehiculo = personaVehiculo;
    }

    /**
     * Constructor con todos los atributos de la entidad Vehiculo a excepción
     * del atributo id.
     *
     * @param numeroSerie de tipo String.
     * @param marca de tipo String.
     * @param color de tipo String.
     * @param modelo de tipo String.
     * @param linea de tipo String.
     * @param personaVehiculo de tipo Persona.
     */
    public Vehiculo(String numeroSerie, String marca, String color, String modelo, String linea, Persona personaVehiculo) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.personaVehiculo = personaVehiculo;
    }

    /**
     * Getter del atributo numeroSerie
     *
     * @return numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Setter del atributo numeroSerie
     *
     * @param numeroSerie de tipo String
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
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
     * Getter del atributo marca
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter del atributo marca
     *
     * @param marca de tipo String
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter del atributo color
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter del atributo color
     *
     * @param color de tipo String
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter del atributo modelo
     *
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo modelo
     *
     * @param modelo de tipo String
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo linea
     *
     * @return linea
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Setter del atributo linea
     *
     * @param linea de tipo String
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Getter del atributo personaVehiculo
     *
     * @return personaVehiculo
     */
    public Persona getPersonaVehiculo() {
        return personaVehiculo;
    }

    /**
     * Setter del atributo personaVehiculo
     *
     * @param personaVehiculo de tipo Persona
     */
    public void setPersonaVehiculo(Persona personaVehiculo) {
        this.personaVehiculo = personaVehiculo;
    }

    /**
     * Método hashCode() de la entidad Vehiculo
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        return hash;
    }

    /**
     * Método equals(Object obj) de la entidad Vehiculo
     *
     * @param obj de tipo Object
     * @return true en caso verdadero y false en caso contrario
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
        final Vehiculo other = (Vehiculo) obj;
        return true;
    }

    /**
     * Método toString() de la entidad Vehiculo
     *
     * @return id de la entidad vehiculo en formato String
     */
    @Override
    public String toString() {
        return "entidades.Vehiculo[ id=" + id + " ]";
    }

}
