# -*- coding: utf-8 -*-
# @Time : 2026/1/1 12:19
# @Author : nanji
# @Site : 
# @File : Test04.py
# @Software: PyCharm
# @Comment :
from typing import List


class Code04_StampingTheGrid:
    def __init__(self):
        pass

    def possibleToStamp(self, grid: List[List[int]], h, w) -> bool:
        n = len(grid)
        m = len(grid[0])
        sum = [[0 for i in range(m + 1)] for j in range(n + 1)]
        for i in range(n):
            for j in range(m):
                sum[i + 1][j + 1] = grid[i][j]
        self.build()
        diff = [[0 for i in range(m + 2)] for j in range(n + 2)]
        a = 1
        for c in range(a + h - 1, n + 1):
            b = 1
            for d in range(b + w - 1, m + 1):
                if self.sumRegion(a, b, c, d) == 0:
                    self.add(a, b, c, d)
                b += 1
            a += 1
        self.build()
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0 and diff[i + 1][j + 1] == 0:
                    return False
        return True

    def build(self):
        m = self.diff
        for i in range(1, len(m)):
            for j in range(1, len(m[0])):
                m[i][j] += m[i - 1][j] + m[i][j - 1] - m[i - 1][j - 1]

    def sumRegion(self, sum: List[List[int]], a, b, c, d):
        return sum[c][d] - sum[c][d - 1] - sum[a - 1][d] + sum[a - 1][b - 1]

    def add(self, a, b, c, d):
        self.diff[a][b] += 1
        self.diff[c + 1][d + 1] += 1
        self.diff[c + 1][b] -= 1
        self.diff[a][d + 1] -= 1
