/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
@Entity
@Table(name = "Costo")
public class Costo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costo")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaPago")
    private Date fechaPago;

    @Basic
    @Column(name = "Monto")
    private int monto;

    @ManyToOne
    @JoinColumn(name = "id_tramite", nullable = false)
    private Tramite tramiteCosto;

    /**
     * Constructor vacío de la entidad Costo.
     */
    public Costo() {
    }

    /**
     * Constructor con todos los atributos de la entidad Costo.
     *
     * @param id de tipo int.
     * @param fechaPago de tipo Date.
     * @param monto de tipo int.
     * @param tramiteCosto de tipo Tramite.
     */
    public Costo(int id, Date fechaPago, int monto, Tramite tramiteCosto) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.tramiteCosto = tramiteCosto;
    }

    /**
     * Constructor con todos los atributos de la entidad de Costo a excepción
     * del id.
     *
     * @param fechaPago de tipo Date.
     * @param monto de tipo int.
     * @param tramiteCosto de tipo Tramite.
     */
    public Costo(Date fechaPago, int monto, Tramite tramiteCosto) {
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.tramiteCosto = tramiteCosto;
    }

    // Getter & Setter de atributos de Costo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Tramite getTramiteCosto() {
        return tramiteCosto;
    }

    public void setTramiteCosto(Tramite tramiteCosto) {
        this.tramiteCosto = tramiteCosto;
    }

    // Método hashCode()
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    // Método equals(Object object)
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costo)) {
            return false;
        }
        Costo other = (Costo) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // Método toString()
    @Override
    public String toString() {
        return "entidades.Costo[ id=" + id + " ]";
    }

}
