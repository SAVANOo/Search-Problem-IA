package main.entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;

    private final List<Neighbor> neighborList;

    public Node(String name) {
        this.name = name;
        this.neighborList = new ArrayList<Neighbor>();
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
}
