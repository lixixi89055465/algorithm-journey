package class082;

public class Test03 {
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        for (int i = 1, min = prices[0]; i < n; i++) {
            min = Math.min(min, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        int[] dp2 = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp2[i] = Math.max(dp2[i], dp1[j] + prices[i] - prices[j]);
            }
            ans = Math.max(ans, dp2[i]);
        }
        return ans;
    }

    public static int maxProfits2(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        for (int i = 1, min = prices[0]; i < n; i++) {
            min = Math.min(min, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        int[] best = new int[n];
        best[0] = dp1[0] - prices[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i - 1], dp1[i] - prices[i]);
        }
        int[] dp2 = new int[n];
        for (int i = 1; i < n; i++) {
            dp2[i] = best[i] + prices[i];
            ans = Math.max(ans, dp2[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int c = maxProfits2(prices);
        System.out.println(c);

    }
}
