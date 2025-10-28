package class076;

import java.util.Arrays;

// 切棍子的最小成本
// 有一根长度为n个单位的木棍，棍上从0到n标记了若干位置
// 给你一个整数数组cuts，其中cuts[i]表示你需要将棍子切开的位置
// 你可以按顺序完成切割，也可以根据需要更改切割的顺序
// 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和
// 对棍子进行切割将会把一根木棍分成两根较小的木棍
// 这两根木棍的长度和就是切割前木棍的长度
// 返回切棍子的最小总成本
// 测试链接 : https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/
public class Test04 {
    public static int minCost1(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[m + 2];
        arr[0] = 0;
        for (int i = 1; i < m + 1; i++) {
            arr[i] = cuts[i - 1];
        }
        arr[m + 1] = n;
        int[][] dp = new int[m + 2][m + 2];
        return f(arr, 0, m, dp);
    }

    private static int f(int[] arr, int L, int R, int[][] dp) {
        if (L > R) {
            return 0;
        }
        if (L == R) {
            return arr[R + 1] - arr[L - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = L; i <= R; i++) {
            ans = Math.min(ans,
                    f(arr, L, i - 1, dp) + f(arr, i + 1, R, dp));
        }
        ans += arr[R + 1] - arr[L - 1];
        dp[L][R] = ans;
        return ans;
    }

    // 严格位置依赖的动态规划
    public static int minCost2(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[m + 2];
        arr[0] = 0;
        for (int i = 1; i < m + 1; i++) {
            arr[i] = cuts[i - 1];
        }
        arr[m + 1] = n;
        int[][] dp = new int[m + 2][m + 2];
        for (int i = 1; i < m + 1; i++) {
            dp[i][i] = arr[i + 1] - arr[i - 1];
        }
        int next = 0;
        for (int L = m - 1; L >= 1; L--) {
            for (int R = L + 1; R <= m; R++) {
                next = Integer.MAX_VALUE;
                for (int K = L; K <= R; K++) {
                    next = Math.min(next, dp[L][K - 1] + dp[K + 1][R]);
                }
                dp[L][R] = next + cuts[R + 1] - cuts[L - 1];
            }
        }
        return dp[1][m];
    }
}
