package ia.iimas.unam.mx.algorithm;

import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;
import ia.iimas.unam.mx.problem.map.coloring.Country;

public abstract class OrderingAlgorithm implements ICSPAlgortithm{
    protected IPropertiesCSP csp;

    @Override
    public IPropertiesCSP getCsp() {
        return csp;
    }
    @Override
    public void setCsp(IPropertiesCSP csp) {
        this.csp = csp;
    }
    protected static void printCountry(IVariable country){
        Country c = (Country) country;
        System.out.print("Valor elegido: "+c);
        System.out.println();
        System.out.println();
    }

    protected static void printDomain(IVariable country){
        Country c = (Country) country;
        System.out.print(c);
        System.out.println(" Valores de dominio a elegir: "+ country.getDomain());
    }
}
