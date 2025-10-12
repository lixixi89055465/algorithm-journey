package class073;

import com.sun.javafx.image.IntPixelGetter;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Test01 {
    public static int findTargetSumWays1(int[] nums, int target) {
        return f1(nums, target, 0, 0);
    }

    private static int f1(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        return f1(nums, target, i + 1, sum + nums[i])
                + f1(nums, target, i + 1, sum - nums[i]);
    }

    public static int f2(int[] nums, int target, int i, int j,
                         HashMap<Integer, HashMap<Integer, Integer>> dp) {
        if (i == nums.length) {
            return j == target ? 1 : 0;
        }
        if (dp.containsKey(i) && dp.get(i).containsKey(j)) {
            return dp.get(i).get(j);
        }
        int ans = f2(nums, target, i + 1, j - nums[i], dp)
                + f2(nums, target, i + 1, j + nums[i], dp);
        dp.putIfAbsent(i, new HashMap<>());
        dp.get(i).put(j, ans);
        return ans;
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (target < -s || target > s) {
            return 0;
        }
        int n = nums.length;
        int m = s * 2 + 1;
        int[][] dp = new int[n + 1][m];
        dp[n][target + s] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = -s; j <= s; j++) {
                if (j + nums[i] + s < m) {
                    dp[i][j + s] = dp[i + 1][j + nums[i] + s];
                }
                if (j - nums[i] >= 0) {
                    dp[j][j + s] += dp[i + 1][j - nums[i] + s];
                }
            }
        }
        return dp[0][s];
    }

}