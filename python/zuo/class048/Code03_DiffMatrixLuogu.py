# -*- coding: utf-8 -*-
# @Time : 2025/12/20 20:45
# @Author : nanji
# @Site : 
# @File : Code03_DiffMatrixLuogu.py
# @Software: PyCharm 
# @Comment :
# // 二维差分模版(洛谷)
# // 测试链接 : https://www.luogu.com.cn/problem/P3397
# // 请同学们务必参考如下代码中关于输入、输出的处理
# // 这是输入输出处理效率很高的写法
# // 提交以下的code，提交时请把类名改成"Main"，可以直接通过
import sys

MAXN = 1002

diff = [[0] * MAXN for _ in range(MAXN)]


def add(a, b, c, d, k):
    diff[a][b]+=k
    diff[c+1][b]-=k;
    diff[a][d+1]-=k;
    diff[c+1][d+1]+=k;


def build():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1]


n = 0
q = 0
if __name__ == '__main__':
    line = sys.stdin.readline()
    line = line.split()
    n, q = int(line[0]), int(line[1])
    i = 1
    while i <= q:
        line = sys.stdin.readline().split()
        a, b, c, d = int(line[0]), int(line[1]), int(line[2]), int(line[3])
        add(a, b, c, d, 1)
    build()
    for i in range(1, n + 1):
        print(diff[i][1])
        for j in range(2, n + 1):
            print(' ' + diff[i][j])
        print('\n')
