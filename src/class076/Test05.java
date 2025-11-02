package class076;

public class Test05 {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(arr, 1, n, dp);
    }

    public static int f(int[] arr, int L, int R, int[][] dp) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L - 1] * arr[L] * arr[R + 1];
        } else {
            ans = Math.max(
                    arr[L - 1] * arr[L] * arr[R + 1] + f(arr, L + 1, R, dp),
                    arr[L - 1] * arr[R] * arr[R + 1] + f(arr, L, R - 1, dp)
            );
            for (int i = L + 1; i < R; i++) {
                ans = Math.max(ans,
                        f(arr, L, i - 1, dp) +
                                f(arr, i + 1, R, dp) +
                                arr[L - 1] * arr[i] * arr[R + 1]);
            }
        }
        dp[L][R] = ans;
        return ans;
    }

    public static int maxCoin2(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }
        int ans = 0;
        for (int L = n; L >= 1; L--) {
            for (int R = L; R <= n; R++) {
                ans = Math.max(dp[L + 1][R] + arr[L - 1] * arr[L] * arr[R + 1],
                        dp[L][R - 1] + arr[L - 1] * arr[R] * arr[R + 1]);
                for (int K = L + 1; K < R; K++) {
                    ans = Math.max(
                            ans,
                            dp[L][K - 1] + dp[K + 1][R] +
                                    arr[L - 1] * arr[K] * arr[R]
                    );
                }
            }
        }
        return dp[1][n];
    }
}
