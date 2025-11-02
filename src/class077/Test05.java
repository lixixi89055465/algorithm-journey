package class077;

// 合并石头的最低成本
// 有 n 堆石头排成一排，第 i 堆中有 stones[i] 块石头
// 每次 移动 需要将 连续的 k 堆石头合并为一堆，而这次移动的成本为这 k 堆中石头的总数
// 返回把所有石头合并成一堆的最低成本
// 如果无法合并成一堆返回-1
// 测试链接 : https://leetcode.cn/problems/minimum-cost-to-merge-stones/
public class Test05 {
    // 时间复杂度O(n^3)
    // 优化策略来自于观察
    // l.....r最终会变成几份其实是注定的，根本就无法改变
    // 那么也就知道，满足(n - 1) % (k - 1) == 0的情况下，
    // 0....n-1最终一定是1份，也无法改变
    // 如果l.....r最终一定是1份
    // 那么要保证l.....m最终一定是1份，m+1...r最终一定是k-1份
    // 如果l.....r最终一定是p份（p>1）
    // 那么要保证l.....m最终一定是1份，那么m+1...r最终一定是p-1份
    // 怎么保证的？枚举行为中，m += k-1很重要！
    // m每次跳k-1！
    // 如果l.....r最终一定是1份
    // 就一定能保证l.....m最终一定是1份
    // 也一定能保证m+1...r最终一定是k-1份
    // 不要忘了，加上最后合并成1份的代价
    // 如果l.....r最终一定是p份
    // 就一定能保证l.....m最终一定是1份
    // 也一定能保证m+1...r最终一定是p-1份
    // 不用加上最后合并成1份的代价
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 1) {
            return -1;
        }
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            preSum[i] = sum;
            sum += stones[i];
        }
        preSum[n] = sum;
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                ans = Integer.MAX_VALUE;
                for (int m = l; m < r; m += (k - 1)) {
                    ans = Math.min(ans, dp[l][m] + dp[m + 1][r]);
                }
                if ((r - l) % (k - 1) == 1) {
                    ans += preSum[r] - preSum[l];
                }
                dp[l][r] = ans;
            }
        }
        return dp[0][n - 1];
    }
}