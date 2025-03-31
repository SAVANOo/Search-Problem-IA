package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.src.ResultAdapter;

import java.util.*;

public class BFS {

    public static ResultAdapter search(Node initial, Node target) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> visitedList = new LinkedList<>();
        Map<Node, Node> childAndOwner = new HashMap<>();

        queue.add(initial);
        visitedList.add(initial);
        childAndOwner.put(initial, null);

        while (!queue.isEmpty()) {
            Node process = queue.poll();

            if (process.equals(target)) break;

            for (Neighbor neighbor : process.getNeighborList()) {
                Node next = neighbor.getNode();
                if (visitedList.contains(next)) continue;

                visitedList.add(next);
                queue.add(next);
                childAndOwner.put(next, process);
            }
        }

        return ResultAdapter.fromTargetNode(childAndOwner, target);
    }
}
