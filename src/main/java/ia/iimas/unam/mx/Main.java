package ia.iimas.unam.mx;


import ia.iimas.unam.mx.algorithm.ICSPAlgortithm;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.problem.map.coloring.AC3Solution;


import ia.iimas.unam.mx.problem.map.coloring.BacktrackSolution;
import ia.iimas.unam.mx.problem.map.coloring.MapColoring;
import ia.iimas.unam.mx.problem.map.coloring.OrderingSolution;


public class Main {


    public static void main(String[] args) {

        IPropertiesCSP mcProblem = new MapColoring();

        ICSPAlgortithm ac3 = new AC3Solution();

        ICSPAlgortithm ordering = new OrderingSolution();

        ICSPAlgortithm backtracking = new BacktrackSolution();

        ordering.setCsp(mcProblem);

        ordering.run();

    }

}
