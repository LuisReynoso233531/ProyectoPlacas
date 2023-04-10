package entidades;

import entidades.Costo;
import entidades.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-10T14:57:20", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile ListAttribute<Tramite, Costo> costos;
    public static volatile SingularAttribute<Tramite, String> tipo;
    public static volatile SingularAttribute<Tramite, Integer> costo;
    public static volatile SingularAttribute<Tramite, Date> fechaInicio;
    public static volatile SingularAttribute<Tramite, Persona> personasTramite;
    public static volatile SingularAttribute<Tramite, Integer> id;
    public static volatile SingularAttribute<Tramite, Date> fechaFin;

}