package graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author AndrewElvis
 * @date 2020-03-21-16:55
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet();
    }
}
