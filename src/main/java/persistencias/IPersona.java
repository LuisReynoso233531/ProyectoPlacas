/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import entidades.Persona;

/**
 *
 * @author luis-
 */
public interface IPersona {
    public Persona agregarMasivo(Persona persona);
    public Persona agregar(Persona persona);
    public Persona agregarEmpleado(Persona persona);
    
}
