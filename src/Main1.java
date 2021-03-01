import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int P = scanner.nextInt();
        int Q = scanner.nextInt();
        scanner.nextLine();
        char[][] map = new char[N][M];
        String[] tmp = new String[N];
        for (int i = 0; i < N; i++) {
            tmp[i] = scanner.nextLine();
            map[i] = tmp[i].toCharArray();
        }
        int sN = 0, sM = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    sN = i;
                    sM = j;
                    break;
                }
            }
        }
        char[] step = scanner.nextLine().toCharArray();
        int res = 0;
        for (char c : step) {
            if (c == 'W' && sN - 1 >= 0 && map[sN - 1][sM] != '#') {
                sN = sN - 1;
                if (map[sN][sM] == 'O') {
                    res += P;
                    map[sN][sM] = '+';
                }
                if (map[sN][sM] == 'X') {
                    res -= Q;
                    map[sN][sM] = '+';
                }
                continue;
            }
            if (c == 'A' && sM - 1 >= 0 && map[sN][sM - 1] != '#') {
                sM = sM - 1;
                if (map[sN][sM] == 'O') {
                    res += P;
                    map[sN][sM] = '+';
                }
                if (map[sN][sM] == 'X') {
                    res -= Q;
                    map[sN][sM] = '+';
                }
                continue;
            }
            if (c == 'S' && sN + 1 < N && map[sN + 1][sM] != '#') {
                sN = sN + 1;
                if (map[sN][sM] == 'O') {
                    res += P;
                    map[sN][sM] = '+';
                }
                if (map[sN][sM] == 'X') {
                    res -= Q;
                    map[sN][sM] = '+';
                }
                continue;
            }
            if (c == 'D' && sM + 1 < M && map[sN][sM + 1] != '#') {
                sM = sM + 1;
                if (map[sN][sM] == 'O') {
                    res += P;
                    map[sN][sM] = '+';
                }
                if (map[sN][sM] == 'X') {
                    res -= Q;
                    map[sN][sM] = '+';
                }
                continue;
            }
        }
        System.out.println(res);
    }
}
