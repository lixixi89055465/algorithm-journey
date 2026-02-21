# -*- coding: utf-8 -*-
# @Time : 2026/1/1 15:12
# @Author : nanji
# @Site : 
# @File : test05.py
# @Software: PyCharm
# @Comment :
# // 最强祝福力场
# // 小扣在探索丛林的过程中，无意间发现了传说中"落寞的黄金之都"
# // 而在这片建筑废墟的地带中，小扣使用探测仪监测到了存在某种带有「祝福」效果的力场
# // 经过不断的勘测记录，小扣将所有力场的分布都记录了下来
# // forceField[i] = [x,y,side]
# // 表示第 i 片力场将覆盖以坐标 (x,y) 为中心，边长为 side 的正方形区域。
# // 若任意一点的 力场强度 等于覆盖该点的力场数量
# // 请求出在这片地带中 力场强度 最强处的 力场强度
# // 注意：力场范围的边缘同样被力场覆盖。
# // 测试链接 : https://leetcode.cn/problems/xepqZ5/
from typing import List


class Code05_StrongestForceField:
    def __init__(self):
        pass

    def fieldOfGreatestBlessing(self, fields: List[List[int]]):
        n = len(fields)
        xs = [0 for _ in range(n << 1)]
        ys = [0 for _ in range(n << 1)]
        k = 0
        p = 0
        for i in range(n):
            x = fields[i][0]
            y = fields[i][1]
            r = fields[i][2]
            xs[k] = (x << 1) - r
            k += 1
            xs[k] = (x << 1) + r
            k += 1
            ys[k] = (y << 1) - r
            p += 1
            ys[k] = (y << 1) + r
            p += 1
        sizex = self.sort(xs)
        sizey = self.sort(ys)
        diff = [[0 for i in range(sizey + 2)] for _ in range(sizex + 2)]
        for i in range(n):
            x = fields[i][0]
            y = fields[i][1]
            r = fields[i][2]
            a = self.rank(xs, (x << 1) - r, sizex)
            b = self.rank(xs, (x << 1) + r, sizey)
            c = self.rank(ys, (x << 1) - r, sizex)
            d = self.rank(ys, (x << 1) + r, sizey)
            self.add(diff, a, b, c, d)
        ans = 0
        for i in range(1, len(diff)):
            for j in range(1, len(diff[0])):
                diff[i][j] = diff[i - 1][j] + diff[i][j - 1] + diff[i][j] - diff[i - 1][j - 1]
                ans = max(ans, diff[i][j])
        return ans

    def add(self, diff: List[List[int]], a, b, c, d):
        diff[a][b] += 1
        diff[c + 1][b] += 1
        diff[c + 1][d + 1] += 1
        diff[a][d + 1] += 1

    def rank(self, nums: List[int], v, size):
        l = 0
        r = size - 1
        ans = 0
        while l <= r:
            m = (l + r) // 2
            if nums[m] >= v:
                ans = nums[m]
                r = m - 1
            else:
                l = m + 1
        return ans + 1

    def sort(self, nums: List[int]):
        size = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[size]:
                size = size + 1
        return size + 1
