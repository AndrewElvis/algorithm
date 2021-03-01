import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int tmp = Math.max(X,Y);
            int multi = 2;
            int m = 1;
            while (multi < tmp) {
                multi *= 2;
                m++;
            }
            multi /= 2;
            int add = 0;
            if (X <= multi && Y > multi) {
                System.out.println(m * A);
                add = A;
            }
            if (X > multi && Y <= multi) {
                System.out.println(m * B);
                add = B;
            }
            if (X > multi && Y > multi) {
                System.out.println(m * C);
                add = C;
            }
//            int yX = 0, yY = 0;
//            if (X > multi) yX = X - multi;
//            if (Y > multi) yY = Y - multi;
//            int res = 0;

        }
    }
}
