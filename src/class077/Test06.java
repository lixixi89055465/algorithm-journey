package class077;

import java.util.Arrays;

// 统计不同回文子序列
// 给你一个字符串s，返回s中不同的非空回文子序列个数
// 由于答案可能很大，答案对 1000000007 取模
// 测试链接 : https://leetcode.cn/problems/count-different-palindromic-subsequences/
public class Test06 {

    // 时间复杂度O(n^2)
    public static int countPalindromicSubsequences(String str) {
        int mod = 1000000007;
        char[] s = str.toCharArray();
        int n = s.length;
        int[] last = new int[256];
        int[] left = new int[n];
        return 0;
    }
}