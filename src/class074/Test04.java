package class074;

import java.io.*;


// 正则表达式匹配
// 给你字符串s、字符串p
// s中一定不含有'.'、'*'字符，p中可能含有'.'、'*'字符
// '.' 表示可以变成任意字符，数量1个
// '*' 表示可以让 '*' 前面那个字符数量任意(甚至可以是0个)
// p中即便有'*'，一定不会出现以'*'开头的情况，也一定不会出现多个'*'相邻的情况(无意义)
// 请实现一个支持 '.' 和 '*' 的正则表达式匹配
// 返回p的整个字符串能不能匹配出s的整个字符串
// 测试链接 : https://leetcode.cn/problems/regular-expression-matching/
public class Test04 {
    public static boolean isMatch1(String str, String pat) {
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        return f1(s, p, 0, 0);
    }

    // s[i....]能不能被p[j....]完全匹配出来
    // p[j]这个字符，一定不是'*'
    public static boolean f1(char[] s, char[] p, int i, int j) {
        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return j + 1 < p.length && p[j + 1] == '*' && f1(s, p, i, j + 2);
            }
        } else if (j == p.length) {
            //s 有后最
            //怕没了
            return false;
        } else {
            //s 有后最
            //p 有后缀
            if (j + 1 == p.length || p[j + 1] != '*') {
                return (s[i] == p[j] || p[j] == '.') && f1(s, p, i + 1, j + 1);
            } else {
                boolean p1 = f1(s, p, i, j + 2);
                boolean p2 = (s[i] == p[j] || p[j] == '.') && f1(s, p, i + 1, j);
                return p1 || p2;
            }
        }
    }

    public static boolean isMatch2(String str, String pat) {
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        int n = s.length;
        int m = p.length;
        // dp[i][j] == 0，表示没算过
        // dp[i][j] == 1，表示算过，答案是true
        // dp[i][j] == 2，表示算过，答案是false
        int[][] dp = new int[n + 1][m + 1];
        return f2(s, p, 0, 0, dp);

    }

    private static boolean f2(char[] s, char[] p, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        boolean ans;
        if (i == s.length) {
            if (j == p.length) {
                ans = true;
            } else {
                ans = j + 1 < p.length && p[j + 1] == '*' && f2(s, p, i, j + 2, dp);
            }
        } else if (j == p.length) {
            ans = false;
        } else {
            if (j + 1 == p.length || p[j + 1] != '*') {
                ans = (s[i] == p[j] || p[j] == '.') && f2(s, p, i + 1, j + 1, dp);
            } else {
                ans = f2(s, p, i, j + 2, dp) ||
                        (
                                (
                                        s[i] == p[j] || p[j] == '.')
                                        &&
                                        f2(s, p, i + 1, j, dp)
                        );
            }
        }
        dp[i][j] = ans ? 1 : 2;
        return ans;
    }

    // 严格位置依赖的动态规划
    public static boolean isMatch3(String str, String pat) {
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        int n = s.length;
        int m = p.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = j + 1 < m && p[j + 1] == '*' && dp[n][j + 2];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j + 1 == m || p[j + 1] != '*') {
                    dp[i][j] = (s[i] == p[j] || p[j] == '.') && dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 2] ||
                            ((s[i] == p[j] || p[j] == '.') && dp[i + 1][j]);
                }
            }

        }
        return dp[0][0];
    }
}