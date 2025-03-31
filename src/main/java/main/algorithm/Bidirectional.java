package main.algorithm;

import main.entity.Neighbor;
import main.entity.Node;
import main.src.ResultAdapter;

import java.util.*;

public class Bidirectional {

    public static ResultAdapter search(Node initial, Node target) {
        Map<Node, Node> forwardVisited = new HashMap<>();
        Map<Node, Node> backwardVisited = new HashMap<>();
        forwardVisited.put(initial, null);
        backwardVisited.put(target, null);

        Queue<Node> forwardQueue = new ArrayDeque<>();
        Queue<Node> backwardQueue = new ArrayDeque<>();
        forwardQueue.add(initial);
        backwardQueue.add(target);

        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            if (expandSearch(forwardQueue, forwardVisited, backwardVisited)) break;

            if (expandSearch(backwardQueue, backwardVisited, forwardVisited)) break;
        }

        return buildResult(forwardVisited, backwardVisited);
    }

    private static boolean expandSearch(Queue<Node> queue, Map<Node, Node> visited, Map<Node, Node> otherVisited) {
        Node node = queue.poll();

        for (Neighbor neighbor : node.getNeighborList()) {
            Node next = neighbor.getNode();

            if (!visited.containsKey(next)) {
                visited.put(next, node);
                queue.add(next);
            }

            if (otherVisited.containsKey(next)) return true;
        }

        return false;
    }

    private static ResultAdapter buildResult(Map<Node, Node> forwardVisited, Map<Node, Node> backwardVisited) {
        List<Node> path = new LinkedList<>();

        Node meetingNode = null;
        for (Node node : forwardVisited.keySet()) {
            if (backwardVisited.containsKey(node)) {
                meetingNode = node;
                break;
            }
        }

        if (meetingNode == null) return new ResultAdapter(Collections.emptyList());

        Node currentNode = meetingNode;
        while (currentNode != null) {
            path.addFirst(currentNode);
            currentNode = forwardVisited.get(currentNode);
        }

        currentNode = backwardVisited.get(meetingNode);
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = backwardVisited.get(currentNode);
        }

        return new ResultAdapter(path);
    }
}
