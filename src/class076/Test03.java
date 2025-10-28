package class076;

// 多边形三角剖分的最低得分
// 你有一个凸的 n 边形，其每个顶点都有一个整数值
// 给定一个整数数组values，其中values[i]是第i个顶点的值(顺时针顺序)
// 假设将多边形 剖分 为 n - 2 个三角形
// 对于每个三角形，该三角形的值是顶点标记的乘积
// 三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和
// 返回 多边形进行三角剖分后可以得到的最低分
// 测试链接 : https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/
public class Test03 {
    public static int minScoreTriangulation1(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(arr, 0, n - 1, dp);
    }

    private static int f(int[] arr, int L, int R, int[][] dp) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        int ans = Integer.MAX_VALUE;
        if (L == R || L == R - 1) {
            ans = 0;
        } else {
            for (int m = L + 1; m < R; m++) {
                ans = Math.min(
                        ans,
                        f(arr, L, m, dp) +
                                f(arr, m, R, dp) +
                                arr[L] * arr[m] * arr[R]
                );
            }
        }
        dp[L][R] = ans;
        return ans;
    }

    // 严格位置依赖的动态规划
    public static int minScoreTriangulation2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int L = n - 3; L >= 0; L--) {
            for (int R = L + 2; R < n; R++) {
                dp[L][R] = Integer.MAX_VALUE;
                for (int m = L + 1; m < R; m++) {
                    dp[L][R] = Math.min(
                            dp[L][R],
                            dp[L][m] + dp[m][R] +
                                    arr[L] * arr[m] * arr[R]
                    );
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {

    }
}
