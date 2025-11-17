package class082;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月17日 10:44
 * 项目名称: algorithm-journey
 * 文件名称: Test05
 * 文件描述: @Description:
 * site:
 * <p>
 * // 买卖股票的最佳时机含手续费
 * // 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格
 * // 整数 fee 代表了交易股票的手续费用
 * // 你可以无限次地完成交易，但是你每笔交易都需要付手续费
 * // 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * // 返回获得利润的最大值
 * // 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费
 * // 测试链接 : https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class Test05 {
    public static int maxProfit(int[] prices, int fee) {
        int prepare = -prices[0] - fee;
        int done = 0;
        for (int i = 1; i < prices.length; i++) {
            done = Math.max(done, prepare + prices[i]);
            prepare = Math.max(prepare, done - prices[i] - fee);
        }
        return done;
    }

    public static void main(String[] args) {
        System.out.println("aaaaaa");
    }
}
