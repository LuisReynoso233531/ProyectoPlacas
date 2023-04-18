/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import entidades.Persona;
import java.util.List;

/**
 *
 * @author luis-
 */
public interface IPersona {
    public Persona agregarMasivo(Persona persona);
    public Persona agregar(Persona persona);
    public Persona buscarRFC(String rfc);
    List <Persona> buscarRfcTabla(String rfc);
    List <Persona> mostrarPersonas();
    
}
