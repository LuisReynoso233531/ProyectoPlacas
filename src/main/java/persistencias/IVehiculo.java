/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Persona;
import entidades.Vehiculo;
import java.util.List;

/**
 * Esta es la clase abstracta IVehiculo
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public interface IVehiculo {

    /**
     * Método agregar(Vehiculo vehiculo) que se encarga de insertar un dato
     *
     * @param vehiculo de tipo Vehiculo
     * @return vehiculo
     */
    public Vehiculo agregar(Vehiculo vehiculo);

    /**
     * Método buscarRFC(String rfc) que se encarga de buscar un dato
     *
     * @param rfc de tipo String
     * @return rfc
     */
    List<Vehiculo> buscarRFC(String rfc);
}
