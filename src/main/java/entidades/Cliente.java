/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Esta es la clase entidad de la entidad Cliente
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
public class Cliente extends Persona implements Serializable {

    /**
     * Constructor vacío de la entidad Cliente.
     */
    public Cliente() {

    }

    /**
     * Constructor con todos los atributos de la entidad Cliente con super.
     *
     * @param cliente de tipo String.
     * @param rfc de tipo String.
     * @param nombres de tipo String.
     * @param apellidoP de tipo String.
     * @param apellidoM de tipo String.
     * @param telefono de tipo String.
     * @param fechaNacimiento de tipo Date.
     * @param discapacidad de tipo boolean.
     */
    public Cliente(String cliente, String rfc, String nombres, String apellidoP, String apellidoM, String telefono, Date fechaNacimiento, boolean discapacidad) {
        super(rfc, nombres, apellidoP, apellidoM, telefono, fechaNacimiento, discapacidad);

    }

}
