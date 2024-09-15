package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IDomain;

public enum Color implements IDomain {
    RED(1),
    GREEN(2),
    BLUE(3);

    private Color(int order){
        this.order = order;
    }
    private int order;

    @Override
    public int getOrder(){
        return this.order;
    }
}
