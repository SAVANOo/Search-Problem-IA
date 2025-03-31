package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.entity.Three;
import main.src.ResultAdapter;

import java.util.*;

public class GFS {

    public static ResultAdapter searchWithoutHeuristic(Node initial, Node target) {
        Map<Node, Integer> heuristicMap = target.calculateHeuristics();

        return search(initial, target, heuristicMap);
    }

    public static ResultAdapter search(Node initial, Node target, Map<Node, Integer> heuristicMap) {
        Three.getInstance().clearVisitedNodes();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(heuristicMap::get));
        Map<Node, Node> childAndOwner = new HashMap<>();

        queue.add(initial);
        initial.setVisited();

        while (!queue.isEmpty()) {
            Node process = queue.poll();

            if (process.equals(target)) {
                return ResultAdapter.fromTargetNode(childAndOwner, target);
            }

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                if (next.isVisited()) continue;

                childAndOwner.put(next, process);
                next.setVisited();
                queue.add(next);
            }
        }

        return null;
    }
}
