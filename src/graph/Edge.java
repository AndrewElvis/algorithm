package graph;

/**
 * @author AndrewElvis
 * @date 2020-03-21-16:58
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
