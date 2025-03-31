package main.src;

import main.entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultAdapter {
    private final List<Node> path;

    public ResultAdapter(List<Node> path) {
        this.path = path;
    }

    public List<Node> getPath() {
        return this.path;
    }

    public static ResultAdapter fromTargetNode(Map<Node, Node> childAndOwner, Node target) {
        List<Node> path = new LinkedList<>();

        for (Node owner = target; owner != null; owner = childAndOwner.get(owner)) {
            path.addFirst(owner);
        }

        return new ResultAdapter(path);
    }

    public String buildFormattedResultPath() {
        return this.path.stream().map(Node::getName).collect(Collectors.joining(" -> "));
    }

    public Integer getSumTotalDistance() {
        int totalDistance = 0;

        for (int i = 0; i < this.path.size() - 1; i++) {
            Node current = this.path.get(i);
            Node next = this.path.get(i + 1);

            totalDistance += current.getNeighbor(next).getDistance();
        }

        return totalDistance;
    }

    public String buildResultSumDistanceFormatted() {
        List<String> distanceList = new ArrayList<>();

        for (int i = 0; i < this.path.size() - 1; i++) {
            Node current = this.path.get(i);
            Node next = this.path.get(i + 1);

            distanceList.add(String.valueOf(current.getNeighbor(next).getDistance()));
        }

        return String.join(" + ", distanceList) + " = " + getSumTotalDistance();
    }
}
