/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Costo;

/**
 * Esta es la clase abstracta ICosto
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public interface ICosto {

    /**
     * Método agregar(Costo costo) que se encarga insertar un dato
     *
     * @param costo de tipo Costo
     * @return costo
     */
    public Costo agregar(Costo costo);

}
