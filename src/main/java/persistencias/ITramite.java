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
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
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
