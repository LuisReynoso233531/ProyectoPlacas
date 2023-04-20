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
 * Esta es la clase entidad para la entidad Motocicleta
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
@Entity
public class Motocicleta extends Vehiculo implements Serializable {

    /**
     * Constructor vacío de la entidad Motocicleta.
     */
    public Motocicleta() {

    }

}
