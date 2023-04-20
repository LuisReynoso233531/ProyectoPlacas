/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Tramite;
import java.util.Date;
import java.util.List;

/**
 * Esta es la clase abstracta ITramite
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martin Reynoso Cibrian
 * 00000233531
 */
public interface ITramite {

    /**
     * Método mostrarTramite(); que se encarga de mostrar una lista de trámites
     *
     * @return lista de trámites
     */
    List<Tramite> mostrarTramite();

    /**
     * Método buscarTipo(String tipo) que se encarga de buscar un trámite por
     * tipo
     *
     * @param tipo de tipo String
     * @return lista de trámites por tipo
     */
    List<Tramite> buscarTipo(String tipo);

    /**
     * Método buscarPorId(int id) que se encarga de buscar trámites por id
     *
     * @param id de tipo int
     * @return lista de trámites por id
     */
    List<Tramite> buscarPorId(int id);

    /**
     * Método buscarPorFecha(Date fecha) que se encarga de buscar trámites por
     * fecha
     *
     * @param fecha de tipo Date
     * @return lista de trámites por fecha
     */
    List<Tramite> buscarPorFecha(Date fecha);

    /**
     * Método buscarPeriodo(Date fechaInicio, Date fechaFin) que se encarga de
     * buscar trámites por periodo
     *
     * @param fechaInicio de tipo Date
     * @param fechaFin de tipo Date
     * @return lista de trámites por periodo
     */
    List<Tramite> buscarPeriodo(Date fechaInicio, Date fechaFin);

    /**
     * Método buscarRFC(String rfc) que se encarga de buscar trámites por rfc
     *
     * @param rfc de tipo String
     * @return lista de trámites por RFC
     */
    List<Tramite> buscarRFC(String rfc);

    /**
     * Método buscarNombre(String nombres) que se encarga de buscar trámites por
     * nombre
     *
     * @param nombres de tipo String
     * @return lista de trámites por nombre
     */
    List<Tramite> buscarNombre(String nombres);

    /**
     * Método buscarNombrePeriodo(String nombres, Date fechaInicio, Date
     * fechaFin) que se encarga de buscar un trámite por nombre y periodo
     *
     * @param nombres de tipo String
     * @param fechaInicio de tipo Date
     * @param fechaFin de tipo Date
     * @return lista de trámites por nombre y periodo
     */
    List<Tramite> buscarNombrePeriodo(String nombres, Date fechaInicio, Date fechaFin);
}
