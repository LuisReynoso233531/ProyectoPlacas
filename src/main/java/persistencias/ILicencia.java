/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Licencia;

/**
 *
 * @author luis-
 */
public interface ILicencia {
    
    public Licencia agregarLicencia(Licencia licencia);
    public Licencia renovarLicencia(Licencia licencia);
}
