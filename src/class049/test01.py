# -*- coding: utf-8 -*-
# @Time : 2026/1/1 19:54
# @Author : nanji
# @Site : 
# @File : test01.py
# @Software: PyCharm
# @Comment :
from typing import List
import sys


class Code01_MinimumSizeSubarraySum:
    def minSubArrayLen(self, target=None, nums: List[int] = None):
        ans = sys.maxsize
        sum = 0
        l = 0
        for r in range(len(nums)):
            sum+=nums[r]
            while sum-nums[l]>=target:
                sum-=nums[l]
                l+=1
            if sum>=target:
                ans=min(ans,r-l+1)
        return 0 if ans==sys.maxsize else ans



if __name__ == '__main__':
    solve = Code01_MinimumSizeSubarraySum()
    solve.minSubArrayLen()
