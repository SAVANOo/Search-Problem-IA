package main.src;

public enum Algorithm {
    BFS(false),
    BIDIRECTIONAL(false),
    DFS(false),
    DLS(true),
    IDDFS(true),
    UCS(false);

    private final boolean supportsLimit;

    Algorithm(boolean supportsLimit) {
        this.supportsLimit = supportsLimit;
    }

    public boolean supportsLimit() {
        return supportsLimit;
    }
}
