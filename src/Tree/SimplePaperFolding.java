package Tree;

import java.util.Scanner;

/**
 * @author AndrewElvis
 * @date 2020-03-02-19:42
 */
public class SimplePaperFolding {

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    //i是节点的层数，N一共的层数，down == true ? 凹(0) : 凸(1)
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) return;
        printProcess(i + 1, N, true);
        System.out.print(down ? "0 " : "1 ");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        printAllFolds(new Scanner(System.in).nextInt());
    }
}
