package String;


/**
 * @author AndrewElvis
 * @date 2020-03-26-12:20
 */
public class KMP {

    public static int getIndex(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] sc = s.toCharArray();
        char[] mc = m.toCharArray();
        int i = 0, j = 0;
        int[] next = getNextArray(mc);
        while (i < sc.length && j < mc.length) {
            if (sc[i] == mc[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == mc.length ? i - j : -1;
    }

    public static int[] getNextArray(char[] ms) {
        synchronized (KMP.class) {
            if (ms.length == 1) {
                return new int[]{-1};
            }
            int[] next = new int[ms.length];
            next[0] = -1;
            next[1] = 0;
            int cur = 2;
            int jump = 0;
            while (cur < ms.length) {
                if (ms[cur - 1] == ms[jump]) {
                    next[cur++] = ++jump;
                } else if (jump > 0) {
                    jump = next[jump];
                } else {
                    next[cur++] = 0;
                }
            }
            return next;
        }
    }

    public static void main(String[] args) {
        String str   = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndex(str, match));
    }
}
