package String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author AndrewElvis
 * @date 2020-03-07-12:13
 * 获得给出字符串数组的最小拼接字符串
 */
public class StringJoint {
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));
        String[] strs2 = { "ba", "b"};
        System.out.println(lowestString(strs2));
    }
}
