package main;

import main.algorithm.BFS;
import main.algorithm.Bidirectional;
import main.algorithm.DFS;
import main.algorithm.IDDFS;
import main.entity.Node;
import main.entity.Three;
import main.src.ResultAdapter;

public class Main {
    public static void main(String[] args) {
        Three three = Three.getInstance();

        Node inicial = three.oradea;
        Node objetivo = three.craiova;
        System.out.println("Começando por: " + inicial.getName());
        System.out.println("Iremos procurar o: " + objetivo.getName());
        System.out.println("\n");

        ResultAdapter result = BFS.search(inicial, objetivo);
        System.out.println("BFS: ");
        System.out.println(result.buildFormattedResultPath());
        System.out.println(result.buildResultSumDistanceFormatted());
        System.out.println("\n");

        ResultAdapter resultDFS = DFS.search(inicial, objetivo);
        System.out.println("DFS: ");
        System.out.println(resultDFS.buildFormattedResultPath());
        System.out.println(resultDFS.buildResultSumDistanceFormatted());
        System.out.println("\n");

        ResultAdapter resultDFSWithLimit = DFS.searchWithDeepLimit(inicial, objetivo, 4);
        System.out.println("DFS com limite de profundidade: ");
        System.out.println(resultDFSWithLimit.buildFormattedResultPath());
        System.out.println(resultDFSWithLimit.buildResultSumDistanceFormatted());
        System.out.println("\n");

        ResultAdapter resultIDDFS = IDDFS.search(inicial, objetivo);
        System.out.println("IDDFS: ");
        System.out.println(resultIDDFS.buildFormattedResultPath());
        System.out.println(resultIDDFS.buildResultSumDistanceFormatted());
        System.out.println("\n");

        ResultAdapter resultIDDFSWithLimit = IDDFS.searchWithDeepLimit(inicial, objetivo, 4);
        System.out.println("IDDFS com limite de profundidade: ");
        System.out.println(resultIDDFSWithLimit.buildFormattedResultPath());
        System.out.println(resultIDDFSWithLimit.buildResultSumDistanceFormatted());
        System.out.println("\n");

        ResultAdapter direcionalResult = Bidirectional.search(Three.getInstance().oradea, Three.getInstance().lugoj);
        System.out.println("Direcional: ");
        System.out.println(direcionalResult.buildFormattedResultPath());
        System.out.println(direcionalResult.buildResultSumDistanceFormatted());
        System.out.println("\n");
    }
}