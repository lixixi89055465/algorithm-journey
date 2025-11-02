package class077;

// 合唱队
// 具体描述情打开链接查看
// 测试链接 : https://www.luogu.com.cn/problem/P3205
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的所有代码，并把主类名改成"Main"，可以直接通过
public class Test03 {
    public static int MAXN = 1001;

    public static int[] nums = new int[MAXN];

    public static int[][] dp = new int[MAXN][2];

    public static int n;

    public static int MOD = 19650827;

    public static void main(String[] args) {

    }

    // 时间复杂度O(n^2)
    // 严格位置依赖的动态规划
    public static int compute1() {
        int[][][] dp = new int[n + 1][n + 1][2];
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i + 1]) {
                dp[i][i + 1][0] = 1;
                dp[i][i + 1][1] = 1;
            }
        }
        for (int l = n - 2; l >= 1; l--) {
            for (int r = l + 2; r <= n; r++) {
                if (nums[l] < nums[l + 1]) {
                    dp[l][r][0] = (dp[l][r][0] + dp[l + 1][r][0]) % MOD;
                }
                if (nums[l] < nums[r]) {
                    dp[l][r][0] = (dp[l][r][0] + dp[l + 1][r][1]) % MOD;
                }
                if (nums[r] > nums[l]) {
                    dp[l][r][1] = (dp[l][r][1] + dp[l][r - 1][0]) % MOD;
                }
                if (nums[r] > nums[r - 1]) {
                    dp[l][r][1] = (dp[l][r][1] + dp[l][r - 1][1]) % MOD;
                }
            }
        }
        return (dp[1][n][0] + dp[1][n][1]) % MOD;
    }
}
