package class077;

// 涂色 & 奇怪打印机
// 假设你有一条长度为5的木板，初始时没有涂过任何颜色
// 你希望把它的5个单位长度分别涂上红、绿、蓝、绿、红
// 用一个长度为5的字符串表示这个目标：RGBGR
// 每次你可以把一段连续的木板涂成一个给定的颜色，后涂的颜色覆盖先涂的颜色
// 例如第一次把木板涂成RRRRR
// 第二次涂成RGGGR
// 第三次涂成RGBGR，达到目标
// 返回尽量少的涂色次数
// 测试链接 : https://www.luogu.com.cn/problem/P4170
// 测试链接 : https://leetcode.cn/problems/strange-printer/
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.*;

/**
 * 664. 奇怪的打印机
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在从起始到结束的任意位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 */
public class Test02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        out.println(strangePrinter(str));
        out.flush();
        out.close();
        br.close();
    }


    // 时间复杂度O(n^3)
    // 测试链接 : https://leetcode.cn/problems/strange-printer/
    public static int strangePrinter(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        dp[n - 1][n - 1] = 1;
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = s[i] == s[i + 1] ? 1 : 2;
        }
        int ans = Integer.MAX_VALUE;
        for (int L = n - 3; L >= 0; L--) {
            for (int R = L + 1; R < n; R++) {
                if (s[L] == s[R]) {
                    dp[L][R] = dp[L][R - 1];
                } else {
                    ans = Integer.MAX_VALUE;
                    for (int m = L; m < R; m++) {
                        ans = Math.min(
                                ans,
                                dp[L][m] + dp[m + 1][R]
                        );
                        dp[L][R] = ans;
                    }
                }

            }
        }
        return dp[0][n - 1];
    }
}
