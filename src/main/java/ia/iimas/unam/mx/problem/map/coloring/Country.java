package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IVariable;

import java.util.HashSet;
import java.util.Set;


public class Country implements IVariable {

    private IDomain color;

    private Set<IConstraint> constraints;

    private Set<IDomain> domain;

    private Set<IVariable> neighbors;

    private CountryEnum country;

    Country(CountryEnum country){
        this.country= country;
    }

    @Override
    public Set<IConstraint> getConstraints() {
        return this.constraints;
    }

    @Override
    public void setConstrains(Set<IConstraint> constrains) {
        this.constraints = new HashSet<>(constrains);
    }

    @Override
    public Set<IDomain> getDomain() {
        return this.domain;
    }

    @Override
    public void setDomain(Set<IDomain> domain) {
        this.domain =  new HashSet<>(domain);
    }

    @Override
    public boolean removeDomainElement(IDomain domain) {
        return this.domain.remove(domain);
    }

    @Override
    public boolean removeConstraint(IConstraint constraint) {
        return this.constraints.remove(constraint);
    }

    @Override
    public boolean addDomainElement(IDomain domain) {
        return this.domain.add(domain);
    }

    @Override
    public boolean addConstraintElement(IConstraint constraint) {
        return this.constraints.add(constraint);
    }

    @Override
    public void setNeighbors(Set<IVariable> neighbors) {
        this.neighbors =new HashSet<>(neighbors);
    }

    @Override
    public Set<IVariable> getNeighbors() {
        return this.neighbors;
    }

    @Override
    public boolean addNeighbor(IVariable neighbor) {
        return this.neighbors.add(neighbor);
    }

    @Override
    public boolean removenNighbor(IVariable neighbor) {
        return this.neighbors.remove(neighbor);
    }

    public CountryEnum getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return "{"+this.getCountry()+":"+((this.color!=null)?this.color:"")+"}->"+this.domain+"";
    }

    public void setColor(IDomain color){
        if (this.domain.contains(color)){
            this.color = color;
            removeDomainFromNeighbors(color);
            this.domain.clear();
        }else{
            if(this.color==null){
                throw new RuntimeException("No hay valores en el dominio para este pais");
            }
        }
    }

    private void removeDomainFromNeighbors(IDomain color){
        for(IVariable node: this.neighbors){
            Country country = (Country) node;
            country.removeDomainElement(color);
        }
    }
}
