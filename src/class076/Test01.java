package class076;


// 让字符串成为回文串的最少插入次数
// 给你一个字符串 s
// 每一次操作你都可以在字符串的任意位置插入任意字符
// 请你返回让s成为回文串的最少操作次数
// 测试链接 : https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class Test01 {
    // 暴力尝试
    public static int minInsertions3(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s[i] == s[i + 1] ? 0 : 1;
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {


    }
}
