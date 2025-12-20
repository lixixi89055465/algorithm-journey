# -*- coding: utf-8 -*-
# @Time : 2025/12/20 11:22
# @Author : nanji
# @Site : 
# @File : Code02_LargestOneBoardSquare.py
# @Software: PyCharm 
# @Comment :


class Solution:
    def largest1BorderedSquare(self, grid):
        n = len(grid)
        m = len(grid[0])
        self.build(n, m, grid)
        if self.sum(grid, 0, 0, n - 1, m - 1) == 0:
            return 0
        ans = 1
        for a in range(n):
            for b in range(m):
                c = a + ans
                d = b + ans
                k = ans + 1
                while c < n and d < m:
                    if self.sum(grid, a, b, c, d) - self.sum(grid, a + 1, b + 1, c - 1, d - 1) == (k - 1) << 2:
                        ans = k
        return ans*ans


    def build(self, n, m, grid):
        for i in range(n):
            for j in range(m):
                grid[i][j] += self.get(grid, i, j - 1) + self.get(grid, i - 1, j) - self.get(grid, i - 1, j - 1)

    def get(self, grid, i, j):
        return 0 if i <= 0 or j <= 0 else grid[i][j]

    def sum(self, g, a, b, c, d):
        return 0 if a > c else (g[c][d] - self.get(g, c, b - 1) - self.get(g, c - 1, b) + self.get(g, c - 1, b - 1))
