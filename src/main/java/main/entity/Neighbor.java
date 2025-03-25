package main.entity;

public class Neighbor {
    Node node;

    Integer distance;

    public Neighbor(Node node, Integer distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }

    public Integer getDistance() {
        return distance;
    }
}
