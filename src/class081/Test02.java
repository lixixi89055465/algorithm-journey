package class081;

import java.util.Arrays;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月10日 16:32
 * 项目名称: algorithm-journey
 * 文件名称: Test02
 * 文件描述: @Description:
 * site:
 * // 最优账单平衡
 * // 给你一个表示交易的数组 transactions
 * // 其中 transactions[i] = [fromi, toi, amounti]
 * // 表示 ID = fromi 的人给 ID = toi 的人共计 amounti
 * // 请你计算并返回还清所有债务的最小交易笔数
 * // 测试链接 : https://leetcode.cn/problems/optimal-account-balancing/
 */
public class Test02 {
    // 题目说了人员编号的最大范围：0 ~ 12

    public static int MAXN = 13;

    public static int minTransfers(int[][] transactions) {
        // 加工出来的debt数组中一定不含有0
        int[]dept=debts(transactions);
        int n=dept.length;
        int[]dp=new int[1<<n];
        Arrays.fill(dp,-1);
        return n-f(dept,1<<n,0,n,dp);
    }

    private static int f(int[] dept, int set, int sum, int n, int[] dp) {
        if (dp[set] != -1) {
            return dp[set];
        }
        int ans=0;
        if ((set & (set - 1)) != 0) {
            if (sum == 0) {
                for (int i = 0; i < n; i++) {
                    if ((set & (1 << i)) != 0) {
                        ans=f(dept,set^(1<<i),sum-dept[i],n,dp);
                        break;
                    }
                }

            }else{
                for (int i = 0; i < n; i++) {
                    if ((set & (1 << i)) != 0) {
                        ans=Math.max(ans,
                                f(dept,set^(1<<i),sum-dept[i],n,dp));
                    }
                }
            }
        }
        dp[set]=ans;
        return ans;
    }


    private static int[] debts(int[][] tran) {
        int[] help = new int[MAXN];
        for (int[] tr : tran) {
            help[tr[0]] -= tr[2];
            help[tr[1]] += tr[2];
        }
        int n = 0;
        for (int num : help) {
            if (num != 0) {
                n++;
            }
        }
        int[] dept = new int[n];
        int index = 0;
        for (int num : help) {
            if (num != 0) {
                dept[index++] = num;
            }
        }
        return dept;
    }

    public static void main(String[] args) {

    }
}
