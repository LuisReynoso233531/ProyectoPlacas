/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Placas;

/**
 *
 * @author luis-
 */
public interface IPlacas {
    
   public Placas agregarPlacas(Placas placas);
  public void actualizarPlacas(String numeroPlacas, String estado);
    
}
