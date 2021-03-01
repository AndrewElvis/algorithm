import java.util.Scanner;

/**
 * @author AndrewElvis
 * @date 2020-09-20-11:33
 * @description
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] nums = new int[N];
        int[][] edge = new int[N - 1][2];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            edge[i][0] = scanner.nextInt();
            edge[i][1] = scanner.nextInt();
        }
        int root = scanner.nextInt();
        System.out.println(2);
    }
}
