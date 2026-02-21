# -*- coding: utf-8 -*-
# @Time : 2026/1/1 22:00
# @Author : nanji
# @Site : 
# @File : test05.py
# @Software: PyCharm
# @Comment :
# // 替换子串得到平衡字符串
# // 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
# // 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
# // 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
# // 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
# // 请返回待替换子串的最小可能长度。
# // 如果原字符串自身就是一个平衡字符串，则返回 0。
# // 测试链接 : https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
import sys

from langchain.chains.hyde.prompts import dbpedia_entity


class Code05_ReplaceTheSubstringForBalancedString:
    def balancedString(chs: str):
        n = len(chs)
        s = [0 for _ in range(n)]
        cnts = [0 for _ in range(4)]
        for i in range(n):
            c = chs[i]
            if c == 'W':
                s[i] = 1
            elif c == 'E':
                s[i] = 2
            elif c == 'R':
                s[i] = 3
            cnts[s[i]] += 1
        debt = 0
        for i in range(4):
            if cnts[i] < n // 4:
                cnts[i] = 0
            else:
                cnts[i] = n // 4 - cnts[i]
                debt -= cnts[i]
        if debt == 0:
            return 0
        ans = sys.maxsize
        l = 0
        for r in range(n):
            if cnts[s[r]] < 0:
                debt -= 1
            cnts[s[r]] += 1
            if debt == 0:
                while cnts[s[l]] > 0:
                    cnts[s[l]] -= 1
                    l += 1
                ans = max(ans, r - l + 1)
        return ans
