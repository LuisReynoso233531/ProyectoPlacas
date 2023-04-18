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
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public interface IVehiculo {

    public Vehiculo agregar(Vehiculo vehiculo);

    List<Vehiculo> buscarRFC(String rfc);
}
