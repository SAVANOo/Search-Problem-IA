package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.entity.Three;
import main.src.ResultAdapter;

import java.util.*;

public class DFS {

    public static ResultAdapter searchWithDeepLimit(Node initial, Node target, Integer maxDepth) {
        return search(initial, target, maxDepth);
    }

    public static ResultAdapter search(Node initial, Node target) {
        return search(initial, target, -1);
    }

    private static ResultAdapter search(Node initial, Node target, Integer maxDepth) {
        Three.getInstance().clearVisitedNodes();
        Deque<Node> stack = new ArrayDeque<>();
        Map<Node, Integer> depthMap = new HashMap<>();
        Map<Node, Node> childAndOwner = new HashMap<>();

        stack.push(initial);
        initial.setVisited();
        depthMap.put(initial, 0);

        while (!stack.isEmpty()) {
            Node process = stack.pop();
            int currentDepth = depthMap.get(process);

            if (process.equals(target)) return ResultAdapter.fromTargetNode(childAndOwner, target);
            if (maxDepth != -1 && currentDepth >= maxDepth) continue;

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                if (next.isVisited()) continue;

                childAndOwner.put(next, process);
                next.setVisited();
                stack.push(next);
                depthMap.put(next, currentDepth + 1);
            }
        }

        return null;
    }
}
