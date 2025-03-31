package main.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Three {
    public final Node oradea = new Node("Oradea");

    public final Node zerind = new Node("Zerind");

    public final Node arad = new Node("Arad");

    public final Node sibiu = new Node("Sibiu");

    public final Node timisoara = new Node("Timisoara");

    public final Node lugoj = new Node("Lugoj");

    public final Node mehadia = new Node("Mehadia");

    public final Node drobeta = new Node("Drobeta");

    public final Node craiova = new Node("Craiova");

    public final Node riminicu_vilcea = new Node("Riminicu Vilcea");

    public final Node pitesti = new Node("Pitesti");

    public final Node fagaras = new Node("Fagaras");

    public final Node bucharest = new Node("Bucharest");

    public final Node giurgiu = new Node("Giurgiu");

    public final Node urziceni = new Node("Urziceni");

    public final Node vaslui = new Node("Vaslui");

    public final Node iasi = new Node("Iasi");

    public final Node neamt = new Node("Neamt");

    public final Node hirsova = new Node("Hirsova");

    public final Node eforie = new Node("Eforie");

    private static Three instance;

    public static Three getInstance() {
        if (instance == null) instance = new Three();

        return instance;
    }

    private Three() {
        this.oradea.addNeighbor(zerind, 71);
        this.oradea.addNeighbor(sibiu, 151);

        this.zerind.addNeighbor(oradea, 71);
        this.zerind.addNeighbor(arad, 75);

        this.arad.addNeighbor(zerind, 75);
        this.arad.addNeighbor(sibiu, 140);
        this.arad.addNeighbor(timisoara, 118);

        this.timisoara.addNeighbor(arad, 118);
        this.timisoara.addNeighbor(lugoj, 111);

        this.lugoj.addNeighbor(timisoara, 111);
        this.lugoj.addNeighbor(mehadia, 70);

        this.mehadia.addNeighbor(lugoj, 70);
        this.mehadia.addNeighbor(drobeta, 75);

        this.drobeta.addNeighbor(mehadia, 75);
        this.drobeta.addNeighbor(craiova, 120);

        this.craiova.addNeighbor(riminicu_vilcea, 146);
        this.craiova.addNeighbor(drobeta, 120);
        this.craiova.addNeighbor(pitesti, 138);

        this.riminicu_vilcea.addNeighbor(craiova, 146);
        this.riminicu_vilcea.addNeighbor(pitesti, 97);
        this.riminicu_vilcea.addNeighbor(sibiu, 80);

        this.pitesti.addNeighbor(craiova, 138);
        this.pitesti.addNeighbor(riminicu_vilcea, 97);
        this.pitesti.addNeighbor(bucharest, 101);

        this.sibiu.addNeighbor(oradea, 151);
        this.sibiu.addNeighbor(arad, 140);
        this.sibiu.addNeighbor(riminicu_vilcea, 80);
        this.sibiu.addNeighbor(fagaras, 99);

        this.fagaras.addNeighbor(sibiu, 99);
        this.fagaras.addNeighbor(bucharest, 211);

        this.bucharest.addNeighbor(fagaras, 211);
        this.bucharest.addNeighbor(giurgiu, 90);
        this.bucharest.addNeighbor(pitesti, 101);
        this.bucharest.addNeighbor(urziceni, 85);

        this.giurgiu.addNeighbor(bucharest, 90);

        this.urziceni.addNeighbor(bucharest, 85);
        this.urziceni.addNeighbor(hirsova, 98);
        this.urziceni.addNeighbor(vaslui, 142);

        this.hirsova.addNeighbor(urziceni, 98);
        this.hirsova.addNeighbor(eforie, 86);

        this.eforie.addNeighbor(hirsova, 86);

        this.vaslui.addNeighbor(urziceni, 142);
        this.vaslui.addNeighbor(iasi, 92);

        this.iasi.addNeighbor(neamt, 87);
        this.iasi.addNeighbor(vaslui, 92);

        this.neamt.addNeighbor(iasi, 87);
    }

    public List<Node> getNodeList() {
        List<Node> nodeList = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getType().equals(Node.class)) {
                try {
                    field.setAccessible(true);
                    Node node = (Node) field.get(this);
                    nodeList.add(node);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return nodeList;
    }

    public void clearVisitedNodes() {
        for (Node node : getNodeList()) {
            node.setUnvisited();
        }
    }

    public String[] getNodeNameList() {
        List<String> nodeNameList = new ArrayList<>();

        for (Node node : getNodeList()) {
            nodeNameList.add(node.getName());
        }

        return nodeNameList.toArray(new String[0]);
    }

    public Node getNodeFromName(String name) {
        for (Node node : getNodeList()) {
            if (node.getName().equals(name)) {
                return node;
            }
        }

        return null;
    }
}
