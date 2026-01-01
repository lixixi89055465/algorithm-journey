# -*- coding: utf-8 -*-
# @Time : 2026/1/1 12:00
# @Author : nanji
# @Site : 
# @File : Test031.py
# @Software: PyCharm
# @Comment :
class Code03_DiffMatrixNowcoder:
    def __init__(self):
        MAXN = 1005
        self.diff = [[0 for _ in range(MAXN)] for _ in range(MAXN)]

    def add(self, a, b, c, d, k):
        self.diff[a][b] += k
        self.diff[a][d + 1] -= k
        self.diff[c + 1][b] -= k
        self.diff[c + 1][d + 1] += k

    def build(self):
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                self.diff[i][j] += self.diff[i - 1][j] + self.diff[i][j - 1] - self.diff[i - 1][j - 1]



if __name__ == '__main__':
    n, m, q = [int(x) for x in input().split()]
    solve = Code03_DiffMatrixNowcoder()
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            solve.add(i, j, i, j, input())

    for i in range(1, q + 1):
        a, b, c, d, k = [int(x) for x in input().split()]
        solve.add(a, b, c, d, k)
