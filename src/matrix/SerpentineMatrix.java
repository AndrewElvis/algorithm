package matrix;

/**
 * @author AndrewElvis
 * @date 2020-03-15-16:41
 */
public class SerpentineMatrix {
    //(0,1)(1,0)(0,-1)(-1,0)
    public static void process(int n, int m) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int[][] res = new int[n][m];
        for (int x = 0, y = 0, k = 1, d = 0; k <= n * m; k++) {
            res[x][y] = k;
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || res[a][b] > 0) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j]);
                if (res[i][j] > 9) {
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        process(4,4);
    }
}
