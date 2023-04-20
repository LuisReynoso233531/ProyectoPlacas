/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

import entidades.Persona;
import java.util.Date;
import java.util.List;

/**
 * Esta es la clase abstracta IPersona
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public interface IPersona {

    /**
     * Método agregarMasivo(Persona persona) que se encarga de insertar 20
     * personas con todos sus datos correspondientes
     *
     * @param persona de tipo Persona
     * @return insert masivo de 20 personas con sus datos correspondientes
     */
    public Persona agregarMasivo(Persona persona);

    /**
     * Método agregar(Persona persona) que se encarga de insertar un dato
     *
     * @param persona de tipo Persona
     * @return persona
     */
    public Persona agregar(Persona persona);

    /**
     * Método buscarRFC(String rfc) que se encarga de buscar un dato
     *
     * @param rfc de tipo String
     * @return rfc
     */
    public Persona buscarRFC(String rfc);

    /**
     * Método buscarRfcTabla(String rfc) que se encarga de buscar datos en una
     * lista
     *
     * @param rfc de tipo String
     * @return rfc
     */
    List<Persona> buscarRfcTabla(String rfc);

    /**
     * Método mostrarPersonas() que se encarga de mostrar una lista de personas
     *
     * @return lista de personas
     */
    List<Persona> mostrarPersonas();

}
