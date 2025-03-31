package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.src.ResultAdapter;

import java.util.*;

public class DFS {

    public static ResultAdapter search(Node initial, Node target) {
        Deque<Node> stack = new ArrayDeque<>();
        List<Node> visited = new LinkedList<>();
        Map<Node, Node> childAndOwner = new HashMap<>();

        stack.push(initial);
        visited.add(initial);

        while (!stack.isEmpty()) {
            Node process = stack.pop();
            if (process.equals(target)) break;

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                if (visited.contains(next)) continue;

                childAndOwner.put(next, process);
                visited.add(next);
                stack.push(next);
            }
        }

        return ResultAdapter.fromTargetNode(childAndOwner, target);
    }
}
