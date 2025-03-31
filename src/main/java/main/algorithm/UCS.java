package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.entity.Three;
import main.src.ResultAdapter;

import java.util.*;

public class UCS {

    public static ResultAdapter search(Node initial, Node target) {
        Three.getInstance().clearVisitedNodes();

        Map<Node, Integer> nodeCosts = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(nodeCosts::get));
        Map<Node, Node> childAndOwner = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        nodeCosts.put(initial, 0);
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
                Integer newCost = nodeCosts.get(process) + neighbor.getDistance();

                if (newCost < nodeCosts.getOrDefault(next, Integer.MAX_VALUE)) {
                    nodeCosts.put(next, newCost);
                    queue.add(next);
                    childAndOwner.put(next, process);
                }
            }
        }

        return null;
    }
}