package dp;

/**
 * @author AndrewElvis
 * @date 2020-09-05-16:33
 * @description
 */
public class CuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }

    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
//        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int max = 0;
            int cur = 0;
            for(int j = 1; j < i; j++) {
                cur = dp[j] * dp[i - j];
                if(max < cur) {
                    max = cur;
                }
                if(j*(i-j)>max) {
                    max = j*(i-j);
                }
                if(dp[j]*(i-j)>max) {
                    max = dp[j]*(i-j);
                }
                if(j*(dp[i-j])>max) {
                    max = j*(dp[i-j]);
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
