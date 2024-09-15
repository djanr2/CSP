package ia.iimas.unam.mx;


import ia.iimas.unam.mx.algorithm.ICSPAlgortithm;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.problem.map.coloring.AC3Solution;


import ia.iimas.unam.mx.problem.map.coloring.BacktrackSolution;
import ia.iimas.unam.mx.problem.map.coloring.MapColoring;
import ia.iimas.unam.mx.problem.map.coloring.OrderingSolution;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        int opcion = 0;

        IPropertiesCSP mcProblem = new MapColoring();

        ICSPAlgortithm algoritmo =  new BacktrackSolution();;


        Scanner s = new Scanner(System.in);
        System.out.println("Elige una numero como opcion:");
        System.out.println("Opcion por default numero 3");
        System.out.println();

        System.out.println("1. Algoritmo AC3 + Forward");
        System.out.println("2. Algoritmo Ordenamiento");
        System.out.println("3. Algoritmo Backtracking (Encuentra todas las soluciones al problema)");
        System.out.print("> ");


        try {
            opcion =  s.nextInt();
            switch (opcion){

                case 1:
                    algoritmo = new AC3Solution();
                    break;
                case 2:
                    algoritmo = new OrderingSolution();
                    break;
            }

        }catch (Exception e){
            algoritmo = new BacktrackSolution();
        }

        algoritmo.setCsp(mcProblem);
        algoritmo.run();

    }

}
