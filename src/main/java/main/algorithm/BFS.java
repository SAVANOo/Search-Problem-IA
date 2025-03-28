package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.src.ResultAdapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BFS {

    public static ResultAdapter search(Node initial, Node target) {
        List<Node> queue = new LinkedList<>();
        List<Node> visitedList = new LinkedList<>();
        Map<Node, Node> childAndOwner = new HashMap<Node, Node>();

        queue.addLast(initial);
        visitedList.add(initial);
        childAndOwner.put(initial, null);

        while (!queue.isEmpty()) {
            Node process = queue.removeFirst();

            if (process.equals(target)) break;

            for (Neighbor next : process.getNeighborList()) {
                Node nextNode = next.getNode();

                if (!visitedList.contains(nextNode)) {
                    visitedList.add(nextNode);
                    queue.addLast(nextNode);
                    childAndOwner.put(nextNode, process);
                }
            }
        }

        return buildResult(childAndOwner, target);
    }

    private static ResultAdapter buildResult(Map<Node, Node> childAndOwner, Node target) {
        List<Node> path = new LinkedList<>();

        for (Node owner = target; owner != null; owner = childAndOwner.get(owner)) {
            path.addFirst(owner);
        }

        return new ResultAdapter(path);
    }
}
