from typing import List


class Code01_SortArrayByParityII:
    def __init__(self):
        pass

    def sortArrayByParityII(self, nums: List[int]):
        n = len(nums)
        odd = 1
        even = 0
        while odd < n and even < n:
            if (nums[n - 1] & 1) == 1:
                self.swap(nums, odd, n - 1)
                odd += 2
            else:
                self.swap(nums, even, n - 1)
                even += 2
        return nums


    def swap(self, nums, i, j):
        tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
