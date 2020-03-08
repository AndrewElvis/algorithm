package recursion;


import java.util.Arrays;

/**
 * @author AndrewElvis
 * @date 2020-03-07-19:19
 */
public class AllSubString {
    public static void printAllSubString(String origin) {
        process(origin.toCharArray(), 0, "");
    }

    private static void process(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        process(str, i + 1, res + String.valueOf(str[i]));
        process(str, i + 1, res);
    }

    public static void process1(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        process1(str, i + 1, "");


    }

    public static void main(String[] args) {
        String test = "ABC";
        printAllSubString(test);
    }
}
