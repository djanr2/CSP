package ia.iimas.unam.mx.model;

import ia.iimas.unam.mx.problem.map.coloring.Country;

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

    boolean removeNighbor(IVariable element);

    int countLegalValues();

    Country cloneElement();

}
