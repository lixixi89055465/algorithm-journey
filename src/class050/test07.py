from typing import List

'''
// 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
// 测试链接 : https://leetcode.cn/problems/first-missing-positive/
'''


class Code07_FirstMissingPositive:
    def __init__(self):
        pass

    # 时间复杂度O(n)，额外空间复杂度O(1)
    def firstMissingPositive(self, arr: List[int]):
        # l的左边，都是做到i位置上放着i + 1 的区域
        # 永远盯着l位置的数字看，看能不能扩充(l + +)
        l = 0
        r = len(arr)
        while l < r:
            if arr[l] == l + 1:
                l += 1
            elif arr[l] <= l or arr[l] > r or arr[arr[l] - 1] == arr[l]:
                r -= 1
                self.swap(arr, l, r)
            else:
                self.swap(arr, l, arr[l] - 1)
        return l + 1

    def swap(self, arr, l, r):
        tmp = arr[l]
        arr[l] = arr[r]
        arr[r] = tmp
