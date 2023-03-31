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
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Tramite implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    private int id;

    @Basic
    @Column(name = "Tipo")
    private String tipo;

    @Basic
    @Column(name = "Costo")
    private int costo;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaInicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaFin")
    private Date fechaFin;
    
    @ManyToOne
    private Persona personasTramite;
    
    @OneToMany(mappedBy="tramiteCosto", cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    List<Costo>costos;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
