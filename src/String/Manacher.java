package String;

/**
 * @author AndrewElvis
 * @date 2020-05-20-16:18
 * @description 字符串中的最长回文子串
 */
public class Manacher {
    // 将字符串转换为添加了#的字符数组
    // 以此来考虑偶数回文的情况,比如abba
    public static char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }
    // 主方法
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 转换数组
        char[] chars = manacherString(str);
        // 记录各位置的回文半径数组
        int[] pArr = new int[chars.length];
        // 当前最右的回文边界
        int R = -1;
        // 取到最右回文边界的中心
        int C = -1;
        // 记录当前最长子串的长度
        int max = Integer.MIN_VALUE;
        int start = -1;
        // 主函数遍历
        for (int i = 0; i < chars.length; i++) {
            // pArr[i]记录的是不需要遍历比较的位置
            // 如果i > R的话,不需要遍历的只有当前位置i本身,因此赋值为1,i的两侧暴力比较
            // 如果i < R的话,i在以当前C的回文之中,因此对称可以在另一条取到i'
            //      如果i'的回文左边界在C的回文左边界的内部,那末i的回文半径就与i'一致
            //      如果i'的回文左边界在C的回文左边界的外部,那末i的回文半径就是R - i
            //      如果i'的回文左边界刚好等于C的回文左边界,那末i在回文半径R - i的局域内就不需要比较一定是回文,但是区域外不能确定,所以还需要一一比较
            pArr[i] = i < R ? Math.min(R - i, pArr[2 * C - i]) : 1;
            while (i + pArr[i] < chars.length && i - pArr[i] > -1) {
                // 比较不需要比较区域的两侧位置字符是否相等
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 如果当前遍历位置的右边界大于最右边界,则更新最右边界R与此时的中心点C
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            // 检测是否需要更新最长回文长度
            max = Math.max(max, pArr[i]);
//            if (pArr[i] > max) {
//                max = pArr[i] - 1;
//                start = (i - pArr[i]) / 2 + 1;
//            }
        }
//        return str.substring(start, start + max);
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
