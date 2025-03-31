package main.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private final String name;

    private final List<Neighbor> neighborList;

    private Boolean isVisited = false;

    public Node(String name) {
        this.name = name;
        this.neighborList = new ArrayList<Neighbor>();
    }

    public void setVisited() {
        this.isVisited = true;
    }

    public void setUnvisited() {
        this.isVisited = false;
    }

    public Boolean isVisited() {
        return this.isVisited;
    }

    public String getName() {
        return name;
    }

    public List<Neighbor> getNeighborList() {
        return this.neighborList;
    }

    public void addNeighbor(Node neighbor, Integer distance) {
        this.neighborList.add(new Neighbor(neighbor, distance));
    }

    public Neighbor getNeighbor(Node search) {
        for (Neighbor neighbor : this.getNeighborList()) {
            if (neighbor.getNode().equals(search)) {
                return neighbor;
            }
        }

        return null;
    }

    public Map<Node, Integer> calculateHeuristics() {
        Map<Node, Integer> heuristicMap = new HashMap<>();
        for (Node node : Three.getInstance().getNodeList()) {
            heuristicMap.put(node, estimateDistance(node, this));
        }
        return heuristicMap;
    }

    private static int estimateDistance(Node node, Node target) {
        return Math.abs(node.getName().hashCode() - target.getName().hashCode()) % 100;
    }
}
