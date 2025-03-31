package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.entity.Three;
import main.src.ResultAdapter;

import java.util.*;

public class BFS {

    public static ResultAdapter search(Node initial, Node target) {
        Three.clearVisitedNodes();
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> childAndOwner = new HashMap<>();

        queue.add(initial);
        initial.setVisited();
        childAndOwner.put(initial, null);

        while (!queue.isEmpty()) {
            Node process = queue.poll();

            if (process.equals(target)) return ResultAdapter.fromTargetNode(childAndOwner, target);

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                if (next.isVisited()) continue;

                next.setVisited();
                queue.add(next);
                childAndOwner.put(next, process);
            }
        }

        return null;
    }
}
