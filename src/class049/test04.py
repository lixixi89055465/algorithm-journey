# -*- coding: utf-8 -*-
# @Time : 2026/1/1 21:15
# @Author : nanji
# @Site : 
# @File : test04.py
# @Software: PyCharm
# @Comment :
from typing import List


class Code04_GasStation:
    def __init__(self):
        pass

    def canCompleteCircuit(gas: List[int], cost: List[int]):
        n = len(gas)
        l = 0
        r = 0
        while l < n:
            r = l
            while sum + gas[r % n] - cost[r % n] > 0:
                if r - l + 1 == n:
                    return l
                sum += (gas[r % n] - cost[r % n])
                r += 1
        return -1
