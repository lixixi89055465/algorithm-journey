package class081;

import java.util.Arrays;

public class Test04 {
    public static boolean canDistribute(int[] nums, int[] quantity) {
        Arrays.sort(nums);
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                n++;
            }
        }
        int[] cnt = new int[n];
        int c = 1;
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                cnt[j++] = c;
                c = 1;
            } else {
                c++;
            }
        }
        cnt[n - 1] = c;
        int m = quantity.length;
        int[] sum = new int[1 << m];
        for (int i = 0, v, h; i < quantity.length; i++) {
            v = quantity[i];
            h = 1 << i;
            for (int j = 0; j < h; j++) {
                sum[h | j] = sum[j] + v;
            }
        }
        int[][] dp = new int[1 << m][n];
        return f(cnt, sum, (1 << m) - 1, 0, dp);


    }

    private static boolean f(int[] cnt, int[] sum, int status, int index, int[][] dp) {
        if (status == 0) {
            return true;
        }
        if (index == cnt.length) {
            return false;
        }
        if (dp[status][index] != 0) {
            return dp[status][index] == 1;
        }
        boolean ans = false;
        int k = cnt[index];
        for (int j = status; j > 0; j = (j - 1) & status) {
            if (sum[j] <= k &&
                    f(cnt, sum, status ^ j, index + 1, dp)) {
                ans = true;
                break;
            }
        }
        if (!ans) {
            ans = f(cnt, sum, status, index + 1, dp);
        }
        dp[status][index] = ans ? 1 : -1;
        return ans;
    }

    public static void main(String[] args) {

    }
}
