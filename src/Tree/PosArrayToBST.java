package Tree;

/**
 * @author AndrewElvis
 * @date 2020-04-17-15:45
 */
//将由搜索二叉树后序遍历生成的数组还原
public class PosArrayToBST {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node posArrayToBST1(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    public static Node process1(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        //初始化为L - 1, 保证左边部分一定比右边小, 防止特殊情况, 比如head的左边全是比head大, head只有右子树
        int cur = L - 1;
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                cur = i;
            }
        }
        head.left = process1(posArr, L, cur);
        head.right = process1(posArr, cur + 1, R - 1);
        return head;
    }

    public static Node posArrayToBST2(int[] posArr) {
        return process2(posArr, 0, posArr.length - 1);
    }

    public static Node process2(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        int cur = L - 1;
        int left = L;
        int right = R - 1;
        //将搜索小于head的最右点的搜索方式优化为二分查找
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] > posArr[R]) {
                right = mid - 1;
            } else {
                cur = mid;
                left = mid + 1;
            }
        }
        head.left = process1(posArr, L, cur);
        head.right = process1(posArr, cur + 1, R - 1);
        return head;
    }

    public static void main(String[] args) {
        int[] posArr = {2, 4, 3, 6 , 8, 7, 5};
        Node root = posArrayToBST2(posArr);
        System.out.println("left: " + root.left.value + " right: " + root.right.value);
    }
}
