package recursion;

/**
 * @author AndrewElvis
 * @date 2020-03-07-19:41
 */
public class AllPermutations {
    public static void printPermutations(String origin) {
        process(origin.toCharArray(), 0);
    }

    private static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process(str, i + 1);
            swap(str, i, j);
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        printPermutations("abc");
    }
}
