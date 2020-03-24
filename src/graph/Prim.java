package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author AndrewElvis
 * @date 2020-03-22-20:43
 */
//最小生成树prim算法(Prim Minimum Spanning Tree)
public class Prim {

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new EdgeComparator());
        Set<Node> visited = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node cur : graph.nodes.values()) {
            if (!visited.contains(cur)) {
                visited.add(cur);
                priorityQueue.addAll(cur.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!visited.contains(toNode)) {
                        result.add(edge);
                        visited.add(toNode);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }


}
