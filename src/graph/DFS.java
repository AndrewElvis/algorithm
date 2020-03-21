package graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author AndrewElvis
 * @date 2020-03-21-19:26
 */
//图的深度优先遍历
public class DFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet<>();
        System.out.println(node.value);
        stack.push(node);
        visited.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!visited.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    visited.add(next);
                    System.out.println(next.value);
                    break;
                }
            }

        }
    }
}
