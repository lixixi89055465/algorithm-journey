# -*- coding: utf-8 -*-
# @Time : 2026/1/1 20:45
# @Author : nanji
# @Site : 
# @File : test03.py
# @Software: PyCharm
# @Comment :
import sys


class Code03_MinimumWindowSubstring:
    def minWindow(self, s: str, t: str):
        cnts = [0 for _ in range(256)]
        for i, v in enumerate(t):
            cnts[v] -= 1
        len1 = sys.maxsize
        l = 0
        start = 0
        debt = len(t)
        for r in range(len(s)):
            if cnts[s[r]] < 0:
                debt -= 1
            cnts[s[r]] += 1
            if debt == 0:
                while cnts[s[l]] > 0:
                    cnts[s[l]] -= 1
                    l += 1
                if r - l + 1 < len1:
                    len1 = r - l + 1
                    start = l
        return 0 if len1 == sys.maxsize else s[start:start + len1]

