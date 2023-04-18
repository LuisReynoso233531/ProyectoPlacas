/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
@Entity
public class Empleado extends Persona implements Serializable {

    // Atributo usuario de tipo String.
    private String usuario;
    // Atributo contrasena de tipo String.
    private String contrasena;

    /**
     * Constructor vacío de la entidad Empleado.
     */
    public Empleado() {
    }

    /**
     * Constructor con todos los atributos de la entidad Empleado.
     *
     * @param usuario de tipo String.
     * @param contrasena de tipo String.
     */
    public Empleado(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getter & Setter de los atributos de la entidad Empleado.
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
