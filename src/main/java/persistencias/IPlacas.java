/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Placas;

/**
 * Esta es la clase abstracta IPlacas
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public interface IPlacas {

    /**
     * Método agregarPlacas(Placas placas) que se encarga de insertar un dato
     *
     * @param placas de tipo Placas
     * @return placas
     */
    public Placas agregarPlacas(Placas placas);

    /**
     * Método actualizarPlacas(String numeroPlacas, String estado) que se
     * encarga de actualizar un dato
     *
     * @param numeroPlacas de tipo String
     * @param estado de tipo String
     */
    public void actualizarPlacas(String numeroPlacas, String estado);

    /**
     * Método buscarPorVehiculo(String vehiculo) que se encarga de buscar un
     * dato
     *
     * @param vehiculo de tipo String
     * @return vehiculo
     */
    public Placas buscarPorVehiculo(String vehiculo);

}
