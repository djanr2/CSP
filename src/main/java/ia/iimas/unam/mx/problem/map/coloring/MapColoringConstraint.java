package ia.iimas.unam.mx.problem.map.coloring;


import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IVariable;


public enum MapColoringConstraint implements IConstraint {
    DIFFERENT_COLOR;

    @Override
    public boolean areConstrained(IVariable a, IVariable b){

        if(a.getConstraints().contains(DIFFERENT_COLOR) ||
           b.getConstraints().contains(DIFFERENT_COLOR)){
            return true;
        }

        return false;
    }
}
