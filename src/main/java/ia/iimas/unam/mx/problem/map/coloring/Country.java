package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IVariable;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Country implements IVariable{

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

    public IDomain getColor() {
        return color;
    }

    @Override
    public boolean addNeighbor(IVariable neighbor) {
        return this.neighbors.add(neighbor);
    }

    @Override
    public boolean removeNighbor(IVariable neighbor) {
        return this.neighbors.remove(neighbor);
    }

    @Override
    public int countLegalValues() {
        return this.domain.size();
    }

    @Override
    public Country cloneElement(){
        Country c = new Country(this.country);
        c.setDomain(new HashSet<>(this.domain));
        c.setNeighbors(new HashSet<>(this.neighbors));
        c.setConstrains(new HashSet<>(this.constraints));
        c.setColor(this.color);
        return c;
    }

    public CountryEnum getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return "{"+this.getCountry()+":"+((this.color!=null)?this.color:"")+"}";
        /*return "{"+this.getCountry()+":"+((this.color!=null)?this.color:"")+"}->"+this.domain+"";*/
    }

    public boolean setColor(IDomain color){
        if (color==null){
            this.color = null;
        }else if (this.domain.contains(color)){
            this.color = color;
            removeDomainFromNeighbors(color);
            this.removeDomainElement(color);
            return true;
        }
            return false;

    }

    private void removeNighborfromNeighbors(IVariable neighbor) {
        for(IVariable node: this.neighbors){
            Country country = (Country) node;
            if(country.getColor()==null){
                country.removeNighbor(neighbor);
            }
        }
    }

    public void removeColor(){
        IDomain color = this.color;
        if (this.color != null){
            this.domain.add(this.color);
            this.color = null;
            addDomainToNeighbors(color);

        }
    }



    private void removeDomainFromNeighbors(IDomain color){
        for(IVariable node: this.neighbors){
            Country country = (Country) node;
                country.removeDomainElement(color);
        }
    }

    private void addDomainToNeighbors(IDomain color){
        for(IVariable node: this.neighbors){
            Country country = (Country) node;
            if(!isNeighborHasAssignedDomain(color, country.getNeighbors())){
                country.addDomainElement(color);
            }
        }
    }

    public boolean hasConstraintNeighbors(IConstraint constraint){

        for (IVariable var: this.neighbors){
            Country neighbor = (Country) var;

            if(constraint.areConstrained(this, neighbor)){
                if(this.getColor() != null &&
                   neighbor.getColor() != null &&
                   this.getColor().equals(neighbor.getColor())){
                    return true;
                }
            }
        }
        return false;
    }

    public IDomain getRandomColor(){
        if (this.domain.size()>0){
            int size = this.domain.size();

            int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
            int i = 0;
            for(IDomain obj : this.domain)
            {
                if (i == item)
                    return obj;
                i++;
            }
        }
        return null;
    }

    private boolean isNeighborHasAssignedDomain(IDomain color,Set<IVariable> neighbors){

        for (IVariable var: neighbors){
            Country c = (Country) var;
            if (c.getColor()==color){
                return true;
            }
        }
        return false;
    }


}
