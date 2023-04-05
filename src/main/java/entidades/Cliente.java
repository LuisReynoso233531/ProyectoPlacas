/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author luis-
 */
@Entity
public class Cliente extends Persona implements Serializable {
    
  
    
    public Cliente(){
        
    }

    public Cliente(String cliente, String rfc, String nombres, String apellidoP, String apellidoM, String telefono, Date fechaNacimiento, boolean discapacidad) {
        super(rfc, nombres, apellidoP, apellidoM, telefono, fechaNacimiento, discapacidad);
        
    }
    
    
}
