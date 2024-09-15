package ia.iimas.unam.mx.model;

import java.util.HashSet;

public interface IPropertiesCSP {
    HashSet<IConstraint> getGeneralConstraints();
    HashSet<IDomain> getGeneralDomain();
    HashSet<IVariable> getArcs();

}
