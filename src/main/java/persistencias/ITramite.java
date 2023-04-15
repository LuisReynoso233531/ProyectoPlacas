/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Tramite;
import java.util.Date;
import java.util.List;

/**
 *
 * @author luis-
 */
public interface ITramite {
    List<Tramite> mostrarTramite();
    List<Tramite> buscarTipo(String tipo);
    List<Tramite> buscarPorId(int id);
    List<Tramite> buscarPorFecha(Date fecha);
    List<Tramite> buscarPeriodo(Date fechaInicio, Date fechaFin);
    List<Tramite> buscarRFC(String rfc);
    List<Tramite> buscarNombre(String nombres);
}
