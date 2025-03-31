package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
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
        Deque<Node> stack = new ArrayDeque<>();
        Map<Node, Integer> depthMap = new HashMap<>();
        Map<Node, Node> childAndOwner = new HashMap<>();
        List<Node> visited = new LinkedList<>();

        stack.push(initial);
        visited.add(initial);
        depthMap.put(initial, 0);

        while (!stack.isEmpty()) {
            Node process = stack.pop();
            int currentDepth = depthMap.get(process);

            if (process.equals(target)) break;
            if (maxDepth != -1 && currentDepth >= maxDepth) continue;

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                if (visited.contains(next)) continue;

                childAndOwner.put(next, process);
                visited.add(next);
                stack.push(next);
                depthMap.put(next, currentDepth + 1);
            }
        }

        return ResultAdapter.fromTargetNode(childAndOwner, target);
    }
}
