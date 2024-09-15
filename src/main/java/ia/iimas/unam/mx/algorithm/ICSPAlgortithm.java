package ia.iimas.unam.mx.algorithm;

import ia.iimas.unam.mx.model.IPropertiesCSP;

public interface ICSPAlgortithm {

    IPropertiesCSP getCsp();

    void setCsp(IPropertiesCSP csp);

    void run();

}
