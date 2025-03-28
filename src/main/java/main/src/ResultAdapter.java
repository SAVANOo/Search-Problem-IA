package main.src;

import main.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultAdapter {
    private final List<Node> path;

    public ResultAdapter(List<Node> path) {
        this.path = path;
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
