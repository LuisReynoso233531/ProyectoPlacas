/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Licencia;

/**
 *
 * @author Alejandro Gil Aguilar 00000228773 - Luis Martín Reynoso Cibrian
 * 00000233531
 */
public interface ILicencia {

    public Licencia agregarLicencia(Licencia licencia);

    public void renovarLicencia(String id_licencia, String estado);

    public Licencia buscarPorLicencia(String id_licencia);

}
