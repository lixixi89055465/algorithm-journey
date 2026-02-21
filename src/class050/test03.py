from typing import List


class Code03_TrappingRainWater:
    def trap1(self, nums: List[int]):
        n = len(nums)
        lmax = [0 for i in range(n)]
        rmax = [0 for i in range(n)]
        lmax[0] = nums[0]
        for i in range(1, n):
            lmax[i] = max(lmax[i - 1], nums[i])
        rmax[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            rmax[i] = max(rmax[i + 1], nums[i])
        ans = 0
        for i in range(1, n - 1):
            ans += (max(0, min(lmax[i - 1], rmax[i + 1])) - nums[i])
        return ans

    def trap29(self, nums: List[int]):
        l = 1
        r = len(nums) - 2
        lmax = nums[0]
        rmax = nums[r + 1]
        ans = 0
        while l <= r:
            if lmax <= rmax:
                ans += max(0, lmax - nums[l])
                lmax = max(lmax, nums[l])
                l += 1
            else:
                ans += max(0, rmax - nums[r])
                rmax = max(rmax, nums[r])
                r -= 1
        return ans
