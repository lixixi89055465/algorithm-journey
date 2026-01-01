# -*- coding: utf-8 -*-
# @Time : 2026/1/1 10:39
# @Author : nanji
# @Site : https://www.luogu.com.cn/problem/P3397
# @File : test03.py
# @Software: PyCharm
# @Comment :
class Code03_DiffMatrixLuogu:
    def __init__(self):
        MAXN = 1002
        self.diff = [[0 for _ in range(MAXN)] for _ in range(MAXN)]
        self.n = 0

    def add(self, a, b, c, d, k):
        self.diff[a][b] += k
        self.diff[a][d + 1] -= k
        self.diff[c + 1][b] -= k
        self.diff[c + 1][d + 1] += k

    def build(self):
        for i in range(1, self.n + 1):
            for j in range(1, self.n + 1):
                self.diff[i][j] += self.diff[i - 1][j] + self.diff[i][j - 1] - self.diff[i - 1][j - 1]


if __name__ == '__main__':
    n, q = [int(x) for x in input().split()]
    solve = Code03_DiffMatrixLuogu()
    for i in range(1,q + 1):
        a, b, c, d = [int(x) for x in input().split()]
        solve.add(a, b, c, d, 1)
    solve.n = n
    solve.build()
    for i in range(1, n + 1):
        print(solve.diff[i][1])
        for j in range(1, n + 1):
            print(' ' + str(solve.diff[i][j]))
        print('\n')
