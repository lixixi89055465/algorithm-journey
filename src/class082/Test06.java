package class082;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月17日 11:01
 * 项目名称: algorithm-journey
 * 文件名称: Test06
 * 文件描述: @Description:
 * site:
 * // 买卖股票的最佳时机含冷冻期
 * // 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格
 * // 设计一个算法计算出最大利润
 * // 在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * // 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
 * // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * // 测试链接 : https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Test06 {
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] prepare = new int[n];
        int[] done = new int[n];
        prepare[1] = Math.max(-prices[0], -prices[1]);
        done[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < n; i++) {
            done[i] = Math.max(done[i - 1], prepare[i - 1] + prices[i]);
            prepare[i] = Math.max(prepare[i - 1], done[i - 2] + prices[i]);
        }
        return done[n - 1];
    }

    // 只是把方法1做了变量滚动更新(空间压缩)
    // 并没有新的东西
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int prepare = Math.max(-prices[0], -prices[1]);
        int done2 = 0;
        int done1 = Math.max(0, prices[1] - prices[0]);
        for (int i = 2, curDone; i < n; i++) {
            curDone = Math.max(done1, prepare + prices[i]);
            prepare = Math.max(prepare, done2 - prices[i]);
            done2 = done1;
            done1 = curDone;
        }
        return done1;
    }

    public static void main(String[] args) {

    }
}
