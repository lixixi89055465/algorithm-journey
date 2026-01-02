# -*- coding: utf-8 -*-
# @Time : 2026/1/1 20:20
# @Author : nanji
# @Site : 
# @File : test02.py
# @Software: PyCharm
# @Comment :
# // 无重复字符的最长子串
# // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
# // 测试链接 : https://leetcode.cn/problems/longest-substring-without-repeating-characters/
class Code02_LongestSubstringWithoutRepeatingCharacters:
    def __init__(self):
        pass

    def lengthOfLongestSubstring(self, s: str):
        n = len(s)
        last = [-1 for _ in range(256)]
        ans = 0
        for r in range(n):
            l = max(l, last[s[r]] + 1)
            ans = max(ans, r - l + 1)
            last[s[r]] = r
        return ans


if __name__ == '__main__':
    solve = Code02_LongestSubstringWithoutRepeatingCharacters()
    r = solve.lengthOfLongestSubstring("abc")
    print(r)
