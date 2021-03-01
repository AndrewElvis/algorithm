import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        int index = 0;
        int res = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (index == tChars.length) break;
            if (sChars[i] == tChars[index]) {
                res = res + i + 1;
                index++;
            }
        }
        if (n < m) {
            System.out.println("No");
        } else if (index == tChars.length) {
            System.out.println("Yes");
            System.out.println(res);
        } else {
            System.out.println("No");
        }
    }
}
