import sun.swing.BakedArrayList;

import javax.annotation.PostConstruct;
import java.security.Guard;
import java.util.*;

/**
 * @author AndrewElvis
 * @date 2020-09-11-22:29
 * @description
 */
class Test {
    public static int pick = 6;

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    //leetcode 374
    public static int guessNumber(int n) {
        int l = 1, r = n, mid = l + (r - l) >> 1;
        while (guess(mid) != 0) {
            if (guess(mid) == 1) {
                r = mid;
            } else {
                l = mid;
            }
            mid = l + ((r - l) >> 1);
        }
        return mid;
    }

    private static int guess(int num) {
        if (pick < num) return 1;
        else if (pick > num) return -1;
        else return 0;
    }

    public static boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        String[] str = s.split(" ");
        if (len != str.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, str[i]);
            } else {
                if (map.get(c).equals(str[i])) return false;
            }
        }
        return true;
    }

    //leetcode 67
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i)) : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i)) : 0;
            res.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0)
            res.append('1');
        res.reverse();
        return res.toString();
    }

    //leetcode 58
    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            else break;
        }
        return count;
    }

    //leetcode 7
    public static int reverse(int x) {
        int symbol = 1;
        String s = String.valueOf(x);
        if(x <= 0) {
            symbol = -1;
            s = s.substring(1);
        }

        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while(i < j) {
            swap(arr,i,j);
            i++;
            j--;
        }
        long num = Long.parseLong(new String(arr));
        if(num > Integer.MAX_VALUE) {
            return 0;
        } else {
            return symbol * (int) num;
        }
    }
    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //面试题 01.02. 判定是否互为字符重排 (easy)
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] s1Bit = new int[26];
        int[] s2Bit = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Bit[s1.charAt(i) - 'a']++;
            s2Bit[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(s1Bit[i] != s2Bit[i]) return false;
        }
        return true;
    }

    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] front = new int[len];
        front[0] = a[0];
        int[] back = new int[len];
        back[len - 1] = a[len - 1];
        for (int i = 1; i < len; i++) {
            front[i] = front[i-1] * a[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            back[i] = back[i+1] * a[i];
        }

        int[] b = new int[a.length];
        b[0] = back[1];
        b[len - 1] = front[len - 2];
        for (int i = 1; i < len-1; i++) {
            b[i] = front[i-1] * back[i+1];
        }

        return b;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            } else {
                if(map.get(num) == 2) {
                    map.remove(num);
                } else {
                    int tmp = map.get(num);
                    map.put(num,++tmp);
                }

            }

        }
        int res = -1;
        for (Integer k : map.keySet()) {
            res = k;
        }
        return res;
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
