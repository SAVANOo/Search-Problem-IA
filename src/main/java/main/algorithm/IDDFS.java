package main.algorithm;

import main.entity.Node;
import main.src.ResultAdapter;

public class IDDFS {

    private static final int WITHOUT_LIMIT = -1;

    public static ResultAdapter searchWithDeepLimit(Node initial, Node target, Integer depth) {
        return search(initial, target, depth);
    }

    public static ResultAdapter search(Node initial, Node target) {
        return search(initial, target, WITHOUT_LIMIT);
    }

    private static ResultAdapter search(Node initial, Node target, Integer maxDepth) {
        Integer currentDepth = 0;

        while (true) {
            if (currentDepth >= maxDepth && maxDepth != WITHOUT_LIMIT) break;
            currentDepth++;

            ResultAdapter result = DFS.searchWithDeepLimit(initial, target, currentDepth);
            if (result != null) return result;
        }

        return null;
    }
}
