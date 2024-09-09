package ia.iimas.unam.mx.model;

import java.util.List;
import java.util.Set;

public interface IVariable{
    Set<IConstraint> getConstraints();
    void setConstrains(Set<IConstraint> constrains);

    Set<IDomain> getDomain();

    void setDomain(Set<IDomain> constrains);

    boolean removeDomainElement(IDomain domain);

    boolean removeConstraint(IConstraint element);

    boolean addDomainElement(IDomain element);

    boolean addConstraintElement(IConstraint element);

    void setNeighbors(Set<IVariable> neighbors);

    Set<IVariable> getNeighbors();

    boolean addNeighbor(IVariable element);

    boolean removenNighbor(IVariable element);



}
