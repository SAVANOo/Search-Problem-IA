package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.entity.Three;
import main.src.ResultAdapter;

import java.util.*;

public class AStar {

    public static ResultAdapter search(Node initial, Node target, Map<Node, Integer> heuristicMap) {
        Three.getInstance().clearVisitedNodes();

        Map<Node, Integer> gCost = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> gCost.getOrDefault(node, Integer.MAX_VALUE) + heuristicMap.getOrDefault(node, 0)));
        Map<Node, Node> childAndOwner = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        gCost.put(initial, 0);
        queue.add(initial);
        childAndOwner.put(initial, null);

        while (!queue.isEmpty()) {
            Node process = queue.poll();

            if (!visited.add(process)) {
                continue;
            }

            if (process.equals(target)) {
                return ResultAdapter.fromTargetNode(childAndOwner, target);
            }

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                int newGCost = gCost.get(process) + neighbor.getDistance();

                if (newGCost < gCost.getOrDefault(next, Integer.MAX_VALUE)) {
                    gCost.put(next, newGCost);
                    queue.add(next);
                    childAndOwner.put(next, process);
                }
            }
        }

        return null;
    }
}
