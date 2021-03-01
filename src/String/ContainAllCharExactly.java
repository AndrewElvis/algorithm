package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @author AndrewElvis
 * @date 2020-04-18-13:48
 * @description str中是否出现连续子串, 其中与aim字符串中字符种类以及种类数量都相同, 返回子串首次出现的索引值
 */

public class ContainAllCharExactly {
    //暴力破解 时间复杂度O(N * M * logM)
    public static int process1(String str, String aim) {
        if (str == null || aim == null || str.length() < aim.length()) {
            return -1;
        }
        int length = aim.length();
        char[] chars = aim.toCharArray();
        Arrays.sort(chars);
        String aimSorted = Arrays.toString(chars);
        for (int i = 0; i <= str.length() - length; i++) {
            char[] array = str.substring(i, i + length).toCharArray();
            Arrays.sort(array);
            String strSorted = Arrays.toString(array);
            if (strSorted.equals(aimSorted)) {
                return i;
            }
        }
        return -1;
    }
    //优化减少了对于数组的排序 时间复杂度O(N * M)
    public static int process2(String s, String a) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] aim = a.toCharArray();
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (isCountEqual(str, i, aim)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isCountEqual(char[] str, int cur, char[] aim) {
        int[] count = new int[256];
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }
        for (int i = 0; i < aim.length; i++) {
            if (count[str[cur + i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
    //用count记录出现的字符数,用inValidTimes记录在滑动窗口中无效字符出现的次数,滑动窗口大小为a.length
    //时间复杂度O(N)
    public static int process3(String s, String a) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        int[] count = new int[256];
        char[] str = s.toCharArray();
        char[] aim = a.toCharArray();
        int M = aim.length;
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }
        int inValidTimes = 0;
        int R = 0;
        for (; R < M; R++) {
            if (count[str[R]]-- <= 0) {
                inValidTimes++;
            }
        }
        for (; R < str.length; R++) {
            //无效字符数为0时说明找到了,返回窗口开头R - M
            if (inValidTimes == 0) {
                return R - M;
            }
            //str中出现的字符在count中--,如果在减之前<=0,说明新加入的字符无效,inValidTimes++
            if (count[str[R]]-- <= 0) {
                inValidTimes++;
            }
            //窗口右边向前推进时,左边也应向前缩紧一位,并且在count计数中++,
            //如果在加之前当前count位置的值<0,说明滑动窗口向前滑动时去除的字符为无效字符,去除后inValidTimes--
            if (count[str[R - M]]++ < 0) {
                inValidTimes--;
            }
        }
        return inValidTimes == 0 ? R - M : -1;
    }

    public static String getRandomString(int possibilities, int maxSize) {
        char[] chars = new char[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return Arrays.toString(chars);
    }

    public static void main(String[] args) {
        int possible = 5;
        int strMaxSize = 20;
        int aimMaxSize = 5;
        int testTimes = 500000;
        System.out.println("test begin, test times: " + testTimes);
        //process1 : 19ms, process2 : 15ms, process : 5ms
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possible, strMaxSize);
            String aim = getRandomString(possible, aimMaxSize);
            int ans1 = process1(str, aim);
            int ans2 = process2(str, aim);
            int ans3 = process3(str, aim);
            if (ans1 != ans3 || ans2  != ans3) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test success!");
    }
}
