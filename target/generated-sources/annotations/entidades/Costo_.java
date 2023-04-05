package entidades;

import entidades.Tramite;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-04T20:24:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Costo.class)
public class Costo_ { 

    public static volatile SingularAttribute<Costo, Integer> monto;
    public static volatile SingularAttribute<Costo, Integer> id;
    public static volatile SingularAttribute<Costo, Tramite> tramiteCosto;
    public static volatile SingularAttribute<Costo, Date> fechaPago;

}