package Tree;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author AndrewElvis
 * @date 2020-03-02-19:07
 * 将一张纸条对折n次，从上至下输出折痕的凹凸情况
 */
public class PaperFolding {

    static class Node {
        public Node left;
        public Node right;
        //1表示凸，0表示凹
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void folding(Node head, int times) {
        if (times == 1) return;
        head.left = new Node(0);
        head.right = new Node(1);
        folding(head.left, times - 1);
        folding(head.right, times - 1);
    }

    public static void printTree(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        folding(head, new Scanner(System.in).nextInt());
        printTree(head);
    }
}
