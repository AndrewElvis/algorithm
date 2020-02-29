import java.util.ArrayList;

/**
 * @author AndrewElvis
 * @date 2019-11-05-19:20
 */
public class book3_1Test1 {

    public static void main(String[] args) {
        int[] original = new int[]{6, 7, 5, 6, 10, 1, 3, 7, 8, 9};
        int length = original.length;
//        ArrayList<String> sub = new ArrayList<>();
        String[] sub = new String[100];
        int no = 0;
        sub[no] = "" + original[0];
        for (int i = 0; i < length - 1; i++) {
            if (original[i+1] > original[i]) {
                sub[no] += ", " + original[i + 1];
            }else {
//                no++;
                sub[++no] = "" + original[i + 1];
            }
        }
        int maxLength = 0;
        int point = 0;
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] != null) {
                if (sub[i].length() > maxLength) {
                    maxLength = sub[i].length();
                    point = i;
                }
            }
        }
        System.out.println(sub[point]);
    }
}
