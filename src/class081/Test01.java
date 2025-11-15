package class081;

import java.util.Arrays;
import java.util.List;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月10日 15:21
 * 项目名称: algorithm-journey
 * 文件名称: Test01
 * 文件描述: @Description:
 * site:
 * <p>
 * // 每个人戴不同帽子的方案数
 * // 总共有 n 个人和 40 种不同的帽子，帽子编号从 1 到 40
 * // 给你一个整数列表的列表 hats ，其中 hats[i] 是第 i 个人所有喜欢帽子的列表
 * // 请你给每个人安排一顶他喜欢的帽子，确保每个人戴的帽子跟别人都不一样，并返回方案数
 * // 由于答案可能很大，答案对 1000000007 取模
 * // 测试链接 : https://leetcode.cn/problems/number-of-ways-to-wear-different-hats-to-each-other
 */
public class Test01 {

    public static int MOD = 1000000007;

    public static int numberWays(List<List<Integer>> arr) {
        int m = 0;
        for (List<Integer> a : arr) {
            for (Integer pi : a) {
                m = Math.max(m, pi);
            }
        }
        int n = arr.size();
        int[][] dp = new int[m + 1][(1 << n)];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] hats = new int[m + 1];
        for (int pi = 0; pi < n; pi++) {
            for (Integer hat : arr.get(pi)) {
                hats[hat] |= (1 << pi);
            }
        }
        return f2(hats, m, n, 1, 0, dp);
    }

    // m : 帽子颜色的最大值, 1 ~ m
    // n : 人的数量，0 ~ n-1
    // i : 来到了什么颜色的帽子
    // s : n个人，谁没满足状态就是0，谁满足了状态就是1
    // dp : 记忆化搜索的表
    // 返回 : 有多少种方法
    private static int f1(int[] hats, int m, int n, int i, int s, int[][] dp) {
        if (s == (1 << n) - 1) {
            return 1;
        }
        if (i == m + 1) {
            return 0;
        }
        if (dp[i][s] != -1) {
            return dp[i][s];
        }
        int ans = f1(hats, m, n, i + 1, s, dp);
        int cur = hats[i];
        for (int p = 0; p < n; p++) {
            if ((cur & (1 << p)) != 0 && (s & (1 << p)) == 0) {
                ans = (ans + f1(hats, m, n, i + 1, s | (1 << p), dp)) % MOD;
            }
        }
        dp[i][s] = ans;
        return ans;
    }

    public static int f2(int[] hats, int m, int n, int i, int s, int[][] dp) {
        if (s == (1 << n) - 1) {
            return 1;
        }
        if (i == m + 1) {
            return 0;
        }
        if (dp[i][s] != -1) {
            return dp[i][s];
        }
        int ans = f2(hats, m, n, i + 1, s, dp);
        int cur = hats[i];
        int rightOne;
        while (cur != 0) {
            rightOne = (cur & -cur);
            if ((s & rightOne) == 0) {
                ans = f2(hats, m, n, i + 1, s | rightOne, dp) % MOD;
            }
            cur ^= rightOne;
        }
        dp[i][s]=ans;
        return ans;
    }

    public static void main(String[] args) {


    }
}
