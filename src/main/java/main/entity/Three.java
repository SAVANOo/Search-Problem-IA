package main.entity;

public class Three {
    public final Node oradea = new Node("oradea");

    public final Node zerind = new Node("zerind");

    public final Node arad = new Node("arad");

    public final Node sibiu = new Node("sibiu");

    public final Node timisoara = new Node("timisoara");

    public final Node lugoj = new Node("lugoj");

    public final Node mehadia = new Node("mehadia");

    public final Node drobeta = new Node("drobeta");

    public final Node craiova = new Node("craiova");

    public final Node riminicu_vilcea = new Node("riminicu vilcea");

    public final Node pitesti = new Node("pitesti");

    public final Node fagaras = new Node("fagaras");

    public final Node bucharest = new Node("bucharest");

    public final Node giurgiu = new Node("giurgiu");

    public final Node urziceni = new Node("urziceni");

    public final Node vaslui = new Node("vaslui");

    public final Node iasi = new Node("iasi");

    public final Node neamt = new Node("neamt");

    public final Node hirsova = new Node("hirsova");

    public final Node eforie = new Node("eforie");

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
}
