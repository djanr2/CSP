package ia.iimas.unam.mx.algorithm;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;

import java.util.HashSet;

public interface ICSPAlgortithm {

    IPropertiesCSP getCsp();

    void setCsp(IPropertiesCSP csp);

    void run();

}
