/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author luis-
 */
@Entity
public class Licencia extends Tramite implements Serializable {

    private String id_licencia;
    private String Vigencia;
    private int costo;

    public Licencia() {
        super();
    }

    public Licencia(String id_licencia, String Vigencia, Integer costo) {
        this.id_licencia = id_licencia;
        this.Vigencia = Vigencia;
        this.costo = costo;
    }

    public Licencia(String id_licencia, String Vigencia, String tipo, Integer costo, Date fechaInicio, Date fechaFin, Persona personasTramite) {
        super(tipo, costo, fechaInicio, fechaFin, personasTramite);
        this.id_licencia = id_licencia;
        this.Vigencia = Vigencia;
        this.costo = costo;
    }
    
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
    
    
    
}
