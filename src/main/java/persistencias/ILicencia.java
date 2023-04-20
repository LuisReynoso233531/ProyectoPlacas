/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Licencia;
import entidades.Persona;

/**
 * Esta es la clase abstracta ILicencia
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public interface ILicencia {

    /**
     * Método agregarLicencia(Licencia licencia) que se encarga de insertar un
     * dato
     *
     * @param licencia de tipo Licencia
     * @return licencia
     */
    public Licencia agregarLicencia(Licencia licencia);

    /**
     * Método renovarLicencia(String id_licencia, String estado) que se encarga
     * de renovar un dato
     *
     * @param id_licencia de tipo String
     * @param estado de tipo String
     */
    public void renovarLicencia(String id_licencia, String estado);

    /**
     * Método buscarPorLicencia(String id_licencia) que se encarga de buscar un
     * dato
     *
     * @param id_licencia de tipo String
     * @return licencia
     */
    public Licencia buscarPorLicencia(String id_licencia);
    
}
