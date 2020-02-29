import java.util.Arrays;
import java.util.Stack;

/**
 * @author AndrewElvis
 * @date 2019-11-05-19:47
 */
public class book3_1Test2 {

    public static void main(String[] args) {
        book3_1Test2 book3_1Test2 = new book3_1Test2();
        int[] original = new int[]{10,9,2,5,3,7,101,18};
        book3_1Test2.increaseSub(original);
        System.out.println();
        book3_1Test2.lengthOfLIS(original);
    }

    public void increaseSub(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        int point = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
                point = i;
            }
        }
        Stack stack = new Stack();
        stack.push(nums[point]);
        for (int i = point - 1; i > 0; i--) {
            if ((dp[point] - dp[i]) == 1) {
                stack.push(nums[i]);
                point = i;
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public void lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int num : nums) {
            int i = 0, j = ans;
            while(i < j) {
                int m = (i + j) / 2;
                if(dp[m] < num) i = m + 1;
                else j = m;
            }
            dp[i] = num;
            if(ans == j) ans++;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
                System.out.print(dp[i] + " ");
            }
        }
    }
}
