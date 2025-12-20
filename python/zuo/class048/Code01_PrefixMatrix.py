# -*- coding: utf-8 -*-
# @Time : 2025/12/20 10:06
# @Author : nanji
# @Site : 
# @File : Code01_PrefixMatrix.py
# @Software: PyCharm 
# @Comment :

class NumMatrix:
    def __init__(self, matrix: list[list[int]]):
        m, n = len(matrix), (len(matrix[0]) if matrix else 0)
        self.sums = [[0] * (n + 1) for _ in range(m)]
        _sums = self.sums
        for i in range(m):
            for j in range(n):
                _sums[i][j + 1] = _sums[i][j] + matrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        _sums=self.sums
        total=sum( _sums[i][row2+1]-_sums[i][row1] for i in range(col1,col2+1))
        return total





def numMaxtrix(matrix: list[list[int]]):
    n = len(matrix)
    m = len(matrix[0])
    sum = [[0 for _ in range(m)] for _ in range(n)]
    # for c in range(n):
    #     a = 1
    #     for d in range(m):


if __name__ == '__main__':
    print("aaaaa")
