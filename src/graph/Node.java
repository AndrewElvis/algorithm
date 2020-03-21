package graph;

import java.util.ArrayList;

/**
 * @author AndrewElvis
 * @date 2020-03-21-16:58
 */
public class Node {
    public int value;
    public int out;
    public int in;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        out = 0;
        in = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
