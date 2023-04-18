/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Persona;
import entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author luis-
 */
public interface IVehiculo {
    public Vehiculo agregar(Vehiculo vehiculo);
    List<Vehiculo> buscarRFC(String rfc);
}
