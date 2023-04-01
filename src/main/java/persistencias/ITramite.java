/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencias;

import entidades.Tramite;
import java.util.List;

/**
 *
 * @author luis-
 */
public interface ITramite {
    
    public Tramite solicitarLicencia(Tramite tramite);
    public Tramite solicitarPlacas(Tramite tramite);
    public Tramite renovarLicencia(Tramite tramite);
    public Tramite renovarPlacas(Tramite tramite);
    public List<Tramite> historial();
    
}
